package test;

import static org.testng.Assert.assertEquals;

import java.util.List;

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
		
		List<WebElement> allButtons = driver.findElements(By.xpath("//*[contains(@class,'btn')]"));
		
		for(WebElement btnElement : allButtons) {
			System.out.println("-------- "+btnElement.getText()+" button attributes -------");
			System.out.println("Get Attribute: "+btnElement.getAttribute("class"));
			System.out.println("Button RGBA colors :"+btnElement.getCssValue("background-color"));
			System.out.println("Converted to hex: "+Color.fromString(btnElement.getCssValue("background-color")).asHex());
			System.out.println("Button height: "+btnElement.getCssValue("height"));
			System.out.println("Button width: "+btnElement.getCssValue("width"));
			System.out.println("Font size: "+btnElement.getCssValue("font-size"));
		}
		
		
		driver.quit();
	}

}
