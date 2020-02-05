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
import com.enhanzedadmin.qa.pages.ContentManageCategories;
import com.enhanzedadmin.qa.pages.ContentManageObjects;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContentManageObjectsTest extends Testbaseadmin
{
	 AdminorgcodeUI org;
	 Adminlogin log;
	 ContentManageObjects contentobj;
	 TestUtil testutil;
	
	
	 public ContentManageObjectsTest() {
			super();
		}
	 
	
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			//initialization();
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		    contentobj=new  ContentManageObjects();
					
	}
	 
	 
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file all the fields are blank")
	 @Test(priority=56)
	 public void checkAudioBlankCredentials() 
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject();
	     contentobj.clicksavebutton();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
		 sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
		 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
		 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("1");
	 }*/
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when title is not blank")
	 @Test(priority=57)
	 public void checkBalnkCredentials() 
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject();
	     contentobj.addTitle.sendKeys("Test ttile");
	     contentobj.clicksavebutton();
	     SoftAssert sa=new SoftAssert();
	     sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
		 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
		 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("2");
	 }*/
	 
	 
	 /*@Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when title and description is not blank ")
	 @Test(priority=58)
	 public void checkBalnkCredentialsDurationCategory() 
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject();
	     contentobj.addTitle.sendKeys("Test ttile");
	     contentobj.addDescription.sendKeys("Test ttile description");
	     contentobj.clicksavebutton();
	     SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
		 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("3");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when file and category is  blank")
	 @Test(priority=59)
	 public void checkBalnkCredentialsFileUpload() 
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject();
	     contentobj.addTitle.sendKeys("Test ttile");
	     contentobj.addDescription.sendKeys("Test ttile description");
	     contentobj.addDuration.sendKeys("5");
	     contentobj.clicksavebutton();
	     SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("4");
	 }*/
	 
	 /*@Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when  category is  not given")
	 @Test(priority=60)
	 public void checkBalnkCredentialsSelectCategory() throws InterruptedException, AWTException 
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject();
	     contentobj.addTitle.sendKeys("Test ttile");
	     contentobj.addDescription.sendKeys("Test ttile description");
	     contentobj.addDuration.sendKeys("5");
	     contentobj.browseaudiofile(contentobj.path1);
	     contentobj.clicksavebutton();
	     SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("5");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when title is  not given")
	 @Test(priority=61)
	 public void checkOnlyBlankTitle() throws AWTException, InterruptedException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
	     contentobj.addAudioObject(); 
	     contentobj.addDescription.sendKeys("Test ttile description");
	     contentobj.addDuration.sendKeys("5");
	     contentobj.browseaudiofile(contentobj.path1);
	     contentobj.category.click();
	     contentobj.clicksavebutton();
	     Assert.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
	     System.out.println("6");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when title and duration is  not given")
	 @Test(priority=62)
	 public void checkWhenTitleAndDurationEmpty()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addAudioObject(); 
		 contentobj.addTitle.sendKeys("Test ttile");
		 contentobj.addDescription.sendKeys("Test ttile description");
		 contentobj.category.click();
		 contentobj.clicksavebutton();
		 Assert.assertEquals(contentobj.audiodurationemptymsg.getText(),"Audio duration cannot be empty", "The message for audio duration is not displayed");
		 Assert.assertEquals(contentobj.fileuploaderrormsg.getText(),"Please select a audio file to upload", "The message for fileupload is not displayed");
		 System.out.println("7");
	 }
	        
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check for uploading an audio file when only audio file is uploaded")
	 @Test(priority=63)
	 public void checkOnlyWhenAudioUploaded() throws AWTException, InterruptedException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addAudioObject(); 
		 contentobj.browseaudiofile(contentobj.path1);
		 contentobj.clicksavebutton();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.audiotitleerrormsg.getText(),"Audio title cannot be empty", "The message for audio is not displayed");
		 sa.assertEquals(contentobj.audiodescriptionerrormsg.getText(),"Audio description cannot be empty", "The message for audio description is not displayed");
		 sa.assertEquals(contentobj.categoryerrormsg.getText(),"Please select category", "The message for the category is not displayed");
		 sa.assertAll();
		 System.out.println("8");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check cancellation of uploading an audio file")
	 @Test(priority=64)
	 public void checkCancelCreationofAudioObj() throws AWTException, InterruptedException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addAudioObject();
		 contentobj.addTitle.sendKeys("Test ttile cancel");
		 contentobj.addDescription.sendKeys("Test ttile description");
		 contentobj.addDuration.sendKeys("5");
		 contentobj.browseaudiofile(contentobj.path1);
		 contentobj.category.click();
		 contentobj.cancelbutton.click();
		 contentobj. searchtitle.sendKeys("Test ttile cancel");
		// Assert.assertTrue(contentobj.result.getText().contains("No Data"));//
		 System.out.println("9");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating an audio object")
	 @Test(priority=65,invocationCount=2)
	 public void addAudioObjectAndPublish() throws AWTException, InterruptedException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.clickaudioandpublish();
		 System.out.println("10");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating narative object")
	 @Test(priority=66,invocationCount=2)
	 public void addNarativeHtmlObject()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.clicknarativepublish();
		 System.out.println("11");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating balnk html object")
	 @Test(priority=67)
	 public void checkHtmlBlankData()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.createhtml.click();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title");
		 sa.assertEquals(contentobj.htmlcontenterrormsg.getText(), "HTML content cannot be empty", "The message not displayed for html content");
		 sa.assertEquals(contentobj.htmlcategoryerrormsg.getText(), "Please select category", "The message not displayed for category");
		 sa.assertAll();
		 System.out.println("12");
		  
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating blank html content body")
	 @Test(priority=68)
	 public void checkHtmlBalnkContentbody()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.createhtml.click();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.htmlcontenterrormsg.getText(), "HTML content cannot be empty", "The message not displayed for html content");
		 sa.assertEquals(contentobj.htmlcategoryerrormsg.getText(), "Please select category", "The message not displayed for category");
		 sa.assertAll();
		 System.out.println("13");
		  
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html  when category is blank ") 
	 @Test(priority=69)
	 public void checkHtmlBalnkCategory()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.createhtml.click();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj. htmlcontent.sendKeys(RandomStringUtils.randomAlphabetic(100));
		 contentobj.savebutton.click();
		 
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.htmlcategoryerrormsg.getText(), "Please select category", "The message not displayed for category");
		 sa.assertAll();
		 System.out.println("14");
		  
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html  when title and content is blank ") 
	 @Test(priority=70)
	 public void checkHtmlBalnkTitleAndBlankBody()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.createhtml.click();
		 contentobj.category.click();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertNotNull(contentobj.htmltitleerrormsg.getText(), "The message is not present");
		 sa.assertNotNull(contentobj.htmlcontenterrormsg.getText(),"The message is not present");
		 sa.assertAll();
		 System.out.println("15");
		  
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html  when content is blank ") 
	 @Test(priority=71)
	 public void checkWhenConentBlank()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.createhtml.click();
		 contentobj.category.click();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.category.click();
		 contentobj.savebutton.click();
		 Assert.assertEquals(contentobj.htmlcontenterrormsg.getText(), "HTML content cannot be empty", "The message not displayed for html content");
		 System.out.println("16");
		
	 }
	
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html  when content,ttile,category is blank ") 
	 @Test(priority=72)
	 public void checkUploadingBlankHtml()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.upload_html.click();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title"); 
		 sa.assertEquals( contentobj.uploadhtmlerror.getText(), "Please select a HTML to upload", "The message is not displayed for upload html"); 
		 sa.assertEquals(contentobj.uploadcategoryerror.getText(),"Please select category"   ,"The message is not displayed");
		 sa.assertAll();
		 System.out.println("17");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html  when content,title,category is blank ") 
	 @Test(priority=73)
	 public void checkUploadingBlankFileandCategory()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.upload_html.click();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals( contentobj.uploadhtmlerror.getText(), "Please select a HTML to upload", "The message is not displayed for upload html");   
		   sa.assertEquals(contentobj.uploadcategoryerror.getText(),"Please select category"   ,"The message is not displayed");
		   sa.assertAll();
		   System.out.println("18");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html when title is blank ") 
	 @Test(priority=74)
	 public void checkUploadingBlankTitle() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addNarative();
		 contentobj.upload_html.click();
		 contentobj.addnarativeobject();
		 contentobj.category.click();
		 contentobj.savebutton.click();
		 Assert.assertEquals(contentobj.htmltitleerrormsg.getText(), "HTML title cannot be empty", "The message not displayed for html title"); 
		 System.out.println("19");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating html object") 
	 @Test(priority=75,invocationCount=2)
	 public void checkUploAdinghtml() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.checkuploadhtml();
		 System.out.println("20");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating blank pdfobject") 
	 @Test(priority=76)
	 public void checkuploadPdfWhenBlank()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals( contentobj.pdftitleerrormsg.getText(), "PDF title cannot be empty", "The message is not displayed for pdftitle");
		 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "PDF to upload cannot be empty", "The message is not displayed for pdfupload");
		 sa.assertEquals( contentobj.pdfcategoryerrormsg.getText(), "Please select category", "The message is not displayed for pdfcategory");
		 sa.assertAll();
		 System.out.println("21");
		  
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating pdf object when file is balnk") 
	 @Test(priority=77)
	 public void checkUploadPdfWhenFileisBlank()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	 
		 sa.assertEquals(contentobj.pdfuploaderrormsg.getText(), "PDF to upload cannot be empty", "The message is not displayed for pdfupload");
		 sa.assertEquals(contentobj.pdfcategoryerrormsg.getText(), "Please select category", "The message is not displayed for pdfcategory");
		 sa.assertAll();
		 System.out.println("22");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating pdf object when category is balnk") 
	 @Test(priority=78)
	 public void checkWhenCategoryIsNotGiven() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.addpdfobject();
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	 
		 sa.assertEquals( contentobj.pdfcategoryerrormsg.getText(), "Please select category", "The message is not displayed for pdfcategory");
		 sa.assertAll(); 
		 System.out.println("23");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating pdf object when title is balnk") 
	 @Test(priority=79)
	 public void checkWhenTitleNotGiven() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects();
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.addpdfobject();
		 contentobj.category.click();
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.pdftitleerrormsg.getText(), "PDF title cannot be empty", "The message is not displayed for pdftitle");
		 System.out.println("24");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating pdf object when pdf file is balnk") 
	 @Test(priority=80)
	 public void checkWhenFilenotUploaded()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.category.click();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.pdfuploaderrormsg.getText(), "PDF to upload cannot be empty", "The message is not displayed for pdfupload");
		 System.out.println("25");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating pdf object") 
	 @Test(priority=81)
	 public void checkuploadpdf() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addPdf();
		 contentobj.checkuploadpdf();
		 System.out.println("26");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating interactivity object")
	 @Test(priority=82)
	 public void checkinteractivity() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addInteractivity();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "Swipper to upload cannot be empty", "The message is not displayed for swiper upload");
		 sa.assertEquals( contentobj.pdfcategoryerrormsg.getText(), "Please select category", "The message is not displayed for swipercategory");
		 sa.assertAll();
		 System.out.println("27");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating interactivity object")
	 @Test(priority=83)
	 public void checkinteractivitywhenimageandsubcategorynotgiven() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addInteractivity();
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.pdftitleerrormsg.getText(), "Swipper title cannot be empty", "The message is not displayed for swiper title");
		 sa.assertEquals( contentobj.pdfuploaderrormsg.getText(), "Swipper to upload cannot be empty", "The message is not displayed for swiper upload");
		 sa.assertEquals( contentobj.pdfcategoryerrormsg.getText(), "Please select category", "The message is not displayed for swipercategory");
		 sa.assertAll();
		 System.out.println("28");
		 
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating interactivity object when swiper object not added")
	 @Test(priority=84)
	 public void checkinteractivitywhenimagenotgiven() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addInteractivity();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		 contentobj.category.click();
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.pdfuploaderrormsg.getText(), "Swipper to upload cannot be empty", "The message is not displayed for swiper upload");
		 System.out.println("29");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating interactivity object when title not given")
	 @Test(priority=85)
	 public void checkinteractivitywhentitlenotgiven() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addInteractivity();
		 contentobj.addnarativeobject();
		 contentobj.category.click();
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.pdftitleerrormsg.getText(), "Swipper title cannot be empty", "The message is not displayed for swiper title");
		 System.out.println("30");
	 }
	                            
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating interactivity object when title not given")
	 @Test(priority=86,invocationCount=2)
	 public void checkaddinginteractivityandpublish() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addInteractivity();
		 contentobj.addInteractivityswiper();
		 System.out.println("31");
	 }*/
	 
	
	 
	 /*@Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating blank video object")
	 @Test(priority=88)
	 public void checkaddingtitlevideo() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("33");
		  
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating  video object without description")
	 @Test(priority=89)
	 public void checkaddingdescriptionvideovideo() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("34");
	 }*/
	 
	/* @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating  video object without description")
	 @Test(priority=90)
	 public void checkaddingdurationvideovideo() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
		 contentobj.addDuration.sendKeys("5");
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videofileerrormsg.getText(), "Please select a video to upload", "The message is not displayed for videofileupload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("35");
		  
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating  video object without category")
	 @Test(priority=91)
	 public void checkaddingfilevideo() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
		 contentobj.browsevideo();
		 contentobj.addDuration.sendKeys("5");
		 sleep(3000);
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("36");
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating  video object without description")
	 @Test(priority=92)
	 public void checkaddingfilevideowithoutdescription() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.browsevideo();
		 contentobj.addDuration.sendKeys("5");
		 contentobj.category.click();
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 System.out.println("37");
	 }*/
	 
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("Check creating  video object without category")
	 @Test(priority=93)
	 public void checkaddingwithoutcategory() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
		 contentobj.browsevideo();
		 contentobj.addDuration.sendKeys("5");
		 sleep(3000);
		 contentobj.savebutton.click();
		 Assert.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 System.out.println("38");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  video object without category")
	 @Test(priority=94,invocationCount=2)
	 public void checkaddingvideofile() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj. addVideo();
		 contentobj.addVideoObject();
		 System.out.println("39");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object without question name")
	 @Test(priority=95)
	 public void checkaddingquizobject()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 sleep(3000);
		 contentobj.addquestion.click();
		 Assert.assertEquals( contentobj.quizTitleErrorMessage.getText(),"Quiz title cannot be empty", "The message is not displayed");
		 System.out.println("40");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object without options")
	 @Test(priority=96)
	 public void checkaddingquizobjectwithoutoptions()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 contentobj.addqDescritionForQuiz.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquestion.click();
		 contentobj.addqDescrition.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquizquestion.click();
		 Assert.assertEquals( contentobj.optionserrormessage.getText(),"You need to enter at least 2 options", "The message is not displayed"); 
		 System.out.println("41");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object with same options options")
	 @Test(priority=97)
	 public void checkaddingquizobjectwithsameoptions() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 contentobj.addqDescritionForQuiz.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquestion.click();
		 contentobj.addqDescrition.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addQuizObjectsameoption();
		 contentobj.addquizquestion.click();
		 Assert.assertEquals( contentobj.optionserrormessage.getText(),"Entered options must have different values", "The message is not displayed");
		 System.out.println("42");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object by adding options")
	 @Test(priority=98)
	 public void checkaddingquizobjectwithonlyoptions() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 contentobj.addqDescritionForQuiz.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquestion.click();
		 contentobj.addQuizObjectsameoption();
		 contentobj.addquizquestion.click();
		 Assert.assertEquals(contentobj.addquestionerrormsg.getText(),"Question cannot be empty", "The message is not displayed"); 
		 System.out.println("43");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object without adding category options")
	 @Test(priority=99)
	 public void checkaddingquizwithoutcategory() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 contentobj.addqDescritionForQuiz.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquestion.click(); 
		 contentobj. addQuizObjectdifferentoption();
		 contentobj.clicksavefinalquizbutton();
		 Assert.assertEquals( contentobj.quizcategoryerrormsg.getText(),"Please select category", "The message is not displayed"); 
		 System.out.println("44");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("Check creating  quiz object")
	 @Test(priority=100,invocationCount=2)
	 public void checkaddingquiz() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addQuiz();
		 contentobj.formativequizwithfeedback.click();
		 contentobj.addqDescritionForQuiz.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addquestion.click(); 
		 contentobj.addQuizObjectdifferentoption();
		 contentobj.clickQuizCategory();
		 contentobj.quizsubcategory.click();
		 contentobj.clicksavefinalquizbutton(); 
		 System.out.println("45");
	 }
	 
	 @Test(priority=100,invocationCount=2)
	 public void checkYoutubeCreateObject()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addYoutubeObject();
		 System.out.println("46");
	 }
	 
	 @Test(priority=101,invocationCount=2)
	 public void checkVimeoCreateObject()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.addVimeoObject();
		 System.out.println("47");
	 }
	 
	 @Test(priority=102)
	 public void checkErrorMessagesYT()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videotitleerrormsg.getText(), "Video title cannot be empty", "The message is not displayed for video title");
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("48");
	 }
	 
	 
	 @Test(priority=103)
	 public void checkErrorMessageWhendescriptionnotgiveninYT()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for embeded video upload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("49");
	 }
	 
	 @Test(priority=104)
	 public void checkErrorMessageWhendurationnotgivenYT()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals(contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals(contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("50");
	 }
	 
	 
	 @Test(priority=105)
	 public void checkErrorMessageWhenEmbededidnotgiven()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addDuration.sendKeys("10");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals(contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("51");
	 }
	 
	 @Test(priority=106)
	 public void checkErrorMessageWhenCategorynotselectedgiven()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.addDuration.sendKeys("10");
		 contentobj.embededtextforsm.sendKeys("oFlIjXAh4_c");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("52");
	 }
	 
	 @Test(priority=107)
	 public void checkErrorMessageWhenEmbededidgiven()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.embededtextforsm.sendKeys("oFlIjXAh4_c");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("53");
	 }
	 
	 @Test(priority=108)
	 public void checkErrorMessageVimeo()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals( contentobj.videotitleerrormsg.getText(), "Video title cannot be empty", "The message is not displayed for video title");
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("54");
	 }
	 
	 @Test(priority=109)
	 public void checkErrorMessageWhendescriptionnotgivenYT()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"VY");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals( contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for embeded video upload");
		 sa.assertEquals( contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("55");
	 }
	 
	 
	 @Test(priority=110)
	 public void checkErrorMessageVimeotitleDuration()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals(contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals(contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("56");
	 }
	 
	 
	 @Test(priority=111)
	 public void checkErrorMessageVimeoEmbededID()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
		 contentobj.ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(10));
		 contentobj.addDuration.sendKeys("10");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();	
		 sa.assertEquals(contentobj.embedediderrormessge.getText(), "Embed ID cannot be empty", "The message is not displayed for videofileupload");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("57");
	 }
	 
	 @Test(priority=112)
	 public void checkErrorMessageWhenEmbededidgivenVimeo()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.embededtextforsm.sendKeys("oFlIjXAh4_c");
		 contentobj.savebutton.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(contentobj.videodurationerrormsg.getText(), "Video duration cannot be empty", "The message is not displayed for videoduration");
		 sa.assertEquals( contentobj.videodescriptionerrormsg.getText(), "Video description cannot be empty", "The message is not displayed for video description");
		 sa.assertEquals(contentobj.videocategoryerrormsg.getText(), "Please select category", "The message is not displayed for videofilecategory");
		 sa.assertAll();
		 System.out.println("58");
	 }
	 
	 @Test(priority=113)
	 public void editYT()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addYoutubeVideo();
		 contentobj.addYoutubeObject();
		 contentobj.editObjectYT();
		 System.out.println("59");
	 }
	 
	 
	 @Test(priority=114)
	 public void editVimeo()
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.addVimeoVideo();
		 contentobj.addVimeoObject();
		 contentobj.editObjectVimeo();
		 System.out.println("60");
	 }
	 
	 @Test(priority=115)
	 public void editAudio() throws AWTException, InterruptedException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.clickaudioandpublish();
		 contentobj.editAudio(); 
	 }
	 
	 @Test(priority=116)
	 public void editNaraative() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.clicknarativepublish();
		 contentobj.editNarative();
	 }
	 
	 @Test(priority=117)
	 public void editHtml() throws InterruptedException, AWTException
	 {
		 contentobj.clickContent();
		 contentobj.clickManageObjects(); 
		 contentobj.clickAddObject();
		 contentobj.checkuploadhtml();
		 contentobj.editInteractive();
	 }
	 
	 
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	

}
