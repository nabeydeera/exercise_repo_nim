package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserNavigation;

public class TootTipHover {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	public static void main(String[] args) throws InterruptedException {
		  browser = new BrowserNavigation();
		  browser.openbrowser("Chrome", "https://jqueryui.com/tooltip/");
		  driver = browser.getDriver();

		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		  WebElement tooltipText = driver.findElement(By.xpath("//a[normalize-space()='Tooltips']"));
		  
		  //take the title attribute and print before Actions class if the toot tip text goes away when hover over
		  System.out.println("Tool Tip text: "+tooltipText.getAttribute("title"));
		  Actions a = new Actions(driver);
		  a.moveToElement(tooltipText).build().perform();
  
		  //JavascriptExecutor js = (JavascriptExecutor)driver;
		  //js.executeScript("window.scrollBy(0,1500)"); //not working. use movetoelement instead
		 
		  
		  Thread.sleep(3000);
		  browser.quitBrowser();

	}
}
