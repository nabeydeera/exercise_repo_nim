package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePopUps {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//to disable notifications from the browser
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://www.justdial.com/");
		Thread.sleep(3000);
		*/

		//pop up on the top, without using switch to alert but using Explicit wait
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		/*driver.get("https://omayo.blogspot.com/p/page7.html");
		driver.findElement(By.id("alert1")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2000);
		*/
		
		
		//handle the pop up with Javascript executor
		driver.get("https://omayo.blogspot.com/p/page7.html");
		driver.findElement(By.id("alert1")).click();
		Thread.sleep(2000);
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.alert=function(){return true;}");
		} catch (UnhandledAlertException e) {
			System.out.println("Handled the alert exception");
		}
		
		Thread.sleep(2000);
		
		
		
		
		driver.quit();
	}

}
