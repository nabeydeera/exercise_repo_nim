package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshPageCommands {


	WebDriver driver;


	@BeforeTest
	public void openBrowserForTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1400, 1200));
		driver.get("https://omayo.blogspot.com/");
	}

	@Test
	public void one() {
		driver.navigate().refresh();
	}

	@Test
	public void two() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.F5).build().perform();
		}
	
	@Test
	public void three() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location.reload();");
		}
	
	@Test
	public void four() {
	driver.get(driver.getCurrentUrl());
		}
	
	@Test
	public void five() {
	driver.navigate().to("https://omayo.blogspot.com/");
		}


	@AfterTest
	public void browserClose() {
		driver.quit();

	}


}
