package testNg_extra;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithAssertion {
	
	@Test
	public void demoOfHardAssert() {
		boolean status1 = true;
		boolean status2 = false;

		String a = "abc";
		String b = "pqr";
		String c = "xyz";
		String d = "pqr";

		Object obj1 = null;
		Object obj2 = new Object();
		
//		Assert.assertTrue(status1);
//		Assert.assertFalse(status2);
//		
//		Assert.assertEquals(b, a);
//		Assert.assertNotEquals(a, d);
//		
//		Assert.assertNull(obj1);
//		Assert.assertNotNull(obj2);

		SoftAssert sa = new SoftAssert();

		sa.assertTrue(status1);
		sa.assertFalse(status2);

		sa.assertEquals(b, d);
		sa.assertNotEquals(b, d);

		sa.assertNull(obj1);
		sa.assertNotNull(obj2);

		sa.assertAll();
	}

}
