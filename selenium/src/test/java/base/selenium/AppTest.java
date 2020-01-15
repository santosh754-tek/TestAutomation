package base.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.selenium.BaseClass;
import customPage.CustomFun;
import pages.LogInPage;
import pages.NaukariHomePage;

/**
 * This class is used to test the naukari login page
 * 
 * @author santo
 *
 */
public class AppTest extends BaseClass

{
	public Logger log = Logger.getLogger(this.getClass().getName());
	CustomFun cf = new CustomFun();
	LogInPage lp;
	NaukariHomePage naukarHomePageObj;

	/**
	 * This method executes first and intialize the browser as per requirements and
	 * navigate to the Url.
	 * 
	 * @throws IOException
	 */
	@BeforeTest()
	public void urlNavigate() throws IOException {
		System.out.println("adsadas");
		intilizeBrowser();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * This test method used to login to naukari websites and verify the
	 * successfull.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 0, description = "Login to the Naukari websites and Verify successfull login")
	public void naukariLogIn() throws InterruptedException {

		lp = PageFactory.initElements(driver, LogInPage.class);
		lp.loginNaukariWebsite();
		Reporter.log("User is loggged in Successfully");
		naukarHomePageObj = PageFactory.initElements(driver, NaukariHomePage.class);
		CustomFun.waitUntilElementToBePresent(driver, NaukariHomePage.myNaukariLabel, 20);
		Assert.assertTrue( naukarHomePageObj.isMyNaukariLabelDisplayed(), "Naukari labels are not displayed" );
		log.info(" User is successfully  navigated to naukari Home page and Naukari labels is displayed");
	}

	@AfterTest()
	public void quit() {
		driver.quit();
	}

}