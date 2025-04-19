package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page404Error {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "http://example.com/some404page";
		driver.get(url);
		//System.out.println(driver.getPageSource()); //this does not give the response code 404
		
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		connection.connect();
		System.out.println("Response code: "+connection.getResponseCode());
		
		
	}

}
