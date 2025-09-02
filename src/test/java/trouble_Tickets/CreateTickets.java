package trouble_Tickets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateTickets {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		//login
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		
		
		//create Ticket
		
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.cssSelector("img[title='Create Ticket...']")).click();
		
	    //ticket title 
		String title_name ="password reset";
		WebElement title = driver.findElement(By.name("ticket_title"));
		title.sendKeys(title_name);
		
		//select category
		WebElement category = driver.findElement(By.name("ticketcategories"));
		String expCategory ="Small Problem";
		Select selcategory = new Select(category);
		selcategory.selectByValue("Small Problem");
		
		//select status
		WebElement status = driver.findElement(By.name("ticketstatus"));
		String expstatus ="In Progress";
		Select selstatus = new Select(status);
		selstatus.selectByValue("In Progress");
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
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
		
		WebElement profile =driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
