package customPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author santo
 *
 */
public class CustomFun  {
	
	public static void waitTillElementClickability( WebDriver driver,WebElement el)
	{
		
		WebDriverWait wait= new WebDriverWait( driver, 20 );
		
		wait.until( ExpectedConditions.elementToBeClickable( el ) );
	
	}
	
	/**
	 * Method Name : enterTextBoxValue
	 * Description : This method is used to enter the text value in the text box.
	 * @param driver
	 * @param el
	 * @param text
	 */
	public static void enterTextBoxValue( WebDriver driver , WebElement el  , String text)
	{
		el.sendKeys(text);
	}
	
	/**
	 * Method Name : clickLogInButton Description: Method to click on login Button
	 * @param driver
	 * @param el  Description: 
	 */
	public static void clickLogInButton( WebDriver driver, WebElement el )
	{
		el.click();
	}

	/**
	 * Method Name : waitForPageLoaded Description: Wait for the page to be loaded
	 * @param driver
	 */
	public static void waitForPageLoaded( WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver,30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(false, "Timeout waiting for Page Load Request to complete.");
		}
		
	}
	/**
	 * This method wait till visibility of element located.
	 * @param driver
	 * @param el
	 * @param time
	 */
	public static void waitUntilElementToBePresent( WebDriver driver,WebElement el,int time)
	{
		
		WebDriverWait wait= new WebDriverWait( driver, time );
		
		wait.until( ExpectedConditions.visibilityOf(el));
	
	}
}
