package SignUP;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUP {

	static WebDriver driver;

	@BeforeClass()
	public void InvokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://staging.aceinvoice.com/sign_up");

	}

	@Test()
	public void SignUPfields() {

		// To check the *Email text dispaly on top of the email textbox.
		String Mandatoryfield = driver
				.findElement(By.xpath("//div[@class=\"form-group email required user_email\"]//label")).getText();
		assertTrue(Mandatoryfield.contains("* Email"));

		// To check email ID field/textbox is present.
		Boolean B1 = driver.findElement(By.xpath("//input[@name=\"email\"]")).isDisplayed();
		System.out.println(B1);

		// To check the Get Started button present on the page.
		Boolean B2 = driver.findElement(By.name("get_started")).isDisplayed();
		System.out.println(B2);

		// Entering the ID to get check if the next page ask for the password.
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("Abcd@gmail.com");
		driver.findElement(By.name("get_started")).click();

		// TO check the next page is loaded asking for the password.
		String Url = driver.getCurrentUrl();
		Assert.assertEquals(Url, "http://staging.aceinvoice.com/sign_up");
		System.out.println(Url);

		// To check the password textbox appears
		String Pass = driver
				.findElement(By.xpath(
						"//div[@class=\"form-wrap\"]//div//div//div//label[@class=\"control-label email required\"]"))
				.getText();
		assertTrue(Pass.contains("* Password"));
		Boolean B3 = driver.findElement(By.xpath("//input[@name=\"password\"]")).isDisplayed();
		System.out.println(B3);

		// To check confirm password field is available
		String PassConfirm = driver.findElement(By.xpath(
				"//div[@class=\"form-group password_confirmation required user_email\"]//label[@class=\"control-label password_confirmation required\"]"))
				.getText();
		assertTrue(PassConfirm.contains("* Password Confirmation"));

		// To check the textbox to confirm the password is displyed on the page.
		Boolean B4 = driver.findElement(By.xpath("//input[@name=\"password_confirmation\"]")).isDisplayed();
		System.out.println(B4);

		// To check the continue button is present on the page.

		Boolean Continuebtn = driver.findElement(By.name("continue")).isEnabled();
		System.out.println(Continuebtn);

		// To check forgot password and Sign In links are available on the page.
		Boolean B5 = driver.findElement(By.partialLinkText("Forgot")).isDisplayed();
		String Forgotpass = driver.findElement(By.partialLinkText("Forgot")).getText();
		Assert.assertEquals(Forgotpass, "Forgot Password");
		System.out.println(B5);

		Boolean B6 = driver.findElement(By.partialLinkText("in")).isDisplayed();
		System.out.println(B6);
		String SignIN = driver.findElement(By.partialLinkText("in")).getText();
		assertTrue(SignIN.contains("Sign in"));

	}

}
