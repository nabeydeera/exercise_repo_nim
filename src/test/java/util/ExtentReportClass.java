package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportClass {
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	
	public ExtentReportClass(ExtentReports extent2) {
		this.extent = extent2;
		
		}
	
	public void extentReportTest1(String testCaseName) throws Exception{
		extent.createTest("Test Case: "+testCaseName)
        .addScreenCaptureFromPath("extent.png")
        .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

	}
}
