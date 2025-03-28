package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserNavigation;

public class HiddenElement_AutoComplete {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	public static void main(String[] args) throws InterruptedException {
		  browser = new BrowserNavigation();
		  browser.openbrowser("Chrome", "https://jqueryui.com/autocomplete/");
		  driver = browser.getDriver();

		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		  WebElement tags = driver.findElement(By.xpath("//input[@id='tags']"));
		  tags.sendKeys("t");
		  
		  List<WebElement> autoList = driver.findElements(By.xpath("//div[contains(@class,'ui-menu-item-wrapper')]"));
		  
		  for (WebElement e : autoList) {
			System.out.println(e.getText());
		}
		  
		  Thread.sleep(3000);
		  browser.quitBrowser();

	}
}
