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
import com.enhanzedadmin.qa.pages.Settings;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class SettingsTest extends Testbaseadmin {
	
	 AdminorgcodeUI org;
	 Adminlogin log;
	 Settings set;
	 TestUtil testutil;
	 
	 String sheetName = "Category";
	 String sheetName1 = "Category1";
	 
	 public SettingsTest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			set = new Settings();
					
	}
	  @Severity(SeverityLevel.MINOR)
	  @Description("To check all the UI attributes of the settings page ")
	  @Test(priority=64)
	   public void CheckUISettings()
	   {
		     set.clickSettings();
		     set.clickWelcomeemailtemplate();
		     SoftAssert sa=new SoftAssert();
			 sa.assertTrue(set.checkSubjectDisplayed(), "The subject is not displayed ");
			 sa.assertTrue(set.checkBodyDisplayed(), "The body is not displayed");
			 sa.assertTrue(set.editbuttonDisplayed(), "The edit button is not displayed");
		     sa.assertAll();
	   }
	   
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("To check edit feature of the settings page")
	   @Test(priority=65)
	   public void checkEditFeature()
	   {
		   set.clickSettings();
		   set.clickWelcomeemailtemplate();  
		   set.edittemplate.click();
		   Assert.assertTrue(set.savetemplate.isDisplayed(), "The save button is not displayed");  
	   }
	   
	  @Severity(SeverityLevel.MINOR)
	  @Description("To check the edit subject feature ")
	   @Test(priority=66)
	   public void checkEditSubject()
	   {
		  set.checkEditSubject();
	   }
	   
	  @Severity(SeverityLevel.MINOR)
	  @Description("To check the edit body feature ")
	   @Test(priority=67)
	   public void changeBody()
	   {
		   set.changeBody();
	   }
	   
	  @Severity(SeverityLevel.MINOR)
	  @Description("To check the breadcrumb")
	  @Test(priority=68)
	   public void checkBreadcrumb()
	   {
		   set.clickSettings();
		   set.clickWelcomeemailtemplate();
		   set.clickbreadcrumb.click();
		   Assert.assertTrue(set.welcomeemailtemplate.isDisplayed(), "The breadcrumb is not displayed"); 
	   }
	   
	  @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }

}
