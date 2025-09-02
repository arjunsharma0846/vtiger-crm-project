package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileInputStream fis = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
        FileInputStream fis2 = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("orgName");

		String orgName = sh.getRow(2).getCell(0).getStringCellValue() + (int) (Math.random() * 9999);
		System.out.println(orgName);
		
		double phnnum = sh.getRow(2).getCell(1).getNumericCellValue();
		System.out.println(phnnum);
		
		String expRating = sh.getRow(2).getCell(2).getStringCellValue();
		System.out.println(expRating);
		
		
		
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
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		
		//create Organization
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
//		String orgName ="qspider_"+(int)(Math.random()*9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		
//		String phnnum ="+91"+(long)(Math.random()*999999999);
		WebElement phonefield = driver.findElement(By.id("phone"));
		phonefield.sendKeys("9897247672");
		
		WebElement rating = driver.findElement(By.name("rating"));
		
		
//		String expRating ="Project Cancelled";
		Select selrating = new Select(rating);
		selrating.selectByValue("Project Cancelled");
		
//		WebElement sel1 =selrating.getFirstSelectedOption();
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
//		Verification
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully!!!");
			System.out.println("Organization Name:"+actOrgName);
		}else {
			System.out.println("Organization could not be created successfully!!!");
		}
		
		String phoneName = driver.findElement(By.id("dtlview_Phone")).getText();
		if (phoneName.equals(phnnum)) {
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
		
		WebElement profile =driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}
	


}
