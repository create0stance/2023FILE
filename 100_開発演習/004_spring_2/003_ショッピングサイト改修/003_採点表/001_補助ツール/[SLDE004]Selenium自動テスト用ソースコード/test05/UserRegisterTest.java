package jp.co.sss.shop.test05;

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
@DisplayName("05_会員登録")
public class UserRegisterTest {

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
	@Order(1)
	public void 正常系_会員登録_入力画面表示() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement registerElement = webDriver.findElement(By.cssSelector(".user_info a:nth-of-type(2)"));
		registerElement.click();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals("http://localhost:55000/shared_shop/user/regist/input", webDriver.getCurrentUrl(),
				"遷移失敗です");

	}

	@Test
	@Order(2)
	public void 正常系_会員登録_情報入力() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/regist/input");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement emailElement = webDriver.findElement(By.name("email"));
		emailElement.sendKeys("t-tanaka@test.co.jp");
		WebElement passwordElement = webDriver.findElement(By.name("password"));
		passwordElement.sendKeys("Testtest3");
		WebElement nameElement = webDriver.findElement(By.name("name"));
		nameElement.sendKeys("田中太郎");
		WebElement postalCodeElement = webDriver.findElement(By.name("postalCode"));
		postalCodeElement.sendKeys("3333333");
		WebElement addressElement = webDriver.findElement(By.name("address"));
		addressElement.sendKeys("北海道札幌市中央区中央1-1-1");
		WebElement phoneElement = webDriver.findElement(By.name("phoneNumber"));
		phoneElement.sendKeys("09033333333");

		emailElement.submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals("http://localhost:55000/shared_shop/user/regist/check", webDriver.getCurrentUrl(),
				"新規会員情報入力に失敗しています");

	}

	@Test
	@Order(3)
	public void 正常系_会員登録_トップ画面へ戻る() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/regist/input");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement backButtonElement = webDriver.findElement(By.className("back_button"));
		backButtonElement.submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// 検証
		assertEquals("http://localhost:55000/shared_shop/", webDriver.getCurrentUrl(), "画面遷移に失敗しています");

	}

	@Test
	@Order(4)
	public void 正常系_会員登録_入力画面へ戻る() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/regist/input");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement emailElement = webDriver.findElement(By.name("email"));
		emailElement.sendKeys("t-tanaka@test.co.jp");
		WebElement passwordElement = webDriver.findElement(By.name("password"));
		passwordElement.sendKeys("Testtest3");
		WebElement nameElement = webDriver.findElement(By.name("name"));
		nameElement.sendKeys("田中太郎");
		WebElement postalCodeElement = webDriver.findElement(By.name("postalCode"));
		postalCodeElement.sendKeys("3333333");
		WebElement addressElement = webDriver.findElement(By.name("address"));
		addressElement.sendKeys("北海道札幌市中央区中央1-1-1");
		WebElement phoneElement = webDriver.findElement(By.name("phoneNumber"));
		phoneElement.sendKeys("09033333333");

		emailElement.submit();

		WebElement backButtonElement = webDriver.findElement(By.className("back_button"));
		backButtonElement.submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		String inputEmail = webDriver.findElement(By.name("email")).getAttribute("value");

		// 検証
		assertEquals("http://localhost:55000/shared_shop/user/regist/input", webDriver.getCurrentUrl(),
				"画面遷移に失敗しています");
		assertEquals("t-tanaka@test.co.jp", inputEmail, "入力内容がありません");

	}

	@Test
	@Order(5)
	public void 正常系_会員登録_会員登録完了() {
		// 指定したURLに遷移する
		webDriver.get("http://localhost:55000/shared_shop/user/regist/input");

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement emailElement = webDriver.findElement(By.name("email"));
		emailElement.sendKeys("t-tanaka@test.co.jp");
		WebElement passwordElement = webDriver.findElement(By.name("password"));
		passwordElement.sendKeys("Testtest3");
		WebElement nameElement = webDriver.findElement(By.name("name"));
		nameElement.sendKeys("田中太郎");
		WebElement postalCodeElement = webDriver.findElement(By.name("postalCode"));
		postalCodeElement.sendKeys("3333333");
		WebElement addressElement = webDriver.findElement(By.name("address"));
		addressElement.sendKeys("北海道札幌市中央区中央1-1-1");
		WebElement phoneElement = webDriver.findElement(By.name("phoneNumber"));
		phoneElement.sendKeys("09033333333");

		emailElement.submit();

		// 最大3秒間、ページが完全に読み込まれるまで待つ
		webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		webDriver.findElement(By.className("send_button")).submit();

		String userName = webDriver.findElement(By.cssSelector(".user_info a:nth-of-type(1)")).getText();

		// 検証
		assertEquals("http://localhost:55000/shared_shop/user/regist/complete", webDriver.getCurrentUrl(),
				"新規会員情報入力に失敗しています");

		assertEquals("田中太郎", userName, "セッション登録に失敗しています");

	}

}
