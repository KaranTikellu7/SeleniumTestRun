package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class TestRUN1 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS );
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS );
		driver.get("http://staging.aceinvoice.com/sign_in");
		ChromeDriver driver = new ChromeDriver();
		String Variable;
		
		driver.findElementByXPath("//input[@name='email']").sendKeys("abcgmail.com");	
		driver.findElementByXPath("//input[@name='password']").sendKeys("12345");
		driver.findElementByXPath("//input[@name='login']").click();
		
		Variable = driver.findElementByXPath("//div[@class='toast-message']").getText();
		
		Assert.assertEquals(Variable, "Incorrect email or password");
		
		System.out.println("TEST CASE PASSED");
	
driver.quit();
	}

}
