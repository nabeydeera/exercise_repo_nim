package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserNavigation {
	WebDriver driver;

	public void openbrowser(String browser, String url) {		
		String currDir = System.getProperty("user.dir");

		if(browser.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			
		}

		else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", currDir+"\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver(); 
		}

		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", currDir+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(); 
		}

		else {System.out.println("Run is quit due to invalid url");
		System.exit(0);
		}

		if(url!="") {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else 
			driver.get("about:blank");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitBrowser() {
		driver.quit();
	}

}
