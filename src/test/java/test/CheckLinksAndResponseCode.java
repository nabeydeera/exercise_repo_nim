package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import util.BrowserNavigation;

public class CheckLinksAndResponseCode {
	static BrowserNavigation browser;
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, WebDriverException {
	
			browser = new BrowserNavigation();
			String url = "http://www.zlti.com";
			//String url2 = "https://accounts.lambdatest.com/register";
			browser.openbrowser("Chrome", url);
			driver = browser.getDriver();
			
			System.out.println("Main page title: "+driver.getTitle());
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println("Total links with tagName a: "+allLinks.size());
			
			for (int i = 0; i < allLinks.size(); i++) {
				WebElement element = allLinks.get(i);
				String link = element.getAttribute("href");
				String linkText = element.getText();
			
				//some a tags are returning null as they don't have a href
				//check if the URL is not null and has http in the url
				//there are some links for telephone number and email addresses
				if (link!=null && link.contains("http")) {
					
						verifyLinks(link,i,linkText);
				}
			}
			
			browser.quitBrowser();
	}
	
	public static void verifyLinks(String linkURL, int a, String linkTxt) throws MalformedURLException { 
			try {
			//URL actualUrl = connection.linkURL(); --this is not needed as we can use new URL in below line it self
			HttpURLConnection connection = (HttpURLConnection) new URL(linkURL).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();

			if (connection.getResponseCode()==200) {
				System.out.println(a+" For the link-> "+linkURL+" - "+connection.getResponseCode()+connection.getResponseMessage()+" - LinkText: "+linkTxt); 
				
			}
			if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				
				System.out.println(a+" For the link: "+linkURL+" - "+connection.getResponseCode()+connection.getResponseMessage()); 
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		
	}

}
