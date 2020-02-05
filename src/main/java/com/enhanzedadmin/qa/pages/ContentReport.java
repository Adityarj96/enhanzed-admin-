package com.enhanzedadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentReport 
{
	
	@FindBy(xpath="//z[contains(text(),'REPORTS')]")
	public WebElement reports;
	
	@FindBy(xpath="//z[contains(text(),'Content Reports')]")
	WebElement userreports;
	
	

	
	
	
	

}
