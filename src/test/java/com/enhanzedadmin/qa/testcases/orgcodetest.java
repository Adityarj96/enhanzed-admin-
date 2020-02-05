package com.enhanzedadmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class orgcodetest extends Testbaseadmin 
{
	 AdminorgcodeUI org;
	 Adminlogin log;
	
	 
	 
	//compulsory to call the testbase class constructor so using super keyword and it will avoid null pointer exception(initialize the property files)
		public orgcodetest() {
			super();
		}
		
		@BeforeMethod
		public void setup() {
			//initialization();
			
			org=new AdminorgcodeUI();
			log=new Adminlogin();
	}
		
		
		 //Verifying blank organization code
		@Severity(SeverityLevel.CRITICAL)
		@Description("check whether the error message is displayed when balnk org code is displayed or not")
		 @Test(priority=9)
		 public void checkforblankorgcode()
		 {
			 org.typeorganisation(prop.getProperty("orgcode2"));
			 Assert.assertEquals(org.error.getText(), "Please enter Organization Code");
		 }
		 
		 //Verifying invalid organisation code
		@Severity(SeverityLevel.CRITICAL)
		@Description("check whether the error message is displayed when invalid org code is given")
		 @Test(priority=10)
		 public void checkinvalidorgcode()
		 {
			 org.typeorganisation(prop.getProperty("orgcode1"));
			 implicitWait(20);
			 Assert.assertEquals(org.error.getText(), "Invalid Organization Code");
		 }
		 
		 //Verifying UI
		@Severity(SeverityLevel.MINOR)
		@Description("To check all the UI attrubes of the org code page")
		 @Test(priority=11)
		 public void checkUI()
		 {
			 SoftAssert sa = new SoftAssert();
			 sa.assertTrue(org.checkadmindashboardimg(), "the admin dashboard image is not present");
			 sa.assertTrue(org.checktext(), "the text is not present");
			 sa.assertTrue(org.checkfortextboxpresent(),"the text box is not present");
			 sa.assertTrue(org.checksubmitbutton(), "the submit button is not displayed");
			 sa.assertAll();
		 }
		@Severity(SeverityLevel.CRITICAL)
		@Description("To check whether the valid org code is given or not")
		 @Test(priority=12)
		 public void checkValidOrgcode()
		 {
			    org.typeorganisation(prop.getProperty("orgcode3")); 
			    SoftAssert sa=new SoftAssert();
				sa.assertTrue(log.emailIdTextBox(), "The email id text box is not present");
				sa.assertTrue(log.passwordTextBox(), "The password text box is not present");
				sa.assertTrue(log.loginButton(), "The login button is not present");
				sa.assertTrue(log.adminDashboardText(), "The admin dashbaord text is not displayed");
				sa.assertTrue(log.logo(), "The logo is not displayed");
				sa.assertTrue(log.changeOrgCode(), "The change org code is not displayed");
				sa.assertTrue(log.forgotPasswordLink(), "The forgot password link is not displayed");
				sa.assertAll();
		 }
          
		  
	     @AfterMethod
		   public void end() throws InterruptedException
		   {
			 tearDown();
		   }
}
