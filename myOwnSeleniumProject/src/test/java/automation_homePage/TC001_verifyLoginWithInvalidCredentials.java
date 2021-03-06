package automation_homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation_testBase.testBase;
import automation_uiActions.HomePage;

public class TC001_verifyLoginWithInvalidCredentials extends testBase {
		
		 public static final Logger log=Logger.getLogger(TC001_verifyLoginWithInvalidCredentials.class.getName());
		HomePage homepage;
		@BeforeTest
		public void setup() {
			init();
		}
		
		@Test
		public void verifyLoginWithInvalidCredentials() {
			try {
				log.info("**************Starting verifyLoginWithInvalidCredentials Test****************");
				homepage=new HomePage(driver);
				homepage.loginToApplication("test@gmail.com", "password123");
				Assert.assertEquals(homepage.getInvalidLoginText(),"Authentication failed.");
				//*[@id="center_column"]/div[1]/ol/li
				log.info("**************Finishing verifyLoginWithInvalidCredentials Test****************");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@AfterTest
		public void endTest() {
			driver.close();
		}
	
}
