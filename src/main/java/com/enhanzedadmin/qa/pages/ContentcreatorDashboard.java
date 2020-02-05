package com.enhanzedadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class ContentcreatorDashboard extends Testbaseadmin
{
	//check total users
	@FindBy(xpath="//div[contains(@class,'dabox1')]//p[contains(@class,'duboxp2 ng-binding')]")
		public WebElement totalusers;
		
		//check total topics
		@FindBy(xpath="//div[contains(@class,'dabox2')]//p[contains(@class,'duboxp2 ng-binding')]")
		public WebElement totaltopics;
		
		//check total users are displayed or not 
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[1]/div[3]/div[2]/p[1]")
		public WebElement activeusers;
		
		//check topics started are displayed or not 
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[1]/div[3]/div[3]/p[1]")
		public WebElement topicsstarted;
		
		@FindBy(xpath="//button[contains(text(),' Week ')]")
		public WebElement week;
		
		@FindBy(xpath="//button[contains(text(),' Month ')]")
		public WebElement month;
		
		@FindBy(xpath="//button[contains(text(),' Year ')]")
		public WebElement year;
		
		@FindBy(xpath="//*[name()='g' and contains(@class,'nv-background')]")
		public WebElement graph;
		
		public ContentcreatorDashboard ()  {
			super();
		PageFactory.initElements(driver,this);
		}
		
		public boolean checkTotalUsers()
		{   
			return totalusers.isDisplayed();
		}
		
		public boolean checkTotalTopics()
		{
			return totaltopics.isDisplayed();
		}
		
		public boolean checkActiveUsers()
		{
			return activeusers.isDisplayed();
		}
		
		public boolean checkTopicsStarted()
		{
			return topicsstarted.isDisplayed();
		}
		
		public boolean checkGraph()
		{
			return graph.isDisplayed();
		}

}
