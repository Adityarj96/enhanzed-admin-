package com.enhanzedadmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.EngageGroup;
import com.enhanzedadmin.qa.pages.EngageUser;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class EngageGroupNotificationTest extends Testbaseadmin {
	
	 AdminorgcodeUI org;
	 Adminlogin log;
	 EngageGroup group;
	 EngageUser user;
	 TestUtil testutil;
	 
	 String sheetName = "GroupNotification";
	 
	 public EngageGroupNotificationTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			group = new EngageGroup();
			user=new EngageUser();
					
	} 
	    //To read the test data from the excel sheet 
		 @DataProvider
		 public Object[][] getTestData()
		 {
			Object data[][]= testutil.getTestData(sheetName);
			return data; 
		 }
		 
		@Severity(SeverityLevel.CRITICAL)
		@Description("To check error message occurs when the titile and description is empty")
		@Test(priority=58)
		public void checkErrormessage()
		{
			user.clickEngageTab();
			group.clickWithGroups();
			group.searchgroup.sendKeys("Default Group");
			group.clickGroup.click();
			sleep(3000);
			group.groupsend.click();
			Assert.assertEquals(group.groupmsgtitleerror.getText(), "Please enter the Message Title");
			Assert.assertEquals(group.groupmsgdescriptionerror.getText(), "Please enter the Message Description"); 
		}
		 
		 
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("To check error message occurs when the description is empty")
		@Test(priority=59)
		public void checkErrormessagewhendescriptionempty()
		{
			user.clickEngageTab();
			group.clickWithGroups();
			group.searchgroup.sendKeys("Default Group");
			group.clickGroup.click();
			group.groupmessagetitle.sendKeys("test notification");
			sleep(3000);
			group.groupsend.click();
			Assert.assertEquals(group.groupmsgdescriptionerror.getText(), "Please enter the Message Description"); 	
		}
		 
		 
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("To check error message occurs when the title is empty")
		@Test(priority=60)
		public void checkErrormessagewhentitleempty()
		{
			user.clickEngageTab();
			group.clickWithGroups();
			group.searchgroup.sendKeys("Default Group");
			group.clickGroup.click();
			group.groupmessagedescription.sendKeys("This will be the test description");
			group.groupsend.click();
			Assert.assertEquals(group.groupmsgtitleerror.getText(), "Please enter the Message Title");	
		}
		 
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("To check error message occurs when the url is empty")
		@Test(priority=61)
		public void checkErrormessagewhenurlempty()
		{
			user.clickEngageTab();
			group.clickWithGroups();
			group.searchgroup.sendKeys("Default Group");
			group.clickGroup.click();
			group.groupmessagetitle.sendKeys("This will be test messages");
			group.groupmessagedescription.sendKeys("This will be the test description");
			group.grouplinkcheckbox.click();
			group.groupsend.click();
		    Assert.assertEquals(group.groupurlerror.getText(), "Please enter a valid URL");
			
		}
		  
		 //for assigning topic to user and verifying it
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("To send the notification to the groups")
		 @Test(priority=62,dataProvider="getTestData")
		 public void Engagenotificationtogroup(String groupName) throws InterruptedException
		 {
			 group.sendNotificationGroup(groupName);
		 }
		
		 @Severity(SeverityLevel.NORMAL)
		 @Description("To check the breadcrumb sequence")
         @Test(priority=63)
		 public void checkbreadcrumbsequence()
		 {
			 user.clickEngageTab();
			 group.clickWithGroups();
			 group.checkbreadcrumb();
		 }
		 
		 
		 @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }


}
