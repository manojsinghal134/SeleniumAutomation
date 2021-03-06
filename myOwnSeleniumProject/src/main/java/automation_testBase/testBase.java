package automation_testBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBase {

	public static final Logger log=Logger.getLogger(testBase.class.getName());
	public WebDriver driver;
	String url="http://automationpractice.com";
	String browser="chrome";
	String log4jConfigPath="log4j.properties";
	public Date dtnow=new Date();
	public SimpleDateFormat ft =new SimpleDateFormat ("MMddmmss");

	
	public void init() {
		selectBrowser(browser);
		geturl(url);
		PropertyConfigurator.configure(log4jConfigPath);
	}
	
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\ChromeDriver.exe" );
			log.info("Creating the object of " + browser);
			driver=new ChromeDriver();
			
		}
	}
	
	public void geturl(String url) {
		log.info("Navigating to " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
}
