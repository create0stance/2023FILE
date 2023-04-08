package jp.co.sss.shop.test03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("03_表示順変更")
public class SortItemTest {

	private WebDriver webDriver;

	@BeforeEach
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		webDriver = new ChromeDriver();
	}

	@AfterEach
	public void quitDriver() {
		webDriver.close();
	}

	@Test
	public void 正常系_商品新着順画面表示_画面表示() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/list/1");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement appleElement = webDriver.findElement(By.cssSelector("table tr:nth-of-type(2) a"));
		WebElement dicElement = webDriver.findElement(By.cssSelector("table tr:nth-of-type(3) a"));
		WebElement orangeElement = webDriver.findElement(By.cssSelector("table tr:nth-of-type(4) a"));

		// 検証
		assertEquals("りんご", appleElement.getText(), "並び替えに失敗しています");
		assertEquals("辞書", dicElement.getText(), "並び替えに失敗しています");
		assertEquals("オレンジ", orangeElement.getText(), "並び替えに失敗しています");

	}

	@Test
	public void 正常系_商品売れ筋順画面表示_画面表示() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/list/2");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement appleElement = webDriver.findElement(By.cssSelector("table tr:nth-of-type(2) a"));

		// 検証
		assertEquals("りんご", appleElement.getText(), "並び替えに失敗しています");

	}

}
