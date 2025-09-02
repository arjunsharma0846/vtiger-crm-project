package create_email;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateEmail {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		
		//login
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		
		
		//create Email
		
		driver.findElement(By.linkText("Email")).click();
		
		
		String pid = driver.getWindowHandle();
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(2000);
		
		Set<String> IDs = driver.getWindowHandles();
		for (String i : IDs) {
			driver.switchTo().window(i);
			System.out.println(driver.getTitle());
			
			if (driver.getTitle().contains("Mail")) {
				
				break;
				
			}
		}
		
/*		driver.findElement(By.name("parent_id")).sendKeys("test@example.com");
        driver.findElement(By.name("subject")).sendKeys("Test Subject");
        driver.findElement(By.name("body")).sendKeys("This is a test email body.");

        // Click Send
        driver.findElement(By.id("sendButton")).click();
*/		
		driver.close();
		Thread.sleep(3000);
		
		driver.switchTo().window(pid);
			
		
		//logout
		
		WebElement profile =driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				
				
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
				
		driver.findElement(By.linkText("Sign Out")).click();
				
		Thread.sleep(3000);
		driver.quit();
				
				
				
				
	}

}
