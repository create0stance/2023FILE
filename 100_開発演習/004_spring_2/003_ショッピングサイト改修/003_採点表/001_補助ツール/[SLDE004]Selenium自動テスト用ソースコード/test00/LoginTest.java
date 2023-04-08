package jp.co.sss.shop.test00;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
@DisplayName("00_ログイン機能")
public class LoginTest {

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
	public void 正常系_トップ画面表示_タイトル() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/");

		// 最大5秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals(webDriver.getTitle(), "トップ | シェアードショップ", "失敗です");

	}

	@Test
	public void 正常系_ログイン画面表示_ページタイトル() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/login");

		// 最大5秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals(webDriver.findElement(By.className("page_title")).getText(), "ログイン", "失敗です");

	}

	@Test
	public void 正常系_ログイン操作_画面遷移() {
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

		System.out.println(webDriver.getCurrentUrl());
		// 検証
		assertEquals("http://localhost:55000/shared_shop/", webDriver.getCurrentUrl());

	}

	@Test
	public void 異常系_ログイン操作_エラーメッセージ出力() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/login");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement email = webDriver.findElement(By.name("email"));
		email.clear();

//		WebElement password = webDriver.findElement(By.name("password"));
//		password.clear();

		webDriver.findElement(By.className("input")).submit();

		List<WebElement> errElements = webDriver.findElements(By.className("error_list"));

		List<String> errMsgs = new ArrayList<String>();

		for (WebElement errMsg : errElements) {
			errMsgs.add(errMsg.getText());
		}

		// 検証
		assertTrue(errMsgs.contains("メールアドレスは必須項目です。"));

	}

}
