package test;

import util.BrowserNavigation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base{
	static WebDriver driver;
	BrowserNavigation browser;
	ExtentReports extent;
	ExtentSparkReporter spark;


	@BeforeSuite
	public void beforeTest() throws InterruptedException {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/ExtentReports/TestReport.html");
		extent.attachReporter(spark);

		browser = new BrowserNavigation();
		browser.openbrowser("Chrome", "https://www.bravenet.com/login");
		driver = browser.getDriver();
	}

	@AfterSuite
	public void afterTest() {
		browser.quitBrowser();
		extent.flush();
	}

}
