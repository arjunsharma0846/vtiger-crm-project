package testNg_extra;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Facebook_ExtentRep {
	@Test
	
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HH-mm-ss");
		String time = now.format(dtf);
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./Extend_Reports/"+time+".html");
		spark.config().setDocumentTitle("FaceBook_Report");
		spark.config().setReportName("FirstReport");
		spark.config().setTheme(Theme.STANDARD);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "11");

		ExtentTest test = report.createTest("Login");

		test.log(Status.INFO, "This Is INFO.....");
		test.log(Status.WARNING, "This Is WARNING.....");
		test.log(Status.SKIP, "This Is SKIPPED.....");
		test.log(Status.PASS, "This Is PASSED.....");
		test.log(Status.FAIL, "This Is FAILED.....");
		
		
		TakesScreenshot tks = (TakesScreenshot)driver;
		String ss=tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "Ye Raha ScreenShot");

		
		
		report.flush();
		driver.quit();


	}

}
