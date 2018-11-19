package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class archive_project {
	
static WebDriver driver;

@BeforeTest
public void OpenBrower()
{
	String path = System.getProperty("user.dir"); 
	System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
	
//	Open browser
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.get("http://staging.aceinvoice.com/sign_in");
	
//	Login
	driver.findElement(By.name("email")).sendKeys("prabhakar+test@bigbinary.com");
	driver.findElement(By.name("password")).sendKeys("welcome");
	driver.findElement(By.name("login")).click();
	
//	Navigating to project page
	driver.findElement(By.xpath("//a[@title='Projects']")).click();

}

//Test for Archiving project.
	@Test
	public void Archive()
	{
	
//	Verifying Archive button and Archive label
	Boolean ArchiveButton = driver.findElement(By.xpath("//div[@class='table-actions-left']/button")).isDisplayed();
	assertTrue(ArchiveButton);
	
//	Verifying Active button
	Boolean ActiveButton = driver.findElement(By.xpath("//div[@class='filter-wrap']/span")).isDisplayed();
	assertTrue(ActiveButton);
		
//	Clicking on Active button
	driver.findElement(By.xpath("//div[@class='filter-wrap']/span")).click();
	
//	Verifying Active dropdown
	String ActiveDropdown = driver.findElement(By.xpath("//div[@class='filter-wrap']/a")).getText();
	assertEquals(ActiveDropdown, "Archived");
	
//	Verifying project name in table
	String ProjectNameLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[2]")).getText();
	assertEquals(ProjectNameLabel, "Project Name");
	
//	Verifying Client label in table
	String ClientLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[3]")).getText();
	assertEquals(ClientLabel, "Client");
	
//	Verifying Unbilled Hours  label in table
	String UnbilledHours = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[4]")).getText();
	assertEquals(UnbilledHours, "Unbilled Hours");
		
//	----Verifying Rows of Archive----
	
	Boolean ArchiveCheckbox1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/label/input")).isSelected();
	assertFalse(ArchiveCheckbox1);
	
	String ProjectName1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")).getText();
	assertEquals(ProjectName1, "New Test Project2");
	
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
	
//	Verifying after clicking on project takes to correct clicked project
	String VerifyProjectName1 = driver.findElement(By.xpath("//*[@id=\"info\"]/div[1]/div[1]/h1/span[1]")).getText();
	assertEquals(VerifyProjectName1, "New Test Project2");
	
//	Back to Project Main
	driver.navigate().back();
	
//	Verifying Client name in table
	String ClientName1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a")).getText();
	assertEquals(ClientName1, "abcd");
	
//	.Verifying unbilled hours
	String UnbilledHours1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[4]")).getText();
	assertEquals(UnbilledHours1, "00:00");
	
//	Verifying Action dropdown
	String 	Actions1 = driver.findElement(By.xpath("//button[@id='projectEditDropdown-223']")).getText();
	assertEquals(Actions1, "Actions");
	
//	Clicking on Action dropdown
	driver.findElement(By.xpath("//button[@id='projectEditDropdown-223']")).click();
	
//	Verifying Edit label in Action dropdown
	String EditInActions1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[5]/div/ul/li/a")).getText();
	assertEquals(EditInActions1, "Edit");
	
//	Verfiying Archive checkbox is Unchecked
	Boolean ArchiveCheckbox2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[1]/label/input")).isSelected();
	assertFalse(ArchiveCheckbox2);
	
//	Verifying Project name in archive OF " Test Project "
	String ProjectName2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")).getText();
	assertEquals(ProjectName2, "Test Project");
	
//  Clicking on Test Project to verify it takes to correct page
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")).click();

//	Verifying after clicking on project takes to correct clicked project
	String VerifyProjectName2 = driver.findElement(By.xpath("//*[@id=\"info\"]/div[1]/div[1]/h1/span[1]")).getText();
	assertEquals(VerifyProjectName2, "Test Project");	
	
//	Back to Project Main
	driver.navigate().back();
	
//	Verifying Client name in table
	String ClientName2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/a")).getText();
	assertEquals(ClientName2, "iamjayesh002");
	
//	Verifying unbilled hours
	String UnbilledHours2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[4]")).getText();
	assertEquals(UnbilledHours2, "00:00");
	
//	Verifying Action2 dropdown
	String 	Actions2 = driver.findElement(By.xpath("//button[@id='projectEditDropdown-223']")).getText();
	assertEquals(Actions2, "Actions");
	
//	Clicking on Action dropdown
	driver.findElement(By.xpath("//button[@id='projectEditDropdown-222']")).click();
	
//	Verifying Edit option in dropdown
	String EditInActions2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/div/ul/li/a")).getText();
	assertEquals(EditInActions2, "Edit");
	
//	Archiveing a Project --> 
//	Clicking on checkbox
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/label/input")).click();
	
//	Clicking on Archive button
	driver.findElement(By.xpath("//div[@class='table-actions-left']/button")).click();
	
//	Verifying Project is not availabe after archiveing project
	String VerifyProjectNotAvailable = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")).getText();
	assertNotEquals(VerifyProjectNotAvailable, "New Test Project2");

}

//Test for Unarchiving Project
@Test (dependsOnMethods=("Archive"))
public void Unarchive()
{
//	Clicking on active dropdown
	driver.findElement(By.xpath("//div[@class='filter-wrap']/span")).click();
		
//	Clicking on archieve
	driver.findElement(By.xpath("//div[@class='filter-wrap']/a")).click();
	
//	Verifying on correct unarchive project
	Boolean UnArchiveButton = driver.findElement(By.xpath("//div[@class='table-actions-left']/button")).isDisplayed();
	assertTrue(UnArchiveButton);

	Boolean ArchivedButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/span")).isDisplayed();
	assertTrue(ArchivedButton);

//	Clicking on archived dropdown
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/span")).click();

//	Verifying Active option in	http://staging.aceinvoice.com/organizations/e87dec6b56b90810731b/projects/archived/
	String ActiveLabel_in_Unarchive = driver.findElement(By.xpath("//div[@class='filter-wrap']/a")).getText();
	assertEquals(ActiveLabel_in_Unarchive, "Active");
	
//	Unarchiving project that was Archived
//	Verifying checkbox is Unchecked
	Boolean UnarchiveCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr/td[1]/label/input")).isSelected();
	assertFalse(UnarchiveCheckbox);

//	Clicking on checkbox to unarchive the project from Archive
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr/td[1]/label/input")).click();
	
//	Clicking on unarchive button to unarchive project which is selected in checkbox
	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();
	
//	Verifying There is no archived procject
	String NoArchivedProjectMessage = driver.findElement(By.xpath("//center/h4")).getText();
	assertEquals(NoArchivedProjectMessage, "There are no archived projects yet. View Active.");
	
// Clicking on active link to view which projects are active
	driver.findElement(By.xpath("//center/h4/a")).click();
	
//	Verifying the project is unarchived that was archived
	String VerifyProjectUnarchived = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")).getText();
	assertEquals(VerifyProjectUnarchived, "New Test Project2");

}

@AfterTest
public void CloseBrowser()
{
	driver.quit();
}
}
