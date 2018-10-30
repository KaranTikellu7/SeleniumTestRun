package AceInvoice_Tests.src.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ssignup {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shree\\Desktop\\cypress QA tests\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://staging.aceinvoice.com/sign_up");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("iamjayesh02@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jayesh");
		driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("jayesh");
		driver.findElement(By.xpath("//input[@name='continue']")).click();
		
		driver.findElement(By.xpath("//input[@name='user[first_name]']")).sendKeys("jayesh");
		driver.findElement(By.xpath("//input[@name='user[last_name]']")).sendKeys("jawale");
		
		Select time_zone = new Select (driver.findElement(By.xpath("//select[@name='user[time_zone]']")));
		time_zone.selectByVisibleText("(GMT-09:00) Alaska");
		
		Select date_format = new Select (driver.findElement(By.xpath("//select[@name='user[date_format]']")));
		date_format.selectByVisibleText("dd/mm/yyyy");
		
		Select start_week = new Select (driver.findElement(By.xpath("//select[@name='user[start_of_week]']")));
		start_week.selectByVisibleText("sunday");
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("jayesh");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jawalejayesh123@gmail.com");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		
		
		
		
		

	}

}
