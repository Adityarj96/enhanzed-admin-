package com.enhanzedadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class MyProfile extends Testbaseadmin {
	
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
	private WebElement profileUserName;
	
	@FindBy(xpath="//img[@class='headerimg']")
	private WebElement profileImage;
	
	@FindBy(xpath="//a[@ng-click='signout()']")
	private WebElement signOut;
	
	 //initializing page objects
	public MyProfile() 
	{
		super();
		PageFactory.initElements(driver,this);
			
	}
	
	//verify presence of profileUserName
	public boolean profileUserName()
	{
		
		
		return profileUserName.isDisplayed();
		
	}
	
	//verify presence of profileImage
	public boolean profileImage()
	{
		
		
		return profileImage.isDisplayed();
		
	}

	
	//verify presence of signOut
	public boolean signOut()
	{
		
		profileUserName.click();
		return signOut.isDisplayed();
		
	}
	
	//sign out
	public void clickSignOut()
	{
	
		profileUserName.click();
		sleep(6000);
		signOut.click();
	}

	

}
