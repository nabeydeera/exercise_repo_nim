package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.BrowserNavigation;

public class DifferentXpaths {
	static BrowserNavigation browser;
	static WebDriver driver;
	
	@FindBy(xpath = "//h2[text()='Get started for free']") WebElement headerTxt;
	@FindBy(xpath = "//span[text()='Sign up with Google']") WebElement btnGoogle;
	@FindBy(xpath = "//span[text()='Sign up with Github']") WebElement btnGithub;
	@FindBy(xpath = "//input[@id='email']") WebElement txtEmail;
	@FindBy(xpath = "//span[text()='Show']")
	WebElement txtShowHide;
	
	
	
//	public DifferentXpaths(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}

	
	@Test
	public void signUp() {
		System.out.println(headerTxt.getText());
	}

	@Test
	public void assertTest() throws Exception {
		 	
		
		
	
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(driver.getTitle(), "Sign up for free | Cross Browser Testing Tool | LambdaTest", "Assertion message");
			//softAssert.assertEquals(headerTxt.getText(), "Get started for free");
		
			String headerText = driver.findElement(By.xpath("//h2[text()='Get started for free']")).getText();
			System.out.println("header text:"+headerText);
			
			softAssert.assertAll();
			Thread.sleep(3000);
			
			browser.quitBrowser();
			
		
	}
	
}
