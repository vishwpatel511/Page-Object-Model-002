package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	
	public static void intialization(String browser) {
		
		 if(browser.equalsIgnoreCase("IE")) {
			  	System.setProperty("webdriver.edge.driver","C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\msedgedriver.exe");
				driver = new EdgeDriver();
			  }
			  
			  else if(browser.equalsIgnoreCase("chrome")) {
				  	System.setProperty("webdriver.chrome.driver","C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\chromedriver.exe");
					driver = new ChromeDriver();
				  }
			  else if(browser.equalsIgnoreCase("firefox")) {
				  	System.setProperty("webdriver.gecko.driver","C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\geckodriver.exe");
					driver = new FirefoxDriver();
				  }
	
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	
	}

	public static void exit() {
		
		driver.quit();
	}
	
}
