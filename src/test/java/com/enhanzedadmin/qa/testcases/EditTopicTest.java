package com.enhanzedadmin.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.EditTopic;

public class EditTopicTest extends Testbaseadmin {
	
	AdminorgcodeUI org;
	 Adminlogin log;
	EditTopic topic;
	 TestUtil testutil;
	 
	 String sheetName = "EditTopicSheet";
	 String sheetName1="Sheet2";
	 String sheetName2="DeleteObject";
	 
	 public EditTopicTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			topic=new EditTopic();			
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
	 
	 
	 //for edititng and saving topic
	@Test(priority=1,dataProvider="getTestData")
	 public void editAndSaveTopic(String topicName,String editText) throws InterruptedException, AWTException
	 {
		 
		topic.clickContent();
		topic.clickManageTopics();
		topic.editTopic(topicName, editText); 
		}
	 
	 //for edititng and discarding topic
	 @Test(priority=2,dataProvider="getTestData")
	 public void discardAndSaveTopic(String topicName,String editText) throws InterruptedException, AWTException
	 { 
		topic.clickContent();
		topic.clickManageTopics();
		topic.discardTopic(topicName, editText);
	 }
	 
	 @Test(priority=3,dataProvider="getTestData1")
	 public void deleteNugget(String topicName,String nuggetName) throws InterruptedException, AWTException
	 {
		topic.clickContent();
		topic.clickManageTopics();
		topic.deleteNugget(topicName,nuggetName); 
		}
	 
	 @Test(priority=4,dataProvider="getTestData2")
	 public void deleteObject(String topicName) throws InterruptedException, AWTException
	 { 
		topic.clickContent();
		topic.clickManageTopics();
		topic.removeObject(topicName); 
		}
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }

}
