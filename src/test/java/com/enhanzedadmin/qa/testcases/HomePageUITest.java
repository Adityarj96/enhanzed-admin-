package com.enhanzedadmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.HomePageUI;


public class HomePageUITest extends Testbaseadmin {

	
	HomePageUI hp;
	 AdminorgcodeUI org;
	 Adminlogin log;
	
	public HomePageUITest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		org=new AdminorgcodeUI();
		org.typeorganisation(prop.getProperty("orgcode"));
		
		log=new Adminlogin();
		log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		hp=new HomePageUI();
	}
	
	
	//verifying the UI attributes of Organization code page
			@Test(priority=1)
			public void checkHomePageUI() throws InterruptedException
			{
				
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(hp.checkLogo(), "the Logo is not present");
				System.out.println("Logo is present");
				sa.assertTrue(hp.sideNavigationBar(), "the side navigation bar is not present");
				System.out.println("the side navigation bar is present");
				sa.assertTrue(hp.dashboardTab(),"the dashboard is not present");
				System.out.println("Dashboard tab is present");
				sa.assertTrue(hp.usersAndGroupsTab(), "the users and groups tab is not displayed");	
				System.out.println("Users and Groups tab is present");
				sa.assertTrue(hp.contentTab(), "the content tab is not displayed");	
				System.out.println("Content tab is present");
				sa.assertTrue(hp.assignTab(), "the assign tab is not displayed");	
				System.out.println("Assign tab is present");
				sa.assertTrue(hp.reportsTab(), "the reports tab is not displayed");	
				System.out.println("Reports tab is present");
				sa.assertTrue(hp.engageTab(), "the engage tab is not displayed");	
				System.out.println("Engage tab is present");
				sa.assertTrue(hp.settingsTab(), "the settings tab is not displayed");	
				System.out.println("Settings tab is present");
				sa.assertTrue(hp.totalUsersText(), "the total users text is not displayed");	
				System.out.println("Total Users text is present");
				sa.assertTrue(hp.totalTopicsText(), "the total topics is not displayed");	
				System.out.println("Total Topics is present");
				sa.assertTrue(hp.activeUsersText(), "the active users text is not displayed");	
				System.out.println("Active users text is present");
				sa.assertTrue(hp.topicsStartedText(), "the topics started is not displayed");	
				System.out.println("Topics started is present");
				sa.assertTrue(hp.userActivityText(), "the user activity text is not displayed");	
				System.out.println("user activity text is present");
				
				sa.assertTrue(hp.weekButton(), "the week button is not displayed");	
				System.out.println("week button is present");
				
				sa.assertTrue(hp.monthButton(), "the month button is not displayed");	
				System.out.println("Month button is present");
				
				sa.assertTrue(hp.yearButton(), "the year button is not displayed");	
				System.out.println("Year button is present");
				
				sa.assertTrue(hp.profileUserName(), "the user name is not displayed");	
				System.out.println("profile user name is present");
				
				sa.assertTrue(hp.profileImage(), "the profile image is not displayed");	
				System.out.println("profile image is present");
				
				hp.signOut();
				System.out.println("sign out is present");
			}
			
			@Test(priority=2)
			public void signOut() throws InterruptedException
			{
			  hp.clickSignOut();
			}
			
			@AfterMethod
			   public void end() throws InterruptedException
			   {
				 tearDown();
			   }
}
