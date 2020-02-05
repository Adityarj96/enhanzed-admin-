package com.enhanzedadmin.qa.testcases;

import java.awt.AWTException;

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
import com.enhanzedadmin.qa.pages.CreateTopic;

public class CreateTopicTest extends Testbaseadmin {

	 AdminorgcodeUI org;
	 Adminlogin log;
	 CreateTopic topic;
	 TestUtil testutil;
	 
	 String sheetName = "CreateTopicSheet";
	 
	 public CreateTopicTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			//initialization();
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			topic=new CreateTopic();
					
	}
	 
	//To read the test data from the excel sheet 
	 @DataProvider
	 public Object[][] getTestData()
	 {
		Object data[][]= testutil.getTestData(sheetName);
		return data; 
	 }
	 
	 //verifying the UI of Manage Groups page
	 @Test(priority=1)
	 public void uiCheck()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 SoftAssert sa = new SoftAssert();
			
		sa.assertTrue(topic.topicNameHeader(), "the topic name header is not present");
		sa.assertTrue(topic.checkcreatedByHeader(), "the created by header is not present");
		sa.assertTrue(topic.publishedHeader(), "the published header is not present");
		sa.assertTrue(topic.createTopicBtn(), "the create topic button is not present");
		sa.assertTrue(topic.breadCrumb(), "the bread crumb is not present");
		sa.assertAll();
	 }
	 
	 //check creating topic without adding topic title
	 @Test(priority=2)
	 public void checkCreatingemptytopic()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Topic title cannot be empty");
	 }
	 
	 //check creating the topic without overview
	 @Test(priority=3)
	 public void checkCreatingWithoutOverview()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Topic description cannot be empty in Overview section");
	 }
	 
	 //Check creating topic without preferences (free navigation) 
	 @Test(priority=4)
	 public void checkCreatingtopicwithoutPreferences()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title"); 
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview");
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Please select Navigation type in Preferences section"); 
	 }
	 
	 //Check creating topic without preferences (learning type) 
	 @Test(priority=5)
	 public void checkCreatingtopicwithoutPreferencesEnforceLearning()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title"); 
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.clickpreferences();
		 topic.clickfreenavigation();
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"You need to add atleast 1 Category");
		 
	 }
	 
	 @Test(priority=6)
	 public void checkCreatingtopicwithouttitle()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.clickpreferences();
		 topic.clickfreenavigation();
		 topic.clickCategory();
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Topic title cannot be empty"); 
	 }
	 
	 @Test(priority=7)
	 public void checkCreatingtopicwithoutcertificate()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.clickpreferences();
		 topic.clickLearningPathRegular();
		 topic.learningTypeclick();
		 topic.clickCategory();
		 topic.subcategory.click();
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Certification should be selected as either Yes or No."); 
	 }
	 
	 @Test(priority=8)
	 public void checkCreatingtopicwithoutimage()
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.clickpreferences();
		 topic.clickLearningPathRegular();
		 topic.learningTypeclick();
		 topic.clickCategory();
		 topic.subcategory.click();
		 topic.clickcertificate();
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Please select a Topic image"); 
	 }
	 
	 
	 @Test(priority=9)
	 public void checkCreatingtopicwithoutcontent() throws InterruptedException, AWTException
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.clickpreferences();
		 topic.clickLearningPathRegular();
		 topic.learningTypeclick();
		 topic.clickCategory();
		 topic.subcategory.click();
		 topic.clickcertificate();
		 topic.addImage();
	     sleep(5000);
		 topic.saveTopic.click();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"You need to add atleast 1 Nugget"); 
	 }
	 
	 
	 @Test(priority=10)
	 public void checkCretatingemptynuggetname() throws InterruptedException, AWTException
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic. clickContenttopic();
		 sleep(3000);
		 topic.addNugget.click();
		 sleep(3000);
		 topic.addNuggetButton.click();
		 Assert.assertEquals(topic.nuggetErrorMesage.getText(),"Please enter the Nugget Title");
	 }
	 
	 
	 @Test(priority=11)
	 public void checkCretatingTopicMoreThan30mbFile() throws InterruptedException, AWTException
	 {
		 topic.clickContent();
		 topic.clickManageTopics();
		 topic.clickCreateTopicButton();
		 topic.addTopicText.sendKeys("Test title");
		 topic.overviewTabClick.click();
		 topic.addOverview.sendKeys("Test Overview"); 
		 topic.addImagegreatersize();
		 Assert.assertEquals(topic.topicerrormsgs.getText(),"Image size is too large. File size cannot be greater than 5mb."); 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //for creating topic
	/* @Test(priority=2,dataProvider="getTestData")
	 public void createTopics(String topicname) throws InterruptedException, AWTException
	 {
		 
		topic.clickContent();
		topic.clickManageTopics();
		topic.clickCreateTopicButton();
		topic.topicCreationContent(topicname);
		  
		 
	}*/
	 
	 //creating blank topic
	 /*@Test(priority=3)
	 public void blankTopic()
	 {
		topic.clickContent();
		topic.clickManageTopics();
		topic.clickCreateTopicButton();
		topic.createBlankTopic();
	 }
	 
	 //creating incomplete topic
	 @Test(priority=4)
	 public void incompleteTopic()
	 {
		topic.clickContent();
		topic.clickManageTopics();
		topic.clickCreateTopicButton();
		topic.createIncompleteTopic();
	 }*/
	 
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
}
