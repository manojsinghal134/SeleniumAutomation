package automation_uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailAddress;
	
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']//li[1]")
	WebElement authenticationFailed;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement signupEmail;
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement signupCreateAccount;	
	@FindBy(xpath="//*[@id='customer_firstname']")
	WebElement firstName;
	@FindBy(xpath="//*[@id='customer_lastname']")
	WebElement lastName;
	@FindBy(xpath="//*[@id='address1']")
	WebElement address1;
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	@FindBy(xpath="//*[@id='id_state']")
	WebElement state;
	@FindBy(xpath="//*[@id='postcode']")
	WebElement postcode;
	@FindBy(xpath="//*[@id='phone_mobile']")
	WebElement mobilePhone;
	@FindBy(xpath="//*[@id='alias']")
	WebElement addressAlias;
	@FindBy(xpath="//*[@id='submitAccount']")
	WebElement submitAccount;
	@FindBy(xpath="//p[@class='info-account']")
	WebElement welcomeMesage;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String emailAddress, String password) {
		signIn.click();
		log.info("clicked on sign in and object is " + signIn.toString() );
		loginEmailAddress.sendKeys(emailAddress);
		log.info("Entered Email Address:  " + emailAddress);
		loginPassword.sendKeys(password);
		log.info("Entered password: " + password );
		submitButton.click();
		log.info("clicked on submit button and object is " + submitButton.toString() );
	}
	
	public String getInvalidLoginText() {
		log.info("Error message is: " + authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	public void signup(String signupmail, String firstname, String lastname,String password, String address, String citi, String stat, String zipcode,String phone, String alias) {
		signIn.click();
		log.info("Clicked on sign in link");
		signupEmail.sendKeys(signupmail);
		signupCreateAccount.click();
		firstName.sendKeys(firstname);
		log.info("Entered First name: " + firstname);
		lastName.sendKeys(lastname);
		log.info("Entered last name: " + lastname);
		loginPassword.sendKeys(password);
		address1.sendKeys(address);
		log.info("Entered address: " + address);
		city.sendKeys(citi);
		state.sendKeys(stat);
		postcode.sendKeys(zipcode);
		mobilePhone.sendKeys(phone);
		addressAlias.clear();
		addressAlias.sendKeys(alias);
		log.info("Entered alias for address: " + alias);
		submitAccount.click();
		log.info("Clicked on submit button");
	}
	
	public String getRegisterationMessage() {
		log.info("Welome message: " + welcomeMesage.getText());
		return welcomeMesage.getText();
	}
}
