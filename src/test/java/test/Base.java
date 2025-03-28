package test;

import util.BrowserNavigation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base{
	 static WebDriver driver;
	 BrowserNavigation browser;
 
  @BeforeSuite
  public void beforeTest() throws InterruptedException {
	  browser = new BrowserNavigation();
	  browser.openbrowser("Chrome", "https://www.bravenet.com/login");
	  driver = browser.getDriver();
  }

  @AfterSuite
  public void afterTest() {
	  browser.quitBrowser();
  }

}
