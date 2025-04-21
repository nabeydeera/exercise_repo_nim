package test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.BrowserNavigation;

public class DropDowns {
	static BrowserNavigation browser;
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		browser = new BrowserNavigation();

		String url = "https://freelance-learn-automation.vercel.app/signup";
		browser.openbrowser("Chrome", url);
		driver = browser.getDriver();
		
		WebElement dropDownMultiSelect = driver.findElement(By.xpath("//select[@id='hobbies']"));
		Select multiSelect = new Select(dropDownMultiSelect);
		System.out.println("Is it a multiSelect drop down? "+multiSelect.isMultiple());
	
		multiSelect.selectByValue("Reading");
		multiSelect.selectByIndex(1);
		multiSelect.selectByVisibleText("Dancing");
		System.out.println("The selected option for index 2: "+multiSelect.getFirstSelectedOption().getText());
		//Thread.sleep(5000);
		
		//Print the values in the drop down
		List<WebElement> options = multiSelect.getOptions();
		for (int i = 1; i < options.size(); i++) {
			System.out.println("Print option "+i+" : "+options.get(i).getText());
			multiSelect.selectByIndex(i);
		}
		
		synchronized (driver) {
			driver.wait(3000);	
			}
		multiSelect.deselectAll();
		
		
		//Thread.sleep(3000);
		browser.quitBrowser();
		
		
	}

}
