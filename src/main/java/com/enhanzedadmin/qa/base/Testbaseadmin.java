package com.enhanzedadmin.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class Testbaseadmin 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbaseadmin(){
		
		try {
			
			prop=new Properties();
			FileInputStream ip=new FileInputStream("E:\\com.qa.enhanzed.admin\\src\\main\\java\\com\\enhanzedadmin\\qa\\config\\config.properties");
			prop.load(ip);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void initialization()
	{ 
		String browsername=prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriverV78.exe");
			driver=new ChromeDriver();
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Enhanzed\\Automation projects\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
	}
	
	 public void  tearDown() throws InterruptedException
	    {
	        //driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		    Thread.sleep(3000);
		    driver.close();
	        driver.quit();
	    }
	 
	//Code for implicit wait
		public void implicitWait(int time)
		{
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		
		//Code for explicit time
		public void explicitWait(int time,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		
		//code for explicit wait for visibility of element
		public void explicitWaitForVisibilityOfElement(int time,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		
		//Thread sleep
		public static void sleep(int milisec)
		{
			try
			{
				Thread.sleep(milisec);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
				
				}
