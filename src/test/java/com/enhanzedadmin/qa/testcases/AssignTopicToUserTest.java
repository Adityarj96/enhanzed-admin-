package com.enhanzedadmin.qa.testcases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.AssignTopicToUser;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AssignTopicToUserTest extends Testbaseadmin {
	
	 AdminorgcodeUI org;
	 Adminlogin log;
	 AssignTopicToUser assignTopic;
	 TestUtil testutil;
	 
	 String sheetName = "AssignTopicToUser";
	 String sheetName1 = "AssignUsersSearch";
	 String sheetName2 = "unassigntopic";
	 String sheetName3="Assignsearchusername";
	 String sheetName4="Assignsearchstatus";
	 
	 public AssignTopicToUserTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			assignTopic = new AssignTopicToUser();
					
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
			Object data[][]= testutil.getTestData(sheetName);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData2()
		 {
			Object data[][]= testutil.getTestData(sheetName1);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData3()
		 {
			Object data[][]= testutil.getTestData(sheetName2);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData4()
		 {
			Object data[][]= testutil.getTestData(sheetName3);
			return data; 
		 }
		 
		 @DataProvider
		 public Object[][] getTestData5()
		 {
			Object data[][]= testutil.getTestData(sheetName4);
			return data; 
		 }
		 
		@Severity(SeverityLevel.NORMAL)
		@Description("check UI of the assigned topics tab")
	    @Test(priority=39)
		 public void checkUI()
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers();
			 assignTopic. emailid.sendKeys("john@doe.com");
			 assignTopic. searchresult.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertTrue(assignTopic.checkassignedtab(), "The assigned tab is not present");
			 sa.assertTrue(assignTopic.checkunassignedtab(), "The unassigned tab is not present");
			 sa.assertTrue(assignTopic.checkSearchtextbox(), "The search text box  is not present");
			 sa.assertTrue(assignTopic.checkpagination(), "The pagination is not displayed");
			 sa.assertAll();
		 }
		 
		
		@Severity(SeverityLevel.CRITICAL)
		@Description("check assigning the topic to user with due date")
		 @Test(priority=40,dataProvider="getTestData")
		 public void assignTopicToUser(String emailID, String topicName) throws InterruptedException
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers();
			 assignTopic.assignTopicToUsers(emailID,topicName);  
		}
		@Severity(SeverityLevel.CRITICAL)
		@Description("check unassigning the topic with due date")
		 @Test(priority=41,dataProvider="getTestData")
		 public void unassignUsersTopic(String emailID, String topicName)
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers(); 
			 assignTopic .UnassignTopictouser(emailID,topicName);
		 }
		 
		@Severity(SeverityLevel.MINOR)
		@Description("search users basedon search term emailid")
		 @Test(priority=42,dataProvider="getTestData2")
		 public void searchUserBasedonSearchTerms(String searchterm)
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers(); 
			 assignTopic.searchUseronterm(searchterm); 
		 }
		
		
		@Severity(SeverityLevel.MINOR)
		@Description("search users basedon search term name")
		 @Test(priority=43,dataProvider="getTestData4")
		 public void searchUserBasedonSearchTermsname(String searchterm)
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers(); 
			 assignTopic.searchUserontermname(searchterm); 
		 }
		
		@Severity(SeverityLevel.MINOR)
		@Description("search users basedon search term status")
		 @Test(priority=44,dataProvider="getTestData5")
		 public void searchUsersactivestatus(String searchterm)
		 {
			 assignTopic.clickAssignTab();
			 assignTopic.clickToUsers(); 
			 assignTopic.searchUsersactivestatus(searchterm); 
		 }
		
		@Severity(SeverityLevel.MINOR)
		@Description("check pagination")
		 @Test(priority=45)
		 public void checkPagination() {
		 assignTopic.clickAssignTab();
	     assignTopic.clickToUsers();
		 assignTopic.checkPagination();
		 }
		 
		 @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }

}
