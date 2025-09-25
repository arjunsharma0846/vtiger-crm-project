package testNg_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemo {
	@Test(dataProvider ="getData")
	public void loginToSauceDemo(String username1 ,String password1) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		
		username.sendKeys(username1);
		password.sendKeys(password1);
		
		System.out.println(username1);
		System.out.println(password1);
		
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		driver.quit();	
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] credentials = new Object[4][2];
		
		credentials[0][0] = "standard_user";
		credentials[0][1] = "secret_sauce";
		credentials[1][0] = "locked_out_user";
		credentials[1][1] = "secret_sauce";
		credentials[2][0] = "problem_user";
		credentials[2][1] = "secret_sauce";
		credentials[3][0] = "performance_glitch_user";
		credentials[3][1] = "secret_sauce";
		
		return credentials;
	}
	

}
