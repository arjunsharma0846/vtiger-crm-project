package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicket {
	
	public TroubleTicket(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title='Create Ticket...']")
	private WebElement plusIcon;

	@FindBy(name = "ticket_title")
	private WebElement title;
	
	@FindBy(name = "ticketcategories")
	private WebElement category;
	
	@FindBy(name = "ticketstatus")
	private WebElement status;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement gettitle() {
		return title;
	}
	
	public WebElement getcategory() {
		return category;
	}
	
	public WebElement getstatus() {
		return status;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
