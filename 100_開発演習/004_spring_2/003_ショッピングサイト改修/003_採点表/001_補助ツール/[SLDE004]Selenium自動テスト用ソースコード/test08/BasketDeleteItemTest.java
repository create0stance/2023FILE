package jp.co.sss.shop.test08;

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
@DisplayName("08_買い物かごの商品削除")
public class BasketDeleteItemTest {

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
	public void 正常系_買い物かご表示_買い物かごの商品を一つ削除する() {

		// 3回繰り返す
		for (int i = 0; i < 3; i++) {
			// 指定したURLに遷移する
			webDriver.get("http://localhost:55000/shared_shop/item/detail/1");

			// 最大3秒間、ページが完全に読み込まれるまで待つ
			webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

			webDriver.findElement(By.className("send_button")).submit();

		}

		webDriver.findElement(By.className("delete")).submit();

		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement appleLinkElement = webDriver.findElement(By.cssSelector("table tr:nth-of-type(2) a"));
		WebElement appleStockElement = webDriver
				.findElement(By.cssSelector("table tr:nth-of-type(2) td:nth-of-type(2)"));

		// 検証
		assertEquals("りんご", appleLinkElement.getText(), "商品登録に失敗しています");
		assertEquals("2", appleStockElement.getText(), "商品登録に失敗しています");

	}

	@Test
	@Order(2)
	public void 正常系_買い物かご表示_買い物かごの商品を0にする() {

		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/detail/1");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();

		webDriver.findElement(By.cssSelector("table .delete")).submit();

		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement msgElement = webDriver.findElement(By.cssSelector("article div p"));
		String msg = msgElement.getText();

		// 検証
		assertEquals("現在、お客様の買い物かごには商品がありません。商品をお選びください。", msg, "メッセージ表示失敗です");

	}

	@Test
	@Order(3)
	public void 正常系_買い物かご表示_買い物かごの商品を空にする() {

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

		webDriver.findElement(By.cssSelector(".user_info_form_area .delete")).submit();

		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement msgElement = webDriver.findElement(By.cssSelector("article div p"));
		String msg = msgElement.getText();

		// 検証
		assertEquals("現在、お客様の買い物かごには商品がありません。商品をお選びください。", msg, "メッセージ表示失敗です");

	}

}
