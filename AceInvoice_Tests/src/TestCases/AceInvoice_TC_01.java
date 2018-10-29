package TestCases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AceInvoice_TC_01 {

		static WebDriver driver;
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\selenium 64 bit\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://staging.aceinvoice.com/sign_in/");
			
					
		}

	}
