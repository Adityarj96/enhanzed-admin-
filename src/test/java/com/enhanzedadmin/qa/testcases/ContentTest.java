package com.enhanzedadmin.qa.testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.enhanzedadmin.qa.pages.ContentManageContent;
import com.enhanzedadmin.qa.pages.ContentManageObjects;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContentTest extends Testbaseadmin 
{
	
	 AdminorgcodeUI org;
	 Adminlogin log;
	 ContentManageContent contentobj;
	 TestUtil testutil;
	 
	 String sheetName="AddObject";
	 
	 public ContentTest() {
			super();
		}
	 
	 
	   @BeforeMethod
		public void setup() throws InterruptedException {
			//initialization();
		org=new AdminorgcodeUI();
		org.typeorganisation(prop.getProperty("orgcode"));
		log=new Adminlogin();
		log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		contentobj=new ContentManageContent();
					
	}
	   
	   

		 @DataProvider
		 public Object[][] getTestData()
		 {
			Object data[][]= testutil.getTestData(sheetName);
			return data; 
		 }
	   
	   
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic name")
	   @Test(priority=1)
	   public void addEmptyTopic()
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.clickAddTopic();
		   contentobj.clickAddPopUP();
		   Assert.assertEquals(contentobj.topicTitleEmptymsg.getText(),"Topic name cannot be empty", "The message is not displayed");
		   Assert.assertEquals(contentobj.topicImageErrorMessage.getText(),"Please select a Topic Image", "The message is not displayed");
		   System.out.println("1");
	   }
	   
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic name")
	   @Test(priority=2)
	   public void addEmptyTopicName() throws AWTException, InterruptedException
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.clickAddTopic();
		   contentobj.addTopicImage(contentobj.path2);
		   contentobj.clickAddPopUP();
		   Assert.assertEquals(contentobj.topicTitleEmptymsg.getText(),"Topic name cannot be empty", "The message is not displayed");
		   System.out.println("2");
	   }
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic image")
	   @Test(priority=3)
	   public void addEmptyTopicImage() throws AWTException
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.clickAddTopic();
		   contentobj.topicTitletextBox.sendKeys("Test topic title");
		   contentobj.clickAddPopUP();
		   Assert.assertEquals(contentobj.topicImageErrorMessage.getText(),"Please select a Topic Image", "The message is not displayed");
		   System.out.println("3");
	   }
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic image")
	   @Test(priority=4)
	   public void addDuplicateTopic() throws AWTException, InterruptedException
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.clickAddTopic();
		   contentobj.topicTitletextBox.sendKeys("Medical courses");
		   contentobj.addTopicImage(contentobj.path2);
		   contentobj.clickAddPopUP();
		   Assert.assertEquals(contentobj.duplicateTopicNameErrorMessage.getText(),"Topic with the same name already exists", "The message is not displayed");
		   System.out.println("4");
	   }
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic image")
	   @Test(priority=5)
	   public void addTopic() throws AWTException, InterruptedException
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.clickAddTopic();
		   contentobj.topicTitletextBox.sendKeys(RandomStringUtils.randomAlphabetic(10));
		   contentobj.addTopicImage(contentobj.path2);
		   contentobj.clickAddPopUP();
		   System.out.println("5");
	   }
	   
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file all the fields are blank")
		 @Test(priority=6)
		 public void checkAudioBlankCredentials() 
		 {
			 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.clicksavebutton();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
			 sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
			 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
			 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
			 sa.assertAll();
			 System.out.println("6");
			
		 }
	     
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file when title is not blank")
		 @Test(priority=7)
		 public void checkBalnkCredentials() 
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.addTitle.sendKeys("Test ttile");
		     contentobj.clicksavebutton();
		     SoftAssert sa=new SoftAssert();
		     sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
			 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
			 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
			 sa.assertAll();
			 System.out.println("7");
		 }
	   
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file when title and description is not blank ")
		 @Test(priority=8)
		 public void checkBalnkCredentialsDurationCategory() 
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.addTitle.sendKeys("Test ttile");
		     contentobj.addDescription.sendKeys("Test ttile description");
		     contentobj.clicksavebutton();
		     SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
			 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
			 sa.assertAll();
			 System.out.println("8");
		 }
	   
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file when file and category is  blank")
		 @Test(priority=9)
		 public void checkBalnkCredentialsFileUpload() 
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.addTitle.sendKeys("Test ttile");
		     contentobj.addDescription.sendKeys("Test ttile description");
		     contentobj.addDuration.sendKeys("5");
		     contentobj.clicksavebutton();
		     SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
			 sa.assertAll();
			 System.out.println("9");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file when title is  not given")
		 @Test(priority=10)
		 public void checkOnlyBlankTitle() throws AWTException, InterruptedException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.addDescription.sendKeys("Test ttile description");
		     contentobj.addDuration.sendKeys("5");
		     contentobj.addFile(contentobj.path1);
		     contentobj.clicksavebutton();
		     Assert.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
		     System.out.println("10");
		 }
	   
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check for uploading an audio file when only audio file is uploaded")
		 @Test(priority=11)
		 public void checkOnlyWhenAudioUploaded() throws AWTException, InterruptedException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
		     contentobj.addAudioObject();
		     contentobj.addFile(contentobj.path1);
			 contentobj.clicksavebutton();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
			 sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
			 sa.assertAll();
			 System.out.println("11");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating balnk html object")
		 @Test(priority=12)
		 public void checkHtmlBlankData()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addNarative();
			 contentobj.createhtml.click();
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title");
			 sa.assertEquals(contentobj.htmlcontenterrormsg.getText(), "HTML content cannot be empty", "The message not displayed for html content");
			 sa.assertAll();
			 System.out.println("12");
			  
		 }
	     
	     
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating blank html content body")
		 @Test(priority=13)
		 public void checkHtmlBalnkContentbody()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addNarative();
			 contentobj.createhtml.click();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.htmlcontenterrormsg.getText(), "HTML content cannot be empty", "The message not displayed for html content");
			 sa.assertAll();
			 System.out.println("13");
			  
		 }
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating html  when content,ttile,category is blank ") 
		 @Test(priority=14)
		 public void checkUploadingBlankHtml()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addNarative();
			 contentobj.upload_html.click();
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title"); 
			 sa.assertEquals( contentobj.uploadhtmlerror.getText(), "Please select a HTML to upload", "The message is not displayed for upload html"); 
			 sa.assertAll();
			 System.out.println("14");
		 }
	   
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating html  when content,title,category is blank ") 
		 @Test(priority=15)
		 public void checkUploadingBlankFileandCategory()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addNarative();
			 contentobj.upload_html.click();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals( contentobj.uploadhtmlerror.getText(), "Please select a HTML to upload", "The message is not displayed for upload html");   
			 sa.assertAll();
			 System.out.println("15");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating html when title is blank ") 
		 @Test(priority=16)
		 public void checkUploadingBlankTitle() throws InterruptedException, AWTException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addNarative();
			 contentobj.upload_html.click();
			  contentobj.addFile(contentobj.path3);
			 contentobj.savebutton.click();
			 Assert.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title"); 
			 System.out.println("16");
		 }
	     
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating blank pdfobject") 
		 @Test(priority=17)
		 public void checkuploadPdfWhenBlank()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addPdf();
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();
			 sa.assertEquals( contentobj.pdftitleerrormsg.getText(), "PDF title cannot be empty", "The message is not displayed for pdftitle");
			 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "PDF to upload cannot be empty", "The message is not displayed for pdfupload");
			 sa.assertAll();
			 System.out.println("17");  
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating interactivity object")
		 @Test(priority=18)
		 public void checkinteractivity() throws InterruptedException, AWTException
		 {
			 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addInteractivity();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
			 sleep(3000);
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();	
			 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "Swipper to upload cannot be empty", "The message is not displayed for swiper upload");
			 sa.assertAll();
			 System.out.println("18");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating interactivity object")
		 @Test(priority=19)
		 public void checkinteractivitywhenimageandsubcategorynotgiven() throws InterruptedException, AWTException
		 {
			 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addInteractivity();
			 sleep(3000);
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();	
			 sa.assertEquals( contentobj.pdftitleerrormsg.getText(), "Swipper title cannot be empty", "The message is not displayed for swiper title");
			 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "Swipper to upload cannot be empty", "The message is not displayed for swiper upload");
			 sa.assertAll();
			 System.out.println("19"); 
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating blank video object")
		 @Test(priority=20)
		 public void checkaddingblankvideo() throws InterruptedException, AWTException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj. addVideo();
			 sleep(3000);
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();	
			 sa.assertEquals( contentobj.videotitleerrormsg.getText(), "Video title cannot be empty", "The message is not displayed for video title");
			 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
			 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
			 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
			 sa.assertAll();
			 System.out.println("20");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating  video object without description")
		 @Test(priority=21)
		 public void checkaddingdescriptionvideovideo() throws InterruptedException, AWTException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj. addVideo();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
			 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
			 sleep(3000);
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();	
			 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
			 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
			 sa.assertAll();
			 System.out.println("21");
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating  video object without description")
		 @Test(priority=22)
		 public void checkaddingdurationvideovideo() throws InterruptedException, AWTException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj. addVideo();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
			 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
			 contentobj.addDuration.sendKeys("5");
			 sleep(3000);
			 contentobj.savebutton.click();
			 SoftAssert sa=new SoftAssert();	
			 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
			 sa.assertAll();
			 System.out.println("22");  
		 }
	     
	     @Severity(SeverityLevel.TRIVIAL)
		 @Description("Check creating  video object without description")
		 @Test(priority=23)
		 public void checkaddingfilevideowithoutdescription() throws InterruptedException, AWTException
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj. addVideo();
			 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
			 contentobj.addFile(contentobj.path4);
			 contentobj.addDuration.sendKeys("5");
			 sleep(3000);
			 contentobj.savebutton.click();
			 Assert.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
			 System.out.println("23");
		 }
	     
	     @Severity(SeverityLevel.CRITICAL)
		 @Description("Check creating  quiz object without question name")
		 @Test(priority=24)
		 public void checkaddingquizobject()
		 {
	    	 contentobj.clickContent();
			 contentobj.clickManageContent();
			 contentobj.addDummyObject();
			 contentobj.addQuiz();
			 contentobj.formativequizwithfeedback.click();
			 sleep(3000);
			 contentobj.addquestion.click();
			 Assert.assertEquals( contentobj.quizTitleErrorMessage.getText(),"Quiz title cannot be empty", "The message is not displayed");
			 System.out.println("24");
		 }
	   
	   @Severity(SeverityLevel.TRIVIAL)
	   @Description("Check whether the user can upload empty topic image")
	   @Test(priority=25,dataProvider="getTestData")
	   public void addobject(String topicName,String index) throws AWTException, InterruptedException
	   {
		   contentobj.clickContent();
		   contentobj.clickManageContent();
		   contentobj.addObject(topicName,index);
	   }
	   
	   
	   
	   
	   
	   
	
	
	   @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
	
	

}
