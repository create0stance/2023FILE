package jp.co.sss.shop.test01;

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
@DisplayName("01_商品一覧表示")
public class ItemListTest {

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
	public void 正常系_商品一覧画面表示_画像表示() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement imgElement = webDriver.findElement(By.cssSelector(".item > a > img"));

		// 検証
		assertTrue(imgElement.getAttribute("src").contains("/shared_shop/img/apple.jpg"), "画像の読み込みに失敗しています");

	}

}
