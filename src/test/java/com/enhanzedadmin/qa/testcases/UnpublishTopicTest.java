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
import com.enhanzedadmin.qa.pages.UnpublishTopic;

public class UnpublishTopicTest extends Testbaseadmin {
	
	AdminorgcodeUI org;
	 Adminlogin log;
	 UnpublishTopic topic;
	 TestUtil testutil;
	 
	 String sheetName = "UnpublishTopicSheet";
	 
	 public UnpublishTopicTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			topic=new UnpublishTopic();
					
	}
	 
	//To read the test data from the excel sheet 
	 @DataProvider
	 public Object[][] getTestData()
	 {
		Object data[][]= testutil.getTestData(sheetName);
		return data; 
	 }
	 
	 //for unpublishing topic
	 @Test(dataProvider="getTestData")
	 public void unPublishTopic(String topicName) throws InterruptedException, AWTException
	 {
		topic.clickContent();
		topic.clickManageTopics();
		topic.unPublishTopic(topicName); 
		}
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }


}
