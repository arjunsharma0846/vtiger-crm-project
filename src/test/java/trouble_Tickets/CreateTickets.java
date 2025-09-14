package trouble_Tickets;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.TroubleTicket;

public class CreateTickets {
	public static void main(String[] args) throws InterruptedException, IOException {
		
FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		//login
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToCRM(USERNAME, PASSWORD);
		
	//	WebElement username = driver.findElement(By.name("user_name"));
	//	WebElement password = driver.findElement(By.name("user_password"));
		
	//	username.sendKeys("admin");
	//	password.sendKeys("manager");
		
	//	driver.findElement(By.id("submitButton")).click();
		
		
		//create Ticket
		
		HomePage hp = new HomePage(driver);
		hp.getTTlink().click();
		
		TroubleTicket tt = new TroubleTicket(driver);
		tt.getPlusIcon().click();
		
	//	driver.findElement(By.linkText("Trouble Tickets")).click();
	//	driver.findElement(By.cssSelector("img[title='Create Ticket...']")).click();
		
	    //ticket title 
		String title_name ="password reset";
		WebElement title =tt.gettitle();
	//	WebElement title = driver.findElement(By.name("ticket_title"));
		title.sendKeys(title_name);
		
		//select category
		WebElement category =tt.getcategory();
	//	WebElement category = driver.findElement(By.name("ticketcategories"));
		String expCategory ="Small Problem";
		Select selcategory = new Select(category);
		selcategory.selectByValue("Small Problem");
		
		//select status
		WebElement status =tt.getstatus();
	//	WebElement status = driver.findElement(By.name("ticketstatus"));
		String expstatus ="In Progress";
		Select selstatus = new Select(status);
		selstatus.selectByValue("In Progress");
		
		tt.getSaveBtn().click();
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		System.out.println("Ticket created successfully!!!");
		
//		Verification
		
		String actTitle = driver.findElement(By.id("dtlview_Title")).getText();
		if (actTitle.equals(title_name)) {
			
			System.out.println("Title Name:"+actTitle);
		}else {
			System.out.println("Title not matched!!!");
		}
		
		String categoryName = driver.findElement(By.id("dtlview_Category")).getText();
		if (categoryName.equals(expCategory)) {
			System.out.println("Category:"+categoryName);
		}else {
			System.out.println("Invalid category!!!");
		}
		
		String actStatus = driver.findElement(By.id("dtlview_Status")).getText();
	//	System.out.println("Rating:"+actRating);
		
		if (actStatus.equals(expstatus)) {
			System.out.println("Status:"+actStatus);
		}else {
			System.out.println("Invalid status!!!");
		}
		
		
		
		//logout
		
//		WebElement profile =driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		WebElement profile =hp.getProfile();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.hover(profile);
		
		hp.getSignOut().click();
		
	//	driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();	
	}

}
