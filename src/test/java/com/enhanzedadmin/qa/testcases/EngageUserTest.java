package com.enhanzedadmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.EngageUser;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class EngageUserTest extends Testbaseadmin {


	 AdminorgcodeUI org;
	 Adminlogin log;
	 EngageUser euser;
	 TestUtil testutil;
	 
	 String sheetName = "SingleUserNotif";
	 String sheetName1 = "Engageusersearchtermname";
	 String sheetName2 = "Engageusersearchtermlastactive";
	 
	 
	 public EngageUserTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			euser = new  EngageUser();
					
	}
	    
	    //To read the test data from the excel sheet 
		 @DataProvider
		 public Object[][] getTestData()
		 {
			Object data[][]= testutil.getTestData(sheetName);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData1()
		 {
			Object data[][]= testutil.getTestData(sheetName1);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData2()
		 {
			Object data[][]= testutil.getTestData(sheetName2);
			return data; 
		 }
		 
		 //Validate when message title and message description is empty 
		 @Severity(SeverityLevel.TRIVIAL)
		 @Description("Test whetehr the error messages are comming or not")
		 @Test(priority=50)
		 public void validateMessages()
		 {
			euser.clickEngageTab();
			euser.clickWithUsers();
			euser.emailid.sendKeys("john@doe.com");
			euser.clickUser.click();
			sleep(3000);
			euser.sendMessageButton.click();
			Assert.assertEquals(euser.errormsg1.getText(), "Please enter the Message Title");
			Assert.assertEquals(euser.errormsg2.getText(), "Please enter the Message Description");
		 }
		 @Severity(SeverityLevel.TRIVIAL)
		 @Description("Test whetehr the error messages are comming or not when the description is empty")
		 //Validate when message description is empty 
		 @Test(priority=51)
		 public void validateMessageDescription()
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.emailid.sendKeys("john@doe.com");
			 euser.clickUser.click();
			 euser.messagetitle.sendKeys("Test");
			 sleep(3000);
			 euser.sendMessageButton.click();
			 Assert.assertEquals(euser.errormsg2.getText(), "Please enter the Message Description");
		 }
		
		 //Validate when URL is empty 
		 @Severity(SeverityLevel.TRIVIAL)
		 @Description("Test whether error message occurs when the url is empty")
		 @Test(priority=52)
		 public void validateUrl()
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.emailid.sendKeys("john@doe.com");
			 euser.clickUser.click();
			 euser.messagetitle.sendKeys("Test");
			 euser.messageDescription.sendKeys("This is test message");
			 sleep(3000);
			 euser.urlClickCheckbox.click();
			 sleep(3000);
			 euser.sendMessageButton.click();
			 Assert.assertEquals(euser.errormsg3.getText(), "Please enter a valid URL");	 
		 }
		 
		 //Validate when the title and text is empty  
		 @Severity(SeverityLevel.TRIVIAL)
		 @Description("Test whether error message occurs when titile and body are empty")
		 @Test(priority=53)
		 public void validateTitleandBody()
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.emailid.sendKeys("john@doe.com");
			 euser.clickUser.click();
			 sleep(3000);
			 euser.urlClickCheckbox.click();
			 euser.url.sendKeys("https://www.codeproject.com");
			 euser.sendMessageButton.click();
			 Assert.assertEquals(euser.errormsg1.getText(), "Please enter the Message Title");
			 Assert.assertEquals(euser.errormsg2.getText(), "Please enter the Message Description"); 
		 }
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("Test whether send notification button is displayed")
		 @Test(priority=54)
		 public void checkSendNotification()
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.emailid.sendKeys("john@doe.com"); 
			 euser.checkbox.click();
			 Assert.assertTrue(euser.sendNotification.isDisplayed(), "The send notification button is not displayed");
		 }
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("Test whether send notification functionality is working fine or not")
		 @Test(priority=55)
		 public void checkSendNotificationMultipleUser()
		 {
			 euser.sendNotificationMultipleUser();
		 }
		  
		 @Severity(SeverityLevel.MINOR)
		 @Description("Test whether pagination is working or not")
		 @Test(priority=56)
		 public void checkPagination()
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.checkPagination();
		 }
		 
		 @Severity(SeverityLevel.CRITICAL)
		 @Test(priority=57,dataProvider="getTestData1")
		 public void searchusersname(String searchterm)
		 {
			 euser.clickEngageTab();
			 euser.clickWithUsers();
			 euser.searchUseronterm(searchterm);
		 }
		 
		 @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }

}
