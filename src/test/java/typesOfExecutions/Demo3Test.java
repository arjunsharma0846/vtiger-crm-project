package typesOfExecutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3Test {
	@Parameters("bro")
	@Test

	public void case3(String browser) throws InterruptedException {
		WebDriver driver = null;

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("https://qspiders.com/");

		Thread.sleep(3000);
		driver.quit();
		// System.out.println("Hi Arjun!!! How are you?");
	}

}
