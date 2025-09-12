package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver , this);	
	}
	
//	@FindBy(name = "user_name")
//	private WebElement un;
	
	
	@FindAll({ @FindBy(name = "user_name"), @FindBy(id = "username"), @FindBy(css = "input[title='un']") })
	private WebElement un;

//	@FindBys({
//		@FindBy(name = "user_name"),
//		@FindBy(id = "username"),
//		@FindBy(css = "input[title='un']")
//	})
//	private WebElement un;
	
	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement logIn;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogIn() {
		return logIn;
	}
	
	
//	business utility
	public void loginToCRM(String username, String password) {
		getUn().sendKeys(username);
		getPwd().sendKeys(password);
		getLogIn().click();
	}

}
