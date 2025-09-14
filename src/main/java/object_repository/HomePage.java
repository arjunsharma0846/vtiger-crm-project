package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	@FindBy(linkText ="Trouble Tickets")
	private WebElement TTlink;
	
	public WebElement getTTlink() {
		return TTlink;
	}
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profile;
	
	public WebElement getProfile() {
		return profile;
	}
	
	@FindBy(linkText =  "Sign Out")
	private WebElement signOut;
	
	public WebElement getSignOut() {
		return signOut;
	}

}
