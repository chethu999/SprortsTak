package base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;


import util.SeleniumLibs;


public class TestBaseListener extends SeleniumLibs implements ISuiteListener, ITestListener {
	
	private static WebDriver driver;
	public static Actions actions;
	public static String url;
	public static Logger suite_logs;
	
	
	public void onStart(ISuite suite) {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 suite_logs = Logger.getLogger(TestBaseListener.class.getName());
		 driver=new ChromeDriver();
		 url = suite.getParameter("Environment");
		 driver.get(url);
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 staticWait(3);
		 actions= new Actions(driver);
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestBaseListener.driver = driver;
	}
	
}
