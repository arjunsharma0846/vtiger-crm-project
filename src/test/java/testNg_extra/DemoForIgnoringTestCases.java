package testNg_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForIgnoringTestCases {
	
	@Test
	public void login() {
		System.out.println("Logged in");
	}

	@Test(alwaysRun = true,enabled = true)
	public void search() {
		System.out.println("Searched watch");
	}
	

	@Test(enabled = true)
	public void addTocart() {
//		Failure of testScript
		Assert.assertTrue(false);
		System.out.println("Added to cart");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "addTocart")
	public void payment() {
		System.out.println("Payment successfully done !!!");
	}

}
