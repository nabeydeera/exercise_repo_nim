package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import util.BrowserNavigation;

public class ExecuteXpathSoftAssert {
	BrowserNavigation browser;
	WebDriver driver;
	DifferentXpaths differentXpaths;
	
	@BeforeTest
	public void beforeRun() {
		browser = new BrowserNavigation();
		
		String url = "https://accounts.lambdatest.com/register";
		browser.openbrowser("Chrome", url);
		driver = browser.getDriver();
	}
	
	@Test
	public void assertTest() throws Exception {
	 	differentXpaths = new DifferentXpaths(driver);
		SoftAssert softAssert = new SoftAssert();
		//softAssert.assertEquals(driver.getTitle(), "Sign up for| free | Cross Browser Testing Tool | LambdaTest", "Assertion message");
		
		softAssert.assertEquals(differentXpaths.sectionHeading(), "Get started for free");
		
		//softAssert.assertEquals(differentXpaths.enterEmail(), "test@email.com");
		Thread.sleep(2000);
		WebElement signTextPara = driver.findElement(By.xpath("//div[contains(text(),'By clicking Sign Up')]"));
				//driver.findElement(By.cssSelector("div.leading-5"));
		
		
		System.out.println("sign in text: "+signTextPara.getText());
		softAssert.assertEquals(signTextPara.getText(), "By clicking Sign Up or registering through a third party you accept the LambdaTest Terms of Service and acknowledge the Privacy Policy and Cookie Policy","Paragraph text is incorrect: ");
		String text = differentXpaths.signUpBtn().toLowerCase();
		softAssert.assertEquals(text, "sign up", "Failed:Sign up button text is different: ");

		softAssert.assertAll("Assert All Failed logs:");

		

}
	@AfterTest
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(3000);
		browser.quitBrowser();
	}
}

