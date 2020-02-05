package com.enhanzedadmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.AssignTopicToGroup;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AssignTopicToGroupTest extends Testbaseadmin {
	
	 AdminorgcodeUI org;
	 Adminlogin log;
	 AssignTopicToGroup assignTopicgroup;
	 TestUtil testutil;
	 
	 String sheetName = "AssignTopicToGroup";
	 String sheetName1 = "checkgroupui";
	 
	 public AssignTopicToGroupTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			assignTopicgroup = new AssignTopicToGroup();
					
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
		 
		 /*@Severity(SeverityLevel.NORMAL)
		 @Description("To check all the UI attributes of the group")
		 @Test(priority=46)
		 public void checkGroupUI()
		 {
			 assignTopicgroup.clickAssignTab();
			 assignTopicgroup.clickToGroup();
			 SoftAssert sa=new SoftAssert();
			 sa.assertTrue(assignTopicgroup.checkAllGroup(), "The groups are not present");
			 sa.assertTrue(assignTopicgroup.checkpagination(), "The pagination is not displayed");
			 sa.assertTrue(assignTopicgroup.checkSearchTopic(), "The search text box is not displayed");
			 sa.assertAll(); 
		 }*/
		
		 @Severity(SeverityLevel.CRITICAL)
		 @Description("To check whether the topic can be assigned to the group")
		 @Test(priority=47,dataProvider="getTestData")
		 public void checkAssigntoGroup(String groupName,String topicName)
		 {
			 assignTopicgroup.clickAssignTab();
			 assignTopicgroup.clickToGroup();
			 assignTopicgroup.assignTopicToGroup(groupName,topicName); 
		 }
		 
		
		 
		/* @Severity(SeverityLevel.CRITICAL)
		 @Description("To check whether the topic can be unassigned to the group")
		 @Test(priority=48,dataProvider="getTestData")
		 public void checkUnAssignTopictogroup(String groupName,String topicName)
		 {
			 assignTopicgroup.clickAssignTab();
			 assignTopicgroup.clickToGroup(); 
			 assignTopicgroup.unassignTopicToGroup(groupName, topicName);
		 }*/
		 
		
		 /*@Severity(SeverityLevel.CRITICAL)
		 @Description("To check whether the topic can be unassigned to the group")
		 @Test(priority=49,dataProvider="getTestData1")
		 public void checkUnAssignTopictogroupUI(String groupName)
		 {
			 assignTopicgroup.clickAssignTab();
			 assignTopicgroup.clickToGroup();
			 assignTopicgroup.checkSearchTopic();
		 }*/
		 
		 @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }



}
