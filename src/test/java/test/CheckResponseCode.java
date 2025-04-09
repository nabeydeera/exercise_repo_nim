package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import util.BrowserNavigation;

public class CheckResponseCode {
	static BrowserNavigation browser;
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, WebDriverException {
		try {
			browser = new BrowserNavigation();
			String url = "https://accounts.lambdatest.com/register";
			browser.openbrowser("Chrome", url);
			
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			//connection.setRequestMethod("GET");
			connection.connect();
			

			//get the response code
			int responseCode = connection.getResponseCode();
			String requestMethod = connection.getRequestMethod();
			URL getUrl = connection.getURL();
			
			System.out.println("Response code: " + responseCode);
			System.out.println("Request Method: "+requestMethod);
			System.out.println("URL:"+getUrl);

			if (responseCode ==200) {
				System.out.println("Page Loaded successfully");
			}else {
				System.out.println("Response code is not 200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			browser.quitBrowser();
		} 
		
	}

}
