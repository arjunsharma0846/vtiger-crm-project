package testNG_Annotations;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Vtiger_CRM_Execution extends Config_annotation {
	
	@Test
	public void createOrg() {
		Reporter.log("Create Organization",true);
	}
	
	@Test
	public void createTicket() {
		Reporter.log("Create trouble tickets",true);
	}

}
