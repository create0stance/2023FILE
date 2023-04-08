package jp.co.sss.shop.test09;

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
@DisplayName("09_注文一覧")
public class OrderListTest {

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

	}

	@AfterEach
	public void quitDriver() {
		webDriver.close();
	}

	@Test
	@Order(1)
	public void 正常系_注文一覧表示_注文一覧を表示する() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/order/list");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement titleElement = webDriver.findElement(By.cssSelector("article .title"));

		WebElement payMethodElement = webDriver
				.findElement(By.cssSelector("table tr:nth-of-type(2) td:nth-of-type(2)"));
		WebElement totalAmountElement = webDriver
				.findElement(By.cssSelector("table tr:nth-of-type(2) td:nth-of-type(3)"));

		// 検証
		assertEquals("注文一覧", titleElement.getText(), "注文一覧表示に失敗しています");
		assertEquals("銀行振り込み", payMethodElement.getText(), "注文一覧表示に失敗しています");
		assertEquals("400", totalAmountElement.getText(), "注文一覧表示に失敗しています");

	}

}
