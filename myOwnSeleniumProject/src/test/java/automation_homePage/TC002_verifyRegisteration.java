package automation_homePage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation_testBase.testBase;
import automation_uiActions.HomePage;
import junit.framework.Assert;

public class TC002_verifyRegisteration extends testBase{
	
	public static final Logger log=Logger.getLogger(TC002_verifyRegisteration.class.getName());
	HomePage homepage;
	
	@BeforeTest
	public void setup() {
		init();
	}
	
	@Test
	public void createaccount() {
		try {
			
			homepage=new HomePage(driver);
			homepage.signup("test" + ft.format(dtnow) + "@gmail.com", "Manoj", "Kumar", "password", "101 main st", "Manchester", "CT", "06042", "8124567890", "HomeAddress");
			Assert.assertEquals(homepage.getRegisterationMessage(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void endTest() {
		//driver.close();
	}
}
