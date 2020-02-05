package com.enhanzedadmin.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class AdminorgcodeUI extends Testbaseadmin
{
	//webelement for the UI of organisation code
	
	//check for the image
	@FindBy(xpath="/html/body/div/div[2]/div/div/img")
	private WebElement admindashboardimg;
	
	//check for the text in the admindashboard
	@FindBy(xpath="//p[contains(text(),'Admin Dashboard')]")
	private WebElement checktext;
	
	//check for the textbox
	@FindBy(xpath="//input[@type='text']")
	private WebElement checktextbox;
	
	//check for submit button
	@FindBy(xpath="//button[@class='submitorg']")
	private WebElement checksubmit;
	
	//check for admindashboard
	@FindBy(xpath="//p[contains(text(),'Admin Dashboard')]")
	private WebElement admindashboardlogin;
	
 	  
	 //Check for invalid organization code
	 @FindBy(xpath="//p[@class='ng-scope']")
	 public  WebElement error;
	
	
	 //initializing page objects
	public AdminorgcodeUI() 
	{
		super();
		PageFactory.initElements(driver,this);
			
	}
	
    //Actions
		
	//check for admindashboardimg		
	public boolean checkadmindashboardimg()
	{
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		return admindashboardimg.isDisplayed();
		
	}
	
	//check for the presence of text in admin dashboard
	public boolean checktext()
	{
		return checktext.isDisplayed();
	}
	
	//check for the presence of textbox
	public boolean checkfortextboxpresent()
	{
		return checktextbox.isDisplayed();
	}
	
	//check for submit button
	public boolean checksubmitbutton()
	{
		return checksubmit.isDisplayed();
	}
	
	//verify the title of the page
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	//public void typeorganisation
	public void typeorganisation(String orgcode)
	{
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		checktextbox.sendKeys(orgcode);
		checksubmit.click();
		
		
	}
	
	
	  }
	
		

