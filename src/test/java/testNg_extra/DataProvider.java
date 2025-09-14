package testNg_extra;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider = "getData")
	public void case1(String un ,String pwd) {
		//String un1= "admin";
		//String pwd1= "manager";
		System.out.println(un);
		System.out.println(pwd);
	
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] getData(){
		
		Object[][] credentials = new Object[3][2];
		
		credentials[0][0] = "amit";
		credentials[0][1] = "amit@123";
		credentials[1][0] = "deepa";
		credentials[1][1] = "deepa@123";
		credentials[2][0] = "arjun";
		credentials[2][1] = "arjun@123";
		
		return credentials;
	}
	


}
