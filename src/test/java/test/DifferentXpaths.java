package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BrowserNavigation;

public class DifferentXpaths {
	BrowserNavigation browser;
	WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//h2[text()='Get started for free']") WebElement headerTxt;
	@CacheLookup
	@FindBy(xpath = "//span[text()='Sign up with Google']") WebElement btnGoogle;
	@CacheLookup
	@FindBy(xpath = "//span[text()='Sign up with Github']") WebElement btnGithub;
	@CacheLookup
	//@FindBy(xpath = "//input[@id='email']") WebElement txtEmail;
	@FindBy(css = "input#email") WebElement txtEmail;
	@CacheLookup
	@FindBy(xpath = "//span[text()='Show']") WebElement txtShowHide;
	@CacheLookup
	@FindBy(css = "div.leading-5") WebElement signUpText; //long text that was divided into multiple tags
	@CacheLookup
	@FindBy(css = "button[type='submit']") WebElement btnSignUp;

	public DifferentXpaths(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String sectionHeading() {
		String headerName = headerTxt.getText();
		return headerName;
	}

	public String enterEmail() {
		String email = "test@email.com";
		txtEmail.sendKeys(email);		
		return email;
	}
	
	public String signUpBtn() {
		String signUp = btnSignUp.getText();
		return signUp;
	}
}
