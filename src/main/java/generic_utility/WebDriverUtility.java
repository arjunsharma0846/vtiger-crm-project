package generic_utility;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void WebDriverUtility() {
		
		WebDriverUtility wutil = new WebDriverUtility();
	}
	
	public class PopupUtils {
	    public void acceptAlert(WebDriver driver) {
	        driver.switchTo().alert().accept();
	    }
	    public void dismissAlert(WebDriver driver) {
	        driver.switchTo().alert().dismiss();
	    }
	    public String getAlertText(WebDriver driver) {
	        return driver.switchTo().alert().getText();
	    }
	    public void sendAlertText(WebDriver driver, String text) {
	        driver.switchTo().alert().sendKeys(text);
	    }
	}   

}
