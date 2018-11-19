package TestCases;

//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
//import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class Test1 {
	
	@Test
	public void MainFile(){
		
		String Variable ;
		String path = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS );
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS );
		driver.get("http://staging.aceinvoice.com/sign_in");
		
		driver.findElementByXPath("//input[@name='email']").sendKeys("abcgmail.com");	
		driver.findElementByXPath("//input[@name='password']").sendKeys("12345");
		driver.findElementByXPath("//input[@name='login']").click();
		
		Variable = driver.findElementByXPath("//div[@class='toast-message']").getText();
		
		Assert.assertEquals(Variable, "Incorrect email or password");
		
		System.out.println("TEST CASE PASSED");
		
		driver.quit();
		
	}
}
