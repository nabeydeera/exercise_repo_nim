package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowserNavigation;

public class FileUpload {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	 
	public static void main(String[] args) throws Exception {
		  browser = new BrowserNavigation();
		  browser.openbrowser("Chrome", "https://blueimp.github.io/jQuery-File-Upload/");
		  driver = browser.getDriver();

		  WebElement addFilesBtn = driver.findElement(By.xpath("//input[@type='file']"));
		  
		  //1. Give file in File class and then getAbsolute path to the file
		  File file = new File("./test-output/failed.png");
		  System.out.println(file.getAbsolutePath());
		  addFilesBtn.sendKeys(file.getAbsolutePath());
		  
		  //2.provide the absolute path of the file directly in sendKeys
		  //addFilesBtn.sendKeys("C:\\Selenium\\Edureka\\Workspace\\Data-Driven-AssignmentTen\\target\\SignIn page.png");
	
		  Thread.sleep(3000);
		  browser.quitBrowser();
	}

}
