package jp.co.sss.shop.test14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("14_会員削除")
public class UserDeleteTest {

	private WebDriver webDriver;

	@BeforeEach
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		webDriver = new ChromeDriver();

		/* ログイン処理 */
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/login");

		// 最大5秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement email = webDriver.findElement(By.name("email"));
		email.clear();
		email.sendKeys("ippan_saburo@test.co.jp");

		WebElement password = webDriver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("Testtest2");

		webDriver.findElement(By.className("input")).submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

	}

	@AfterEach
	public void quitDriver() {
		webDriver.close();
	}

	@Test
	@Order(1)
	public void 正常系_会員削除_確認画面表示() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area .delete")).submit();// 確認画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String email = webDriver.findElement(By.cssSelector("li:nth-of-type(1) .input_value")).getText();
		String name = webDriver.findElement(By.cssSelector("li:nth-of-type(2) .input_value")).getText();
		String postalCode = webDriver.findElement(By.cssSelector("li:nth-of-type(3) .input_value")).getText();
		String address = webDriver.findElement(By.cssSelector("li:nth-of-type(4) .input_value")).getText();
		String phoneNumber = webDriver.findElement(By.cssSelector("li:nth-of-type(5) .input_value")).getText();

		// 検証
		assertEquals("ippan_saburo@test.co.jp", email, "失敗です。情報が違います");
		assertEquals("一般三郎", name, "失敗です。情報が違います");
		assertEquals("1111111", postalCode, "失敗です。情報が違います");
		assertEquals("東京都台東区4-5-6 ABCマンション5階", address, "失敗です。情報が違います");
		assertEquals("09012345678", phoneNumber, "失敗です。情報が違います");
	}

	@Test
	@Order(2)
	public void 正常系_会員削除_会員詳細へ戻る() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area .delete")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("back_button")).submit();
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals("http://localhost:55000/shared_shop/user/detail", webDriver.getCurrentUrl(),
				"失敗です。情報が違います");

	}

	@Test
	@Order(3)
	public void 正常系_会員削除_会員削除完了() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area .delete")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();// 完了画面へ
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String login = webDriver.findElement(By.cssSelector(".user_info a:nth-of-type(1)")).getText();

		// 検証
		assertEquals("ログイン", login, "失敗です。情報が違います");

	}

	@Test
	@Order(4)
	public void 異常系_会員削除_削除ユーザでログイン() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/login");

		// 最大5秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement email = webDriver.findElement(By.name("email"));
		email.clear();
		email.sendKeys("ippan_saburo@test.co.jp");

		WebElement password = webDriver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("Testtest2");

		webDriver.findElement(By.className("input")).submit();

		List<WebElement> errElements = webDriver.findElements(By.className("error_list"));

		List<String> errMsgs = new ArrayList<String>();

		for (WebElement errMsg : errElements) {
			errMsgs.add(errMsg.getText());
		}

		// 検証
		assertTrue(errMsgs.contains("メールアドレス、もしくはパスワードが間違っています。"));
	}
}
