package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;

public class CreateOrgTest {
	
	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		
		FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		String orgName = fUtil.getStringDataFromExcelFile("orgName", 2, 0) + (int)(Math.random()*9999);
		System.out.println(orgName);
		
		String value1 =fUtil.getNumericDataFromExcelFile("orgName", 1, 1);
		System.out.println(value1);
		
		
		String expRating = fUtil.getStringDataFromExcelFile("orgName", 2, 2);
		System.out.println(expRating);
		
 /*      FileInputStream fis2 = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("orgName");

		String orgName = sh.getRow(2).getCell(0).getStringCellValue() + (int) (Math.random() * 9999);
		System.out.println(orgName);
		
		
		double phnnum = sh.getRow(2).getCell(1).getNumericCellValue();
		long phnnumLong = (long) phnnum;
		String phnnumString = String.valueOf(phnnumLong);
		System.out.println(phnnumString);
		
		
		String expRating = sh.getRow(2).getCell(2).getStringCellValue();
		System.out.println(expRating);
*/
		
		
		
		WebDriver driver = null;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		//login
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToCRM(USERNAME, PASSWORD);
		
		
	//	username.sendKeys(USERNAME);
	//	password.sendKeys(PASSWORD);
	//	loginBtn.click();
		
	//	WebElement username = driver.findElement(By.name("user_name"));
	//	WebElement password = driver.findElement(By.name("user_password"));
		
	//	username.sendKeys(USERNAME);
	//	password.sendKeys(PASSWORD);
		
	//	driver.findElement(By.id("submitButton")).click();
		
		
		//create Organization
		
	//	driver.findElement(By.linkText("Organizations")).click();
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();
		WebElement orgField = op.getOrgNameField();
		orgField.sendKeys(orgName);
		
		WebElement phonefield =op.getphonefield();
		phonefield.sendKeys("9897247672");
		
		WebElement rating = op.getrating();
		
		op.getSaveBtn().click();
		
//		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
//		String orgName ="qspider_"+(int)(Math.random()*9999);
//		WebElement orgField = driver.findElement(By.name("accountname"));
//		orgField.sendKeys(orgName);
		
//		String phnnum ="+91"+(long)(Math.random()*999999999);
//		WebElement phonefield = driver.findElement(By.id("phone"));
//		phonefield.sendKeys("9897247672");
		
//		WebElement rating = driver.findElement(By.name("rating"));
		
		
//		String expRating ="Project Cancelled";
		Select selrating = new Select(rating);
		selrating.selectByValue("Project Cancelled");
		
//		WebElement sel1 =selrating.getFirstSelectedOption();
		
//		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
//		Verification
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully!!!");
			System.out.println("Organization Name:"+actOrgName);
		}else {
			System.out.println("Organization could not be created successfully!!!");
		}
		
		String phoneName = driver.findElement(By.id("dtlview_Phone")).getText();
		if (phoneName.equals(value1)) {
			System.out.println("Phone:"+phoneName);
		}else {
			System.out.println("Incorrect phone number!!!");
		}
		
		String actRating = driver.findElement(By.id("dtlview_Rating")).getText();
	//	System.out.println("Rating:"+actRating);
		
		if (actRating.equals(expRating)) {
			System.out.println("Rating Matched:"+actRating);
		}else {
			System.out.println("Rating Mismatched!!!");
		}
		
		
		
		//logout
		
	//	WebElement profile =driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		WebElement profile = hp.getProfile();
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.hover(profile);
		
		hp.getSignOut().click();
		
	//	driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}
	


}
