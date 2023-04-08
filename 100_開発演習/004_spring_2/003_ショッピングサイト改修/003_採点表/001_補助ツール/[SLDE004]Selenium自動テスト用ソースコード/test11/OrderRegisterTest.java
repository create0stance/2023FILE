package jp.co.sss.shop.test11;

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
@DisplayName("11_注文登録")
public class OrderRegisterTest {

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

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/detail/1");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/detail/2");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();

	}

	@AfterEach
	public void quitDriver() {
		webDriver.close();
	}

	@Test
	@Order(1)
	public void 正常系_注文登録_お届け先入力() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/basket/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".user_info_form_area form:nth-of-type(1)")).submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String postalCode = webDriver.findElement(By.name("postalCode")).getAttribute("value");
		String address = webDriver.findElement(By.name("address")).getAttribute("value");
		String name = webDriver.findElement(By.name("name")).getAttribute("value");
		String phoneNumber = webDriver.findElement(By.name("phoneNumber")).getAttribute("value");

		// 検証
		assertEquals("1111111", postalCode, "届け先入力表示に失敗しています");
		assertEquals("東京都台東区4-5-6 ABCマンション5階", address, "届け先入力表示に失敗しています");
		assertEquals("一般三郎", name, "届け先入力表示に失敗しています");
		assertEquals("0123456789", phoneNumber, "届け先入力表示に失敗しています");

	}

	@Test
	@Order(2)
	public void 正常系_注文登録_支払い方法入力() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/basket/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".user_info_form_area form:nth-of-type(1)")).submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".send_button")).submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertTrue(webDriver.findElement(By.cssSelector("input[name='payMethod'][value='1']")).isSelected(),
				"支払方法表示に失敗しています");

	}

	@Test
	@Order(3)
	public void 正常系_注文登録_支払い方法から戻るボタンを押下() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/basket/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".user_info_form_area form:nth-of-type(1)")).submit();// 届け先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 支払先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".back_button")).submit();// 届け先画面へもどる

		String phoneNumber = webDriver.findElement(By.name("phoneNumber")).getAttribute("value");

		// 検証
		assertEquals("09012345678", phoneNumber, "届け先入力表示に失敗しています");

	}

	@Test
	@Order(4)
	public void 正常系_注文登録_最終確認画面を表示する() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/basket/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".user_info_form_area form:nth-of-type(1)")).submit();// 届け先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 支払先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 確認画面画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 合計金額
		String totalAmount = webDriver.findElement(By.cssSelector(".list_table tr:nth-of-type(4) td:nth-of-type(3)"))
				.getText();
		String phoneNumber = webDriver.findElement(By.cssSelector(".user_info_form_area tr:nth-of-type(4) td"))
				.getText();

		// 検証
		assertEquals("2100", totalAmount, "金額計算に失敗しています");

		assertEquals("09012345678", phoneNumber, "届け先入力表示に失敗しています");

	}

	@Test
	@Order(4)
	public void 正常系_注文登録_注文を完了する() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/basket/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".user_info_form_area form:nth-of-type(1)")).submit();// 届け先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.name("phoneNumber")).clear();
		webDriver.findElement(By.name("phoneNumber")).sendKeys("09012345678");

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 支払先画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 確認画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.cssSelector(".send_button")).submit();// 完了画面へ

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/order/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement payMethodElement = webDriver
				.findElement(By.cssSelector("table tr:nth-of-type(5) td:nth-of-type(2)"));
		WebElement totalAmountElement = webDriver
				.findElement(By.cssSelector("table tr:nth-of-type(5) td:nth-of-type(3)"));

		assertEquals("クレジットカード", payMethodElement.getText(), "注文一覧表示に失敗しています");
		assertEquals("2100", totalAmountElement.getText(), "注文一覧表示に失敗しています");

	}

}
