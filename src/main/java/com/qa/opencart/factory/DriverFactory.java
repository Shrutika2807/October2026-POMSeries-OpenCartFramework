package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.exceptions.FrameworkException;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public static final  Logger log=LogManager.getLogger(DriverFactory.class);

	public WebDriver initDriver(Properties prop)
	{
		log.info("Properties are:"+ prop);
		String browserName=prop.getProperty("browser");
		
		log.info("Browser name is"+browserName);
		//System.out.println("Browser Name is"+ " "+browserName);
		optionsManager= new OptionsManager(prop);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "edge":
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;

		case "firefox":
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		case "safari":
			tlDriver.set(new SafariDriver());
			break;

		default:
			//System.out.println("Entered browser is" + " " + ":" + browserName + "please pass the correct browser");
			log.error("Please pass the valid browser name");
			throw new BrowserException("=======INVALID BROWSER=======");
		}

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();
	}
	
	
	/**
	 * getDriver : Get the local thread copy of the driver
	 */
	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	/**
	 * This function is used to initialize the config properties file 
	 * 
	 * @return
	 */
    
	// mvn clean install -Denv="qa"
	
	public Properties initProp() 
	{
		FileInputStream ip=null;
		prop= new Properties();
		String envName=System.getProperty("env");
		System.out.println("Running the test cases on"+" "+envName);
		
		try 
		{
		if(envName == null)
		{
			//System.out.println("Env is Null, hence running the test cases on QA env...");
			log.warn("Env is Null, hence running the test cases on QA env...");
			ip= new FileInputStream("./src/test/resources/config/config.properties");
		}
		else
		{
			System.out.println("Running the test cases on"+" "+envName);
			switch(envName.toLowerCase().trim())
			{
			case"qa":
			ip= new FileInputStream("./src/test/resources/config/qa.config.properties");	
			break;
			case"dev":
			ip= new FileInputStream("./src/test/resources/config/dev.config.properties");
			break;
		    case"stage":
		    ip= new FileInputStream("./src/test/resources/config/stage.config.properties");
			break;
			case"uat":
			ip= new FileInputStream("./src/test/resources/config/uat.config.properties");
			break;
			case"prod":
			ip= new FileInputStream("./src/test/resources/config/config.properties");
			break;
			default:
			log.error("===Invalid Env===="+envName);
			throw new FrameworkException("====INVALID ENV NAME==="+envName);
			
		}
		}
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try 
		{
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;

	}
	
	
	/**
	 * This Function will take the screenshot
	 */
	
	public static File getScreenshotFile()
	{
	     File srcFile=  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	     return srcFile;
	}
	
	
	public static byte[] getScreenshotByte()
	{
	     return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
	    
	}
	
	
	public static String getScreenshotBase64()
	
	
	{
	     return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
	    
	}
}
