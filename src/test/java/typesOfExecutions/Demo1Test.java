package typesOfExecutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1Test {
	@Parameters("bro")
	@Test
	public void case1(String browser) throws InterruptedException {
		WebDriver driver = null;
		
		if(browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(3000);
		driver.quit();
	//	System.out.println("Hi Arjun!!! How are you?");
	}
	
/*	public void case2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		
		Thread.sleep(3000);
	//	System.out.println("Hi Arjun!!! How are you?");
	}
	
	public void case3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://qspiders.com/");
		
		Thread.sleep(3000);
	//	System.out.println("Hi Arjun!!! How are you?");
	}
	
*/
//	WebDriver driver = new FirefoxDriver();

}
