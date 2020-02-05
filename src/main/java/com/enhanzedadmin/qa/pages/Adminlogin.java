package com.enhanzedadmin.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class Adminlogin extends Testbaseadmin
{
	  //webelements in login page (Page factory or Object repository)
	  @FindBy(xpath="//input[@type='email']")
	  WebElement usernameemail;
		
	  //password
	  @FindBy(xpath="//input[@type='password']")
	  WebElement enterpassword;
		
	  //login button 
	  @FindBy(xpath="//button[@class='submit']")
	  WebElement loginbutton;
	  
	  //change organisation code
	  @FindBy(xpath="//button[contains(text(),'Change Organization?')]")
	  WebElement changeorganisationcode;
	  
	  
	  //Forgot password 
	  @FindBy(xpath="//button[@ng-click='forgotpwd()']")
	  WebElement forgotPasswordButton;
	  
	//Forgot password 
	  @FindBy(xpath="//img[@class='appimg']")
	  WebElement logo;
	  
	//Forgot password 
	  @FindBy(xpath="//div/div[2]/div/div/div[1]/p")
	  WebElement adminDashboardText;
	  
	//Forgot password 
	  @FindBy(xpath="//div/div[2]/div/div/div[2]/p")
	  WebElement signInText;
	
	 //User name - in home page profile
	  @FindBy(xpath="//div[@class='dropdown']//button")
	  public WebElement username;
	  	
	 
	  
	  public Adminlogin()  {
			super();
		PageFactory.initElements(driver,this);
		}
	  
	//verify presence of emailIdTextBox
	public boolean emailIdTextBox() 
		{
			
		    sleep(3000);
			return usernameemail.isDisplayed();
				
		}
	
	//verify presence of passwordTextBox
		public boolean passwordTextBox()
			{	
			   sleep(3000);
				return enterpassword.isDisplayed();	
			}
		
		//verify presence of loginButton
		public boolean loginButton()
			{	 sleep(3000);							
				return loginbutton.isDisplayed();	
			}
		
		//verify presence of changeOrgCode
		public boolean changeOrgCode()
			{		 sleep(3000);			
				return changeorganisationcode.isDisplayed();	
			}
		
		//verify presence of forgotPasswordLink
		public boolean forgotPasswordLink()
			{   sleep(3000);							
				return forgotPasswordButton.isDisplayed();			
			}
				
		//verify presence of logo
		public boolean logo()
			{
											
				return logo.isDisplayed();
							
			}
		
		//verify presence of adminDashboardText
		public boolean adminDashboardText()
				{									
					return adminDashboardText.isDisplayed();				
				}
				
		//verify presence of signInText
		public boolean signInText()
				{										
					return signInText.isDisplayed();				
				}
				
		

	  //Login as admin
	  public void login(String uname,String pwd) throws InterruptedException
	  {
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  usernameemail.sendKeys(uname);
		  System.out.println("The username"+uname+"is entered");
		  enterpassword.sendKeys(pwd);
		  System.out.println("The password"+pwd+"is entered");
		  Thread.sleep(3000);
		  loginbutton.click(); 
		  //validateSuccessfulLogin();
		   
	  }
	  
	  public void clickchangeorganisation()
	  {
		  implicitWait(20);
		  changeorganisationcode.click();
	  }
	  
	
	  
	//validate password is encrypted or not
		public void testPasswordEncryption(String uname, String pwd) 
		{
			 usernameemail.sendKeys(uname);
			  enterpassword.sendKeys(pwd);
			  String type=enterpassword.getAttribute("type");
				if(type.equalsIgnoreCase("password"))
				{
				  	System.out.println("Encrypted");
				}
				else
				{
					Assert.fail("Not encrypted");
				}
		}
			
			

}
