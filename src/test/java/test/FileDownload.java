package test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePreference = new HashMap<String, Object>();
		chromePreference.put("profile.default_content_settings.popups", 0);
		String downloadFilePath = System.getProperty("user.dir");
		chromePreference.put("download.default_directory", downloadFilePath );
		options.setExperimentalOption("prefs", chromePreference);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://omayo.blogspot.com/p/page7.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.linkText("ZIP file")).click();
		driver.quit();
		
	}

}
