package typesOfExecutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo5Test {
	@Test(groups ="smoke")
	
	public void case7(){
		System.out.println("I am smoke");
	}
	
@Test(groups ="smoke")
	
	public void case8(){
		System.out.println("I am smoke");
	}

@Test(groups ="reg")

public void case9(){
	System.out.println("I am regression");
}

	
}
