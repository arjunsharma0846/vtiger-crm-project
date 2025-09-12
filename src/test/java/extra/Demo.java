package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	
	@Test
	public void case1() {
		
		Reporter.log("This is case 1");
	}
	
	@Test
	public void case2() {
		
		System.out.println("This is case 2");
	}
	
	@Test
	public void case3() {
		
		System.out.println("This is case 3");
	}

}
