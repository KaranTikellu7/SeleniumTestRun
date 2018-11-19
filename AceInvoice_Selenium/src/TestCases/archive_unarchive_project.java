package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class archive_unarchive_project {

	static WebDriver driver;
	
	@Test()
	public void openbrowser()
	{

		String path = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
		
//		Open browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://staging.aceinvoice.com/sign_in");
		
//		Login
		driver.findElement(By.name("email")).sendKeys("prabhakar+test@bigbinary.com");
		driver.findElement(By.name("password")).sendKeys("welcome");
		driver.findElement(By.name("login")).click();
		
//		Navigating to project page
		driver.findElement(By.xpath("//a[@title='Projects']")).click();
		
//		Verify Landing on Project Page
		String projectLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[1]/div[1]/h1")).getText();
		assertEquals(projectLabel, "Projects");	
		
		driver.findElement(By.xpath("//div[@class='button-container']/a")).click();
		
//		Verify landing on Add new project page
		String AddNewProjectLabel = driver.findElement(By.xpath("//div[@class='page-header-left']/h1")).getText();
		assertEquals(AddNewProjectLabel, "Add New Project");	
		
//		Verifying Client label
		String ClientLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/label")).getText();
		assertEquals(ClientLabel, "Client");
		
//		Verify Client Dropdown is present
		Boolean ClientDropdown = driver.findElement(By.xpath("//select[@name='client_id']")).isDisplayed();
		assertTrue(ClientDropdown);
		
		driver.findElement(By.xpath("//select[@name='client_id']")).click();
		
//		Verify list in dropdown
		
		String Dropdown = driver.findElement(By.xpath("//option[@value='223']")).getText();
		assertEquals(Dropdown, "J");
				
		String Dropdown1 = driver.findElement(By.xpath("//option[@value='222']")).getText();
		assertEquals(Dropdown1, "abcd");
		
		String Dropdown2 = driver.findElement(By.xpath("//option[@value='221']")).getText();
		assertEquals(Dropdown2, "iamjayesh002");
		
		String Dropdown3 = driver.findElement(By.xpath("//option[@value='217']")).getText();
		assertEquals(Dropdown3, "iamjayesh02");
		
		String Dropdown4 = driver.findElement(By.xpath("//option[@value='224']")).getText();
		assertEquals(Dropdown4, "p");
		
//		Selecting Client from dropdown
		driver.findElement(By.xpath("//select[@name='client_id']")).click();
		driver.findElement(By.xpath("//option[@value='222']")).click();
		
//		Verifying Name Label and Textbox
		String NameLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/label")).getText();
		assertEquals(NameLabel, "Name");
	
		Boolean NameTextbox = driver.findElement(By.xpath("//input[@name='project_name']")).isDisplayed();
		assertTrue(NameTextbox);
		
//		Entering name in textbox
		driver.findElement(By.xpath("//input[@name='project_name']")).sendKeys("Test Project2");
	
//		Billing Method label and dropdown
		
		String BillingMethodLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[1]/div[2]/div/label")).getText();
		assertEquals(BillingMethodLabel, "Billing Method");
		
		Boolean BillingMethodTextbox = driver.findElement(By.xpath("//select[@name='billing_method']")).isDisplayed();
		assertTrue(BillingMethodTextbox);
		
		String Billing_Dropdown1 = driver.findElement(By.xpath("//option[@value='hourly_project_rate']")).getText();
		assertEquals(Billing_Dropdown1, "Hourly project rate");
		
		String Billing_Dropdown2 = driver.findElement(By.xpath("//option[@value='hourly_person_rate']")).getText();
		assertEquals(Billing_Dropdown2, "Hourly person rate");
		
		String Billing_Dropdown3 = driver.findElement(By.xpath("//option[@value='hourly_task_rate']")).getText();
		assertEquals(Billing_Dropdown3, "Hourly task rate");
		
		String Billing_Dropdown4 = driver.findElement(By.xpath("//option[@value='flat_project_amount']")).getText();
		assertEquals(Billing_Dropdown4, "Flat project amount");
		
//		Selecting Billing Method from Dropdown
		driver.findElement(By.xpath("//select[@name='billing_method']")).click();
		driver.findElement(By.xpath("//option[@value='hourly_person_rate']")).click();
		
//		Verifying Task label		
		String TaskLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[1]")).getText();
		assertEquals(TaskLabel, "Tasks");
		
//		Verifying Task-Name Column heading
		String Task_NameLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/thead/tr/th[1]")).getText();
		assertEquals(Task_NameLabel, "Name");
		
//		Verifying Task-Billable Column heading		
		String Task_Billabel_Label = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/thead/tr/th[2]")).getText();
		assertEquals(Task_Billabel_Label,"Billable");
		
//		Verifying Meeting Textbox Row
		Boolean MeetingTextbox = driver.findElement(By.xpath("//input[@value='Meeting']")).isDisplayed();
		assertTrue(MeetingTextbox);

//		**********************************************************************************************************************************
//		WebElement	MeetingTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		MeetingTextboxMessage.getAttribute("Meeting");
		
//		*************************************************************************************************************************************
		
		Boolean BillableCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/input")).isSelected();
		assertTrue(BillableCheckbox);
		
		Boolean DeleteButton1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[3]/a/i\r\n")).isDisplayed();
		assertTrue(DeleteButton1);
		
//		Verifying Project management textbox column
		Boolean Project_Management_Textbox = driver.findElement(By.xpath("//input[@value='Project Management']")).isDisplayed();
		assertTrue(Project_Management_Textbox);
		
		//************************ 	PLEASE REVIEW LATER*******************************************		
//		WebElement	Project_ManagementTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		Project_ManagementTextboxMessage.getAttribute("Project Management");
//		System.out.println(Project_ManagementTextboxMessage);
		
		
		Boolean Project_ManagementCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/input")).isSelected();
		assertTrue(Project_ManagementCheckbox);
		
		Boolean DeleteButton2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[3]/a/i\r\n")).isDisplayed();
		assertTrue(DeleteButton2);
		
//		Verifying Design textbox column
		Boolean DesignTextbox = driver.findElement(By.xpath("//input[@value='Design']")).isDisplayed();
		assertTrue(DesignTextbox);
		
		//************************ 	PLEASE REVIEW LATER*******************************************		
//		WebElement	Project_ManagementTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		Project_ManagementTextboxMessage.getAttribute("Design");

		Boolean DesignCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[3]/td[2]/input")).isSelected();
		assertTrue(DesignCheckbox);
		
		Boolean DeleteButton3 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[3]/td[3]/a/i")).isDisplayed();
		assertTrue(DeleteButton3);
		
//		Verifying DEVELOPMENT textbox column
		Boolean DevelopmentTextbox = driver.findElement(By.xpath("//input[@value='Development']")).isDisplayed();
		assertTrue(DevelopmentTextbox);
		
		//************************ 	PLEASE REVIEW LATER*******************************************		
//		WebElement	Project_ManagementTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		Project_ManagementTextboxMessage.getAttribute("Design");

		Boolean DevelopmentCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[4]/td[2]/input")).isSelected();
		assertTrue(DevelopmentCheckbox);
		
		Boolean DeleteButton4 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[4]/td[3]/a/i")).isDisplayed();
		assertTrue(DeleteButton4);

//		Verifying QA textbox column
		Boolean QATextbox = driver.findElement(By.xpath("//input[@value='QA']")).isDisplayed();
		assertTrue(QATextbox);
		
		//************************ 	PLEASE REVIEW LATER*******************************************		
//		WebElement	Project_ManagementTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		Project_ManagementTextboxMessage.getAttribute("Design");

		Boolean QACheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[5]/td[2]/input")).isSelected();
		assertTrue(QACheckbox);
		
		Boolean DeleteButton5 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[5]/td[3]/a/i")).isDisplayed();
		assertTrue(DeleteButton5);

//	Add task***********************************************************************************************************8
/*		
//		Verifying add text label
		String AddTaskLabel = driver.findElement(By.xpath("//div[@class='table-actions-left']/a[@class='btn btn-table-action']")).getText();
		assertEquals(AddTaskLabel,"Add task");
		
//		Clicking on Add task
		driver.findElement(By.xpath("//a[@class='btn btn-table-action']/i")).click();
		
//		Verifying new added Textbox 
		Boolean NewTextbox = driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[6]/td[1]/input")).isDisplayed();
		assertTrue(NewTextbox);
		
		driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[6]/td[1]/input")).sendKeys("Reviewing");
		
		
		//************************ 	PLEASE REVIEW LATER*******************************************		
//		WebElement	Project_ManagementTextboxMessage= driver.findElement(By.xpath("//input[@value='Meeting']"));
//		Project_ManagementTextboxMessage.getAttribute("Design");

		Boolean NewTaskCheckbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[6]/td[2]/input")).isSelected();
		assertTrue(NewTaskCheckbox);


		Boolean NewDeleteButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[6]/td[3]/a/i")).isDisplayed();
		assertTrue(NewDeleteButton);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[6]/td[3]/a/i")).click();
		
		
//		**************** Add code for pop window********************************************************************************
		
//		End of TASK ********************************************************************************************************************************************8
		
*/		
//		Team memebers
		
//		Verifying Team members label
		String TeamMembersLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[1]")).getText();
		assertEquals(TeamMembersLabel,"Team Members");
		
//		Verifying Add new Memeber
		String AddNewMembersLabel = driver.findElement(By.xpath("//div[@class='form-group mb-0']/label")).getText();
		assertEquals(AddNewMembersLabel,"Add New Member");
		
		Boolean Select_Team_Member_Dropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div/select")).isDisplayed();
		assertTrue(Select_Team_Member_Dropdown);
		
		String Team_Member_Dropdown = driver.findElement(By.xpath("//option[@value='471']")).getText();
		assertEquals(Team_Member_Dropdown, "prabhakar test");
	
		Boolean Add_all_members_button = driver.findElement(By.xpath("//div[@class='actions-wrap d-flex align-items-end']/a")).isDisplayed();
		assertTrue(Add_all_members_button);
	
		String AddMembersLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div/a")).getText();
		assertEquals(AddMembersLabel, "Add all team members");
		
//		Clicking on Add all new members
		driver.findElement(By.xpath("//div[@class='actions-wrap d-flex align-items-end']/a")).click();
		
//		Verifying Table headings after clicking on add all new members
		String NameLabel_Add_member = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/table/thead/tr/th[1]")).getText();
		assertEquals(NameLabel_Add_member, "Name");

//	Verifying Hourly rate
		String HourlyRate = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/table/thead/tr/th[2]")).getText();
		assertTrue(HourlyRate.contains("Hourly Rate"));
	
		Boolean HourlyRateTextbox = driver.findElement(By.xpath("//td//input[@name='hourlyRate']")).isDisplayed();
		assertTrue(HourlyRateTextbox);
		
		driver.findElement(By.xpath("//td//input[@name='hourlyRate']")).clear();
		driver.findElement(By.xpath("//td//input[@name='hourlyRate']")).sendKeys("20");
		
		String ProjectManagerLabel = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/table/thead/tr/th[3]")).getText();
		assertEquals(ProjectManagerLabel, "Project Manager?");

		String TeamMember = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/table/tbody/tr/td[1]")).getText();
		assertEquals(TeamMember, "prabhakar test");
		
//		Clicking on checkbox in add new members 
		driver.findElement(By.xpath("//input[@name='role']")).click();

		
//		Verifying checkbox is selected
		Boolean MemberCheckbox = driver.findElement(By.xpath("//input[@name='role']")).isSelected();
		assertTrue(MemberCheckbox);
		
		Boolean MemberDeleteButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div[3]/div[2]/table/tbody/tr/td[4]/div/a/i")).isDisplayed();
		assertTrue(MemberDeleteButton);
		
		Boolean SubmitButton = driver.findElement(By.xpath("//button[@data-disable-with='Submitting...']")).isDisplayed();
		assertTrue(SubmitButton);

		Boolean CancelButton = driver.findElement(By.xpath("//div[@class='form-actions']/a")).isDisplayed();
		assertTrue(CancelButton);
		
//		Clicking on submit button
		driver.findElement(By.xpath("//button[@data-disable-with='Submitting...']")).click();
		
		
//	Verifying after submitting landing on correct project page..	
		String ProjectLabel = driver.findElement(By.xpath("//a[@class='breadcrumb-link active']")).getText();
		assertEquals(ProjectLabel, "Project");
		
		
//		EDIT FRAMEWORK
//		Verifying EDIT Button
		Boolean EditButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']")).isDisplayed();
		assertTrue(EditButton);
		
//		clicking on edit button
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
//		Verifying After clicking on edit button landing on correct EDIT page
		String EditPage = driver.findElement(By.xpath("//div[@class='page-header-left']/h1")).getText();
		assertEquals(EditPage, "Project	> Test Project2 > Edit");
		
		
//		Clicking on Name textbox and making changes in textbox
		driver.findElement(By.xpath("//div[@class='field-value']/input[@name='project_name']")).click();
		driver.findElement(By.xpath("//div[@class='field-value']/input[@name='project_name']")).sendKeys("New Test Project2");
//		Clicking on submit after editing current Project
		driver.findElement(By.xpath("//div[@class='form-actions']/button")).click();
		
//		Verifying after editing landing on info page
		String InfoPage = driver.findElement(By.xpath("//*[@id=\"info\"]/div[1]/div[1]/h1/span[2]	")).getText();
		assertEquals(InfoPage, "info");
		
		
//		Verifying Project name is changed
		String ProjectNameEdited = driver.findElement(By.xpath("//*[@id=\"info\"]/div[2]/div[2]/div/div[2]/div[2]")).getText();
		assertEquals(ProjectNameEdited, "New Test Project2");
		
//		Going on Project page
		driver.findElement(By.xpath("//a[@class='breadcrumb-link active']")).click();
		
//		Verifying landing on correct page
		String MainProjectPage = driver.findElement(By.xpath("//div[@class='page-header-left']/h1")).getText();
		assertEquals(MainProjectPage, "Projects");
		
	
		
//		driver.quit();
		
	}

}
	