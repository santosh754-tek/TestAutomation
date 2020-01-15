package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import customPage.CustomFun;

/**
 *  Verify the NaukariHomePage
 * 
 * @author santo
 *
 */
public class NaukariHomePage {
	
	//This is used to log the information in the consol.
	public Logger log=Logger.getLogger( NaukariHomePage.class.getName() );
	public WebDriver driver;
	
	//*This identify the object*//
	
	@FindBy ( xpath="//div[@class='mTxt' and text()='My Naukri']") public static WebElement myNaukariLabel;
	@FindBy ( xpath="//div[@class='user-name roboto-bold-text']")  public static WebElement profileTitle;
	@FindBy ( xpath="//div[contains(@class,'btn btn-block btn')]") public  static WebElement updateProfileButton;

	/**
	 * NaukariHomePage : Creating the constructor to intiliaze all the object and wait for page to be loaded.
	 * @param driver
	 */
	public NaukariHomePage ( WebDriver  driver )
	{
		this.driver = driver;
		CustomFun.waitForPageLoaded ( driver );
		log.info("constructor is created and all objects are loaded");
	}
	
	/**
	 * Method Name : isMyNaukariLabelDisplayed - This is to verify whether naukari label is displayed and return Boolean
	 * @return Boolean
	 */
	public Boolean isMyNaukariLabelDisplayed()
	{
		Boolean b = myNaukariLabel.isDisplayed() ;
		return b;
		}
	/**
	 * This method used to click on update profile
	 */
	public void clickupdateProfileButton()
	{
		
		updateProfileButton.click();
	}
	}	