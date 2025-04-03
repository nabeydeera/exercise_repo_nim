package test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import util.BrowserNavigation;

public class DifferentXpaths {
	static BrowserNavigation browser;
	static WebDriver driver;

	public static void main(String[] args) {
		 	browser = new BrowserNavigation();
		
			String url = "https://accounts.lambdatest.com/register";
			browser.openbrowser("Chrome", url);
			driver = browser.getDriver();
	
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(driver.getTitle(), "Sign up for free | Cross Browser Testing Tool | LambdaTest", "Assertion message");
			
			//xpath = "//h2[text()='Get started for free']"
			softAssert.assertAll();
			
			driver.quit();
		
	}
	


}
