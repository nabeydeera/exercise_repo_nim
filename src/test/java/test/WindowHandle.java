package test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.google.inject.PrivateBinder;

import util.BrowserNavigation;

public class WindowHandle {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	public static void main(String[] args) throws InterruptedException {
		  browser = new BrowserNavigation();
		  browser.openbrowser("Chrome", "https://www.hyrtutorials.com/p/window-handles-practice.html");
		  driver = browser.getDriver();
		  
		  String parentWindow = driver.getWindowHandle();
		  System.out.println("Parent Window: "+parentWindow);
		  
		  WebElement newWindow = driver.findElement(By.id("newWindowBtn"));
		  newWindow.click();
		  Set<String> allWindows = driver.getWindowHandles();
		  for (String h : allWindows) {
			if(!h.equals(parentWindow)) {
				driver.switchTo().window(h);
				WebElement fName = driver.findElement(By.xpath("//input[@id='firstName']"));
				Actions a = new Actions(driver);
				a.moveToElement(fName);
				fName.sendKeys("Nimeka");
				Thread.sleep(1000);
				driver.close();
			}
		}
		  driver.switchTo().window(parentWindow);
		  driver.findElement(By.id("name")).sendKeys("Parent window");
		  
		  Thread.sleep(3000);
		  browser.quitBrowser();

	}
}
