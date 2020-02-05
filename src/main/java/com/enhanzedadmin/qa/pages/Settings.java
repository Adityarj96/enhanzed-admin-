package com.enhanzedadmin.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class Settings extends Testbaseadmin {
	
	@FindBy(xpath="//z[contains(text(),'SETTINGS')]")
	public  WebElement settings;

	//xpath for welcome email template categories
	@FindBy(xpath="//a[contains(text(),'Welcome Email Template')]")
	public WebElement welcomeemailtemplate;
	
	@FindBy(xpath="//button[contains(@class,'button2 footerbtn2')]")
	public WebElement cancel;
	
	@FindBy(xpath="//input[contains(@name,'cname')]")
	public WebElement subject;
	
	@FindBy(xpath="//textarea[contains(@type,'text')]")
	public WebElement body;
	
	@FindBy(xpath="//button[contains(text(),'Edit Template')]")
	public WebElement edittemplate;
	
	@FindBy(xpath="//button[contains(text(),'Save Template')]")
	public WebElement savetemplate;
	
	@FindBy(xpath="//a[contains(text(),'Settings')]")
	public WebElement clickbreadcrumb;
	
	
	
	public Settings() 
	{
		super();
	PageFactory.initElements(driver,this);
	
	}
	
	//Click on settings tab
	public void clickSettings()
	{
		settings.click();
	}
	
	//Click on Manage categories
	public void clickWelcomeemailtemplate()
	{
		 welcomeemailtemplate.click();
	}
	
	public boolean checkSubjectDisplayed()
	{
		return subject.isDisplayed();
	}
			
	public boolean checkBodyDisplayed()
	{
		return body.isDisplayed();
	}
	
	public boolean editbuttonDisplayed()
	{
		return edittemplate.isDisplayed();
	}
	
	public void checkEditSubject()
	{
	
	  clickSettings();
	  clickWelcomeemailtemplate();
	  String var1=subject.getAttribute("value");
	  
	
	  
	   edittemplate.click(); 
	  
    Actions action=new Actions(driver);
    action.moveToElement(subject).click().perform();

    subject.sendKeys(Keys.SPACE);
    subject.sendKeys(Keys.SPACE);

    subject.sendKeys("Test 1");
    savetemplate.click();
    welcomeemailtemplate.click();
    
    String var2=subject.getAttribute("value");
    
    System.out.println(subject.getAttribute("value"));
    
    Assert.assertNotEquals(var1, var2, "The subject line is not changed");
    
	}
	
	public void changeBody()
	{
		  clickSettings();
		  clickWelcomeemailtemplate();
		  String var3=body.getAttribute("value");
		  edittemplate.click(); 
		  
		    
		    Actions action=new Actions(driver);
		    action.moveToElement(body).click().perform();
		  
		    body.sendKeys("Test 1");
		    savetemplate.click();
		    welcomeemailtemplate.click();
		    
		    String var4=body.getAttribute("value");
		    
		    Assert.assertNotEquals(var3, var4, "The body line is not changed");
		  
	}
	
	
	
	 
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String verifyname = verifyCategory.getText();
		sleep(8000);
		if(name.equalsIgnoreCase(verifyname))
		{
			editButton.click();
			categoryName.clear();
			categoryName.sendKeys("New test");
			addImage();
			saveButton.click();
			sleep(5000);
			okButton.click();
			sleep(5000);
		}
		else
		{
		  	System.out.println("Category doesnot exist");
		}*/
		
	}
	

	

