package listeners_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseClass;

public class List_Imp implements ISuiteListener, ITestListener {

	ExtentTest test;
	ExtentReports report;

	@Override
	public void onStart(ISuite suite) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HH-mm-ss");
		String time = now.format(dtf);

		ExtentSparkReporter spark = new ExtentSparkReporter("./Extend_Reports/" + time + ".html");
		spark.config().setDocumentTitle("FaceBook_Report");
		spark.config().setReportName("FirstReport");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "11");

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Take the ss");

		test.log(Status.FAIL, "This Is FAILED.....");

		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "Error ScreenShot");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Skippeddd.......");
		test.log(Status.SKIP, "This is skipped....");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Congrats !!!");
		test.log(Status.PASS, "This is passed....");

	}

	@Override
	public void onFinish(ISuite suite) {

		report.flush();

	}

}
