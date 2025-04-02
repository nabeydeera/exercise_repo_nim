package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.BrowserNavigation;

public class CollectionExamples {

	static WebDriver driver;
	 static BrowserNavigation browser;
	 
	 public static void listMethod() {
		  List<WebElement> interestsCheckboxes =driver.findElements(By.xpath("//input[@type='checkbox']")); //to click all the checkboxes
		  for (WebElement chk:interestsCheckboxes) { chk.click(); }
		
		  List<WebElement> interestText =driver.findElements(By.xpath("//div[@class='interest-div']")); for
			  (WebElement ele : interestText) { System.out.println(ele.getText()); }
			 
	 }
	 
	 public static void setMethod() {
		 Set<String> set=new HashSet<String>();
		 set.add("one");
		 set.add("two");
		 set.add("one");
		 System.out.println(set.size());
		 System.out.println(set);
	 }

	 public static void mapMethod() {
		 Map<Integer, String> d = new HashMap<Integer, String>();
		 d.put(1, "one");
		 d.put(2, "two");
		 d.put(3, "three");
		 d.put(1, "one");
		 System.out.println(d.size());
		 System.out.println(d);
		 d.keySet().forEach(key -> System.out.println(d.get(key)));
		 d.values().forEach(value -> System.out.println(value));
	 }
	 
	 public static void main(String[] args) {
		
//		browser = new BrowserNavigation();
//		  browser.openbrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
//		  driver = browser.getDriver();

		  //listMethod();
//		setMethod();
		mapMethod();
//		driver.quit();
	}

}
