package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import util.BrowserNavigation;

public class CheckResponseCode {
	static BrowserNavigation browser;
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {
		try {
			browser = new BrowserNavigation();
			String url = "https://accounts.lambdates.com/register";
			browser.openbrowser("Chrome", url);
			
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			

//get the response code
			int responseCode = connection.getResponseCode();
			System.out.println("Response code: " + responseCode);

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
