package test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserNavigation;

public class DragandDropMoveTo {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	//Using Action class dranAndDrom method
	/*
	 * public static void main(String[] args) throws InterruptedException { browser
	 * = new BrowserNavigation(); browser.openbrowser("Chrome",
	 * "https://jqueryui.com/droppable/"); driver = browser.getDriver();
	 * 
	 * Actions actionDrop = new Actions(driver); WebElement link =
	 * driver.findElement(By.xpath("//a[normalize-space()='API documentation']"));
	 * actionDrop.moveToElement(link).build().perform();
	 * 
	 * 
	 * driver.switchTo().frame(driver.findElement(By.xpath(
	 * "//iframe[@class='demo-frame']"))); WebElement drag =
	 * driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"))
	 * ; WebElement drop =
	 * driver.findElement(By.xpath("//p[normalize-space()='Drop here']"));
	 * actionDrop.dragAndDrop(drag, drop).perform();
	 * 
	 * Thread.sleep(3000); browser.quitBrowser(); }
	 */	 
	
	 //Using robot class Key presses
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws InterruptedException, AWTException {
			  browser = new BrowserNavigation();
			  browser.openbrowser("Chrome", "https://jqueryui.com/droppable/");
			  driver = browser.getDriver();

			  Robot robot = new Robot(); 
			// Move the mouse to the element 
			robot.mouseMove(508,520);
			 // Press mouse button 
			  robot.mousePress(InputEvent.BUTTON1_MASK); 
			// Move the mouse to a new location (dragging) 
			robot.mouseMove(670, 570);  
			// Release the mouse button
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			  
			  Thread.sleep(3000);
			  
			  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']"))); 
			  WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
			
			  assertEquals("Dropped!", drop.getText());
			  browser.quitBrowser();

		}
	
}
