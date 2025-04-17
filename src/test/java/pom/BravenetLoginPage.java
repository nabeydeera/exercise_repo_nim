package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.JCommander.Builder;

import test.HandlingKeyboardKeys;

public class BravenetLoginPage {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id = "userid")
	WebElement userInput;
	
	@CacheLookup
	@FindBy(id = "password")
	WebElement passInput;
	
	@CacheLookup
	@FindBy(xpath = "//button[@class='md-button md-accent md-raised md-theme-default']/div/span[@class='md-button-content']")
	WebElement loginBtn;
	
	public BravenetLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	

	public void loginSendKeys(String username, String password) {
		System.out.println("Using send keys method without Keyboard keys");
		userInput.clear();
		userInput.sendKeys(username);
		
		passInput.clear();
		passInput.sendKeys(password);
		
		loginBtn.click();
		
	}
	
	public void loginUsingKeyboardKeys(String username, String password) {
		System.out.println("Using Keyboard Action class");
		userInput.clear();
		Actions seriesOfActions = new Actions(driver);
		seriesOfActions.moveToElement(userInput)
		.click()
		.keyDown(userInput, Keys.SHIFT)
		.sendKeys(userInput, username)
		.keyUp(userInput, Keys.SHIFT)
		.build()
		.perform();
		
		
		passInput.clear();
		seriesOfActions.moveToElement(userInput)
		.click()
		.keyDown(passInput, Keys.SHIFT)
		.sendKeys(passInput, password)
		.keyUp(passInput, Keys.SHIFT)
		.build()
		.perform();
		
		loginBtn.click();
		
	}


	public void loginUsingRobotMethods(String username, String password) throws AWTException, InterruptedException {
		System.out.println("Using Robot class");
		userInput.clear();
		
		Actions seriesOfActions = new Actions(driver);
		seriesOfActions.moveToElement(userInput)
		.click()
		.keyDown(userInput, Keys.SHIFT)
		.sendKeys(userInput, username)
		.keyUp(userInput, Keys.SHIFT)
		.build()
		.perform();
		
		
		passInput.clear();
		seriesOfActions.moveToElement(userInput)
		.click()
		.keyDown(passInput, Keys.SHIFT)
		.sendKeys(passInput, password)
		.keyUp(passInput, Keys.SHIFT)
		.build()
		.perform();
		Thread.sleep(1000);
		
		Robot rObj	= new Robot();
		//rObj.keyPress(KeyEvent.VK_TAB);
		rObj.keyPress(KeyEvent.VK_ENTER);
		//loginBtn.click();
		
	}

	public void cookiesContainer() {
		WebDriverWait wait = new WebDriverWait(driver, 30);//new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement closeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(text(),'close')]")));
		closeIcon.click();
	}

}
