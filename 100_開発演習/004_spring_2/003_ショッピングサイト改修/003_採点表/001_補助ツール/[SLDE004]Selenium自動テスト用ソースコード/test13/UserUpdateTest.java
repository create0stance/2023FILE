package jp.co.sss.shop.test13;

import static org.junit.jupiter.api.Assertions.*;

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
@DisplayName("13_会員更新")
public class UserUpdateTest {

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
	public void 正常系_会員情報更新_入力画面表示() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area form:nth-of-type(2)")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String email = webDriver.findElement(By.name("email")).getAttribute("value");
		String postalCode = webDriver.findElement(By.name("postalCode")).getAttribute("value");
		String address = webDriver.findElement(By.name("address")).getText();
		String name = webDriver.findElement(By.name("name")).getAttribute("value");
		String phoneNumber = webDriver.findElement(By.name("phoneNumber")).getAttribute("value");

		// 検証
		assertEquals("ippan_saburo@test.co.jp", email, "失敗です。情報が違います");
		assertEquals("一般三郎", name, "失敗です。情報が違います");
		assertEquals("1111111", postalCode, "失敗です。情報が違います");
		assertEquals("東京都台東区4-5-6 ABCマンション5階", address, "失敗です。情報が違います");
		assertEquals("0123456789", phoneNumber, "失敗です。情報が違います");

	}

	@Test
	@Order(2)
	public void 正常系_会員情報更新_情報更新() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area form:nth-of-type(2)")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.className("send_button")).submit();
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String phoneNumber = webDriver.findElement(By.cssSelector("li:nth-of-type(6) .input_value")).getText();

		// 検証
		assertEquals("09012345678", phoneNumber, "失敗です。情報が違います");

	}

	@Test
	@Order(3)
	public void 正常系_会員情報更新_会員詳細画面へ戻る() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area form:nth-of-type(2)")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.className("back_button")).submit();// 詳細画面へ戻る
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		String phoneNumber = webDriver.findElement(By.cssSelector("li:nth-of-type(5) .input_value")).getText();
		assertEquals("0123456789", phoneNumber, "失敗です。情報が違います");

	}

	@Test
	@Order(4)
	public void 正常系_会員情報更新_会員入力画面へ戻る() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area form:nth-of-type(2)")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.className("send_button")).submit();
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("back_button")).submit();// 入力画面へ戻る
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String phoneNumber = webDriver.findElement(By.name("phoneNumber")).getAttribute("value");

		assertEquals("09012345678", phoneNumber, "失敗です。情報が違います");
	}

	@Test
	@Order(5)
	public void 正常系_会員情報更新_会員更新完了() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".detail_button_area form:nth-of-type(2)")).submit();// 入力画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.className("send_button")).submit();// 確認画面へ
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();// 完了画面へ
		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

		String phoneNumber = webDriver.findElement(By.cssSelector("li:nth-of-type(5) .input_value")).getText();

		// 検証
		assertEquals("09012345678", phoneNumber, "失敗です。情報が違います");

	}

}
