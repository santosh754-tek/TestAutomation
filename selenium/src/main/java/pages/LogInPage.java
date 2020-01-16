package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.apache.log4j.Logger;

import customPage.CustomFun;

/**
 * This class is for LoginPage where objects are identified ,kept and used in
 * the method and perform operations.
 * 
 * @author santo
 *
 */
public class LogInPage {

	public WebDriver driver;

	// For logging
	public Logger log = Logger.getLogger(this.getClass().getName());

	// This identify the object for login page.
	@FindBy(xpath = "//input[@id='usernameField' and @type='text']")
	public static WebElement userName;
	@FindBy(xpath = "//input[@id='passwordField' and @type='password']")
	public WebElement password;
	@FindBy(xpath = "//button[ @type='submit' and text()='Login']")
	public WebElement loginButton;
	@FindBy(xpath = "///html[@lang='en']")
	public WebElement loginPageDisplay;

	/**
	 * Creating the constructor of Login page and wait for the page to be loaded.
	 * 
	 * @param driver
	 */
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		CustomFun.waitForPageLoaded(driver);

	}

	/**
	 * This method used to login to naukari websites by entering valid detaisl.
	 */
	public void loginNaukariWebsite() {
		CustomFun.enterTextBoxValue(driver, userName, "santoshshahece@gmail.com");
		log.info("Email Id is entered in the email text box");
		CustomFun.enterTextBoxValue(driver, password, "SAN123@test");
		log.info("password  is entered in the password text box");
		CustomFun.clickLogInButton(driver, loginButton);
		log.info("User is able to click the login Button");
	}
}