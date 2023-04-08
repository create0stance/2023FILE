package jp.co.sss.shop.test12;

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
@DisplayName("12_会員詳細")
public class UserDetailTest {

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
	public void 正常系_会員詳細表示_会員情報表示() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/detail");

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
		assertEquals("0123456789", phoneNumber, "失敗です。情報が違います");

	}

}
