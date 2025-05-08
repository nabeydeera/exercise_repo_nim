/*Not completed*/

package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortaList {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.saucedemo.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		 
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.id("login-button")).click();
		 
		// Alert alert = driver.switchTo().alert();
		// alert.dismiss();
		 
		 //JavascriptExecutor jse = (JavascriptExecutor)driver;
		//	jse.executeScript("window.alert=function(){return true;}");
		 
		 //checking the item names are in sort order
		 List<WebElement> inventoryList = driver.findElements(By.xpath("//div[@class='inventory_list']//a/div")); //the item names
		 List<String> originalInventoryList = new ArrayList<String>();
		 
		 for (WebElement ele1 : inventoryList) { //add the item names to convertInventoryList list - this list will not be sorted
			 originalInventoryList.add(String.valueOf(ele1.getText()));
			}
		 
		 List<String> sortedInventory = new ArrayList<String>(); //create another list to add same list names and then later sort the array list
		 for (WebElement ele2 : inventoryList) {
			 sortedInventory.add(String.valueOf(ele2.getText()));
			}
		 System.out.println(originalInventoryList);

		 System.out.println(sortedInventory);
		 Collections.sort(sortedInventory); //will sort the list
		 SoftAssert softAssert = new SoftAssert();

		 softAssert.assertEquals(originalInventoryList, sortedInventory, "Not sorted"); //compare the original list with the sorted list to verify if the original list is in sorted order
		 
		 
		 //check if item prices are in sort order
		 List<WebElement> invenrotyPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		 List<Double> originalPriceList = new ArrayList<>();
		 for (WebElement ele3 : invenrotyPrices) {
			 originalPriceList.add(Double.valueOf(ele3.getText().replace("$", "")));
			}
		 System.out.println("Original list: "+originalPriceList);
		 List<Double> sortedPrices = new ArrayList<Double>();
		 for (WebElement ele4 : invenrotyPrices) {
			 sortedPrices.add(Double.valueOf(ele4.getText().replace("$", "")));
			}
				 Collections.sort(sortedPrices);
		 System.out.println("After sort: "+ sortedPrices);
		 softAssert.assertNotEquals(originalPriceList, sortedPrices, "Not sorted");
		 softAssert.assertAll();
		 
		 
		 
		 
		 driver.quit();
		
	}

}
