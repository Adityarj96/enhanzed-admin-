package com.enhanzedadmin.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class HomePageUI extends Testbaseadmin {
	
	//Enhanzed Logo
	@FindBy(xpath="//img[@ng-if='lscreen']")
	private WebElement logo;
	
	@FindBy(xpath="//div[@id='sidenav']")
	private WebElement sideNvigation;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/a[1]")
	private WebElement dashboardTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/div[1]/a")
	private WebElement usersAndGroupsTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/div[3]/a")
	private WebElement contentTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/div[5]/a")
	private WebElement assignTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/div[7]/a")
	private WebElement reportsTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/div[9]/a")
	private WebElement engageTab;
	
	@FindBy(xpath="//div[@id=\"sidenav\"]/a[2]")
	private WebElement settingsTab;
	
	@FindBy(xpath="//div[@id=\"content\"]//p[2]")
	private WebElement totalUsersText;
	
	@FindBy(xpath="//div[@id=\"content\"]//div[2]/div/p[2]")
	private WebElement totalTopicsText;
	
	@FindBy(xpath="//div[@id=\"content\"]//div[3]/p[2]")
	private WebElement topicsStartedText;
	
	@FindBy(xpath="//div[@id=\"content\"]//div[2]/p[2]")
	private WebElement activeUsersText;
	
	@FindBy(xpath="//div[@class='analytics']")
	private WebElement graphSection;
	
	@FindBy(xpath="//p[@class='useract']")
	private WebElement userActivityText;
	
	@FindBy(xpath="//button[contains(text(),'Week')]")
	private WebElement weekButton;
	
	@FindBy(xpath="//button[contains(text(),'Month')]")
	private WebElement monthButton;
	
	@FindBy(xpath="//button[contains(text(),'Year')]")
	private WebElement yearButton;
	
	@FindBy(xpath="//button[@class='ng-binding dropdownMenuButton-dark']")
	private WebElement profileUserName;
	
	@FindBy(xpath="//img[@class='headerimg']")
	private WebElement profileImage;
	
	@FindBy(xpath="//a[@ng-click='signout()']")
	private WebElement signOut;
	
	
	 //initializing page objects
		public HomePageUI() 
		{
			super();
			PageFactory.initElements(driver,this);
				
		}
		
		//verify presence of logo
		public boolean checkLogo()
		{
			implicitWait(40);
			
			return logo.isDisplayed();
			
		}
		
		//verify presence of sideNavigationBar
				public boolean sideNavigationBar()
				{
					
					
					return sideNvigation.isDisplayed();
					
				}
				
				//verify presence of dashboardTab
				public boolean dashboardTab()
				{
					
					
					return dashboardTab.isDisplayed();
					
				}
				
				//verify presence of usersAndGroupsTab
				public boolean usersAndGroupsTab()
				{
					return usersAndGroupsTab.isDisplayed();	
				}
				
				//verify presence of contentTab
				public boolean contentTab()
				{
					
					
					return contentTab.isDisplayed();
					
				}
				
				//verify presence of assignTab
				public boolean assignTab()
				{
					
					
					return assignTab.isDisplayed();
					
				}
				
				//verify presence of reportsTab
				public boolean reportsTab()
				{
					
					
					return reportsTab.isDisplayed();
					
				}
				
				//verify presence of engageTab
				public boolean engageTab()
				{
					
					
					return engageTab.isDisplayed();
					
				}
				
				//verify presence of settingsTab
				public boolean settingsTab()
				{
					
					
					return settingsTab.isDisplayed();
					
				}
				
				//verify presence of totalUsersText
				public boolean totalUsersText()
				{
					
					
					return totalUsersText.isDisplayed();
					
				}
				
				//verify presence of totalTopicsText
				public boolean totalTopicsText()
				{
					
					
					return totalTopicsText.isDisplayed();
					
				}
				
				//verify presence of topicsStartedText
				public boolean topicsStartedText()
				{
					
					
					return topicsStartedText.isDisplayed();
					
				}
				
				//verify presence of activeUsersText
				public boolean activeUsersText()
				{
					
					
					return activeUsersText.isDisplayed();
					
				}
				
				
				//verify presence of graphSection
				public boolean graphSection()
				{
					
					
					return graphSection.isDisplayed();
					
				}
				
				//verify presence of userActivityText
				public boolean userActivityText()
				{
					
					
					return userActivityText.isDisplayed();
					
				}
				
				//verify presence of weekButton
				public boolean weekButton()
				{
					
					
					return weekButton.isDisplayed();
					
				}
				
				//verify presence of monthButton
				public boolean monthButton()
				{
					
					
					return monthButton.isDisplayed();
					
				}
				
				//verify presence of yearButton
				public boolean yearButton()
				{
					
					
					return yearButton.isDisplayed();
					
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
					signOut.click();
				}
	
}
