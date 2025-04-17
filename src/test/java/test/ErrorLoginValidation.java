package test;

import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import com.aventstack.extentreports.MediaEntityBuilder;

import pom.BravenetLoginPage;
import util.ExtentReportClass;

public class ErrorLoginValidation extends Base{

	public ArrayList<String> readYamlFile(String testCaseID) {
		Yaml yamlFile = new Yaml();
		InputStream inputStream = this.getClass()
				.getClassLoader()
				.getResourceAsStream("assignmentTen.yaml");
		Map<String, Object> map = yamlFile.load(inputStream);

		ArrayList<String> list = (ArrayList<String>) map.get(testCaseID);
		return list;
	}
	@Test
	public void verifyLoginError() throws Exception {

		BravenetLoginPage login = new BravenetLoginPage(driver);
		ExtentReportClass report = new ExtentReportClass(extent);
		String testCaseNumber = "";
		
		for(int i=1; i<=4; i++){ 
			testCaseNumber="testCase"+i;
			//reads the value from the key value pair from the yaml file
			login.loginSendKeys(String.valueOf(readYamlFile(testCaseNumber).get(0)), String.valueOf(readYamlFile(testCaseNumber).get(1)));
			//wait for the error message after login is clicked
			WebDriverWait wait = new WebDriverWait(driver, 30); // new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'You must login with your username')]"))));
			String expectedError = driver.findElement(By.xpath("//span[contains(text(),'You must login with your username')]")).getText();
			System.out.println("Error message '"+expectedError+"' displayed.");
			//validate the error message
			Assert.assertTrue(expectedError.equals("You must login with your username"));
			
		}
		//take the screenshot and store
		report.extentReportTest1("verifyLoginError");
	}
}
