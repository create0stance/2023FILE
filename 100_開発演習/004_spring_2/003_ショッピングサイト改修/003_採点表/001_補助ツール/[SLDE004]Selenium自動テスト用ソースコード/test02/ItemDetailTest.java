package jp.co.sss.shop.test02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
@DisplayName("02_商品詳細表示")
public class ItemDetailTest {

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
	public void 正常系_商品詳細表示_画面遷移() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		List<WebElement> itemElement = webDriver.findElements(By.tagName("a"));
		WebElement targetElement = null;
		for (WebElement element : itemElement) {
			if (element.getAttribute("href").contains("/shared_shop/item/detail/1")) {
				targetElement = element;
			}
		}

		targetElement.click();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals(webDriver.getCurrentUrl(), "http://localhost:55000/shared_shop/item/detail/1", "失敗です");

	}

	@Test
	public void 正常系_商品詳細表示_商品表示() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/item/detail/1");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement itemElement = webDriver.findElement(By.className("item_detail_list"));

		// 検証
		assertTrue(itemElement.getText().contains("りんご"), "りんごが表示されていません");
		assertTrue(itemElement.getText().contains("100"), "100が表示されていません");
		assertTrue(itemElement.getText().contains("在庫あり"), "在庫ありが表示されていません");

	}

}
