package test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeDifferentElements {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowserForTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1400, 1200));
		driver.get("https://omayo.blogspot.com/");
	}
	
	//click on a hidden element
	@Test
	public void hiddenElementClick() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.querySelector('#hbutton').click()");
		System.out.println("Hidden element clicked with JavascriptExecutor");
	}
	
	//How to interact with input box giving coordinates to click at a position
	@Test
	public void inputBox() throws InterruptedException {
		WebElement inputB = driver.findElement(By.xpath("//input[@name='textboxn']"));
		Actions a = new Actions(driver);
		a.moveToElement(inputB, 1, 2).click().perform();
		Thread.sleep(3000);

				inputB.sendKeys("Testing inputbox"+Keys.ENTER);
				Thread.sleep(3000);
				
	}
	
	//using nth-of-type in CSS selector
	@Test
	public void nthType() {
		WebElement listEle = driver.findElement(By.cssSelector("div.widget-content>ol>li:last-of-type"));
		System.out.println("Ordered list last text: "+listEle.getText());
	}
	
	//Get the link text of the links on a web page
	@Test
	public void linkTextofLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> iterator = allLinks.iterator(); 
		while (iterator.hasNext()) {
			WebElement webElement = iterator.next();
			String linkName = webElement.getText(); 
			System.out.println("Title of link : "+(linkName.isEmpty() ? "No Text" : linkName ));
			
		}
	}
	
	@AfterTest
	public void browserClose() {
		driver.quit();
	
	}
	
}
