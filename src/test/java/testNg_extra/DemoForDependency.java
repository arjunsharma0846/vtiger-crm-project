package testNg_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForDependency {
	
	@Test
	public void login() {
		System.out.println("Logged in");
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = "login")
	public void search() {
		System.out.println("Searched watch");
	}
	

	@Test(dependsOnMethods = "search")
	public void addTocart() {
//		Failure of testScript
		Assert.assertTrue(false);
		System.out.println("Added to cart");
	}
	
	@Test(dependsOnMethods = "addTocart", alwaysRun = true)
	public void payment() {
//		Assert.assertTrue(false);
		System.out.println("Payment successfully done !!!");
	}

}
