package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
	
	  public static Properties pro;

	public  static void getProperty() throws IOException
	{
		try
		{
			 pro=new Properties();
		FileInputStream fi= new FileInputStream("C:\\Users\\santo\\Documents\\New folder\\selenium\\src\\main\\java\\utility\\config.properties");
		pro.load(fi);
	}
		catch( FileNotFoundException e)
		{
			e.getLocalizedMessage();
		}
		
	}
}