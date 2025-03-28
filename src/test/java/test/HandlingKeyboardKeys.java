package test;

import java.awt.AWTException;
import java.io.InputStream;
	import java.util.ArrayList;
	import java.util.Map;
	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.yaml.snakeyaml.Yaml;

	import pom.BravenetLoginPage;
	import org.testng.SkipException;
	
public class HandlingKeyboardKeys extends Base{

		public ArrayList<String> readYamlFile(String testCaseID) {
			Yaml yamlFile = new Yaml();
			InputStream inputStream = this.getClass()
					.getClassLoader()
					.getResourceAsStream("assignmentTen.yaml");
			Map<String, Object> map = yamlFile.load(inputStream);

			ArrayList<String> list = (ArrayList<String>) map.get(testCaseID);
			return list;
		}
		@Test(enabled=false)
		public void verifyLoginWithKeyboardStrokes() {
			
			BravenetLoginPage login = new BravenetLoginPage(driver);
			//throw new SkipException("Skipping this exception");
			String testCaseNumber = "";
			for(int i=1; i<=4; i++){ 
				testCaseNumber="testCase"+i;
				//reads the value from the key value pair from the yaml file
				login.loginUsingKeyboardKeys(String.valueOf(readYamlFile(testCaseNumber).get(0)), String.valueOf(readYamlFile(testCaseNumber).get(1)));
				//wait for the error message after login is clicked
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'You must login with your username')]"))));
				String expectedError = driver.findElement(By.xpath("//span[contains(text(),'You must login with your username')]")).getText();
				System.out.println("Error message '"+expectedError+"' displayed.");
				//validate the error message
				Assert.assertTrue(expectedError.equals("You must login with your username"));
			}	
		}
		
		@Test
		public void usingRobotClassForKeyStokes() throws AWTException, InterruptedException {

			BravenetLoginPage login = new BravenetLoginPage(driver);
			String testCaseNumber = "";
			for(int i=1; i<=4; i++){ 
				testCaseNumber="testCase"+i;
				//reads the value from the key value pair from the yaml file
				login.loginUsingRobotMethods(String.valueOf(readYamlFile(testCaseNumber).get(0)), String.valueOf(readYamlFile(testCaseNumber).get(1)));
			}	
			login.cookiesContainer();
		}
		


}
