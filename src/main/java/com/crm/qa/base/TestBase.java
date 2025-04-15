package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utils.TestUtils;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try{
			prop = new Properties();
			//FileInputStream ip = new FileInputStream(
				//			System.getProperty("C:\\Users\\parsh\\eclipse-workspace\\CrmHybrid\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"));
					//		prop.load(ip);
			FileInputStream ip = new FileInputStream(
						            "C:\\Users\\parsh\\eclipse-workspace\\CrmHybrid\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
						        prop.load(ip);
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	//@SuppressWarnings("deprecation")
	public static void Initialise() {
		
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			System.out.println(BrowserName);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\parsh\\Downloads\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
			else if(BrowserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\parsh\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
				driver =new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		
		}
			
		
	
}
