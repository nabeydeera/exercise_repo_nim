package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssValues {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement deleteBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger delete']"));
		System.out.println("-------- "+deleteBtn.getText()+" button attributes -------");
		System.out.println("Get Attribute: "+deleteBtn.getAttribute("class"));
		System.out.println(deleteBtn.getCssValue("background-color"));
		System.out.println("Converted to hex: "+Color.fromString(deleteBtn.getCssValue("background-color")).asHex());
		System.out.println("Button height: "+deleteBtn.getCssValue("height"));
		System.out.println("Button width: "+deleteBtn.getCssValue("width"));
		
		
		WebElement cancelBtn = driver.findElement(By.cssSelector("button[type='reset']"));
		System.out.println("-------- "+cancelBtn.getText()+" button attributes -------");
		System.out.println(cancelBtn.getCssValue("background-color"));
		System.out.println("Converted to hex: "+Color.fromString(cancelBtn.getCssValue("background-color")).asHex());
		String cancelColor = Color.fromString(cancelBtn.getCssValue("background-color")).asHex();
		assertEquals("#f0ad4e", cancelColor);
		
		driver.quit();
	}

}
