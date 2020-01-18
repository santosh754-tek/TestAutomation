package base.selenium;

import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import bsh.This;
import utility.PropertiesClass;

/**
 * This class is used to get the browser information from properties files and open the chrome browser.
 * @author santo
 *
 */
public class BaseClass extends PropertiesClass

{
	public static Logger log = Logger.getLogger(This.class.getName());
	public  static WebDriver driver;
/**
 * This method is used to intialize the browser based on Input browser which is mentioned in properties file.
 * @throws IOException
 */
	public  void intilizeBrowser() throws IOException {

		 getProperty();
		String browserName = pro.getProperty("browser");
		log.info( "Browser Name : " + browserName  );
		if ( browserName.equalsIgnoreCase("Chrome") ) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\santo\\Documents\\New folder\\selenium\\src\\main\\java\\test\\selenium\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info( "chrome driver is launched"  );
		}
		
	}

}