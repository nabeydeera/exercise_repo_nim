package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UselessFileDetector;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Website with 1 open nested shadow DOM:
		driver.get("https://books-pwakit.appspot.com/");
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String textElement = "return document.querySelector('body > book-app').shadowRoot.querySelector('#input')";
		WebElement searchText = (WebElement) jse.executeScript(textElement);
		searchText.sendKeys("Name to search");
		
		System.out.println("Finished");
		Thread.sleep(2000);
		driver.quit();
		
		
		//Another website with open and close ShadowDOMs:
		/*driver.get("https://letcode.in/shadow");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String openInputBox = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
		WebElement inputBoxOne = (WebElement) jse.executeScript(openInputBox);
		inputBoxOne.sendKeys("Nimekatest");
		
		Thread.sleep(3000);
		driver.quit();
		*/
		
		
	}

}
