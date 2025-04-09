package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import util.BrowserNavigation;

public class ExecuteXpath {
	static BrowserNavigation browser;
	static WebDriver driver;
	DifferentXpaths differentXpaths;
	
	@BeforeTest
	public void beforeRun() {
		browser = new BrowserNavigation();
		
		String url = "https://accounts.lambdatest.com/register";
		browser.openbrowser("Chrome", url);
		driver = browser.getDriver();
	}

}
