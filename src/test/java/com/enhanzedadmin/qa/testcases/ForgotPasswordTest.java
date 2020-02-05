package com.enhanzedadmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.ForgotPassword;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;

public class ForgotPasswordTest extends Testbaseadmin {
	
	ForgotPassword page;
	AdminorgcodeUI org;
	 Adminlogin log;
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			
			}
	
	//TC-4001 Forgot Password UI pass
	@Test(priority=1)
	public void validateForgotPasswordLink() throws InterruptedException {
		
		page = new ForgotPassword();
		page.forgotPassword();
		
	}

	//TC-4002 Forgot password (Invalid Email-id) pass
			@Test(priority=2)
			public void validateInvalidEmailErrorMessage() throws InterruptedException {
				
				page = new ForgotPassword();
				page.validateErrorMessage();
				
			}
			
			//TC-4005 Reset Password UI pass
			@Test(priority=3)
			public void validateResetPasswordPage() throws InterruptedException {
				System.out.println("Reset password UI");
				page = new ForgotPassword();
				page.validateRestePasswordPage();
				SoftAssert sa = new SoftAssert();
				
				//sa.assertTrue(page.resetPasswordPopupValidation(), "Reset passowrd page is not opened");
				//System.out.println("Reset passowrd page is opened");
				
				sa.assertTrue(page.verificationCodeTextboxrValidation(), "Verification code field is not present");
				
				
				sa.assertTrue(page.passwordTextboxValidation(), "Password textbox field is not present");
				
				
				sa.assertTrue(page.confirmPasswordTextboxValidation(), "Confirm Password textbox field is not present");
				sa.assertAll();	
			}
			
			//TC-4007 Reset Password (Invalid OTP) - pass
			@Test(priority=4)
			public void validateResetPasswordWithInvalidOTP()
			{
				System.out.println("Reset password with invalid OTP started");
				page = new ForgotPassword();
				page.validateRestePasswordWithInvalidCode();
				System.out.println("Reset password with invalid code");
			}
	
			//TC-4009 Reset Password - validation (Invalid Password) pass
			@Test(priority=5)
			public void validateResetPasswordWithInValidPassword() {
				System.out.println("Reset password with invalid password started");
				String password="kjkzx";
				String expected= "Invalid Password format";
				page = new ForgotPassword();
				page.invalidPassword(expected, password);
				
			}
				
			//TC-4010 Reset Password - validation (Invalid Password format)
			@Test(priority=6)
			public void validateResetPasswordWithInValidPasswordFormat()
			{
				String password="12345678";
				String expected= "Invalid Password format";
				page = new ForgotPassword();
				page.invalidPassword(expected, password); 		
			}
			
			//TC-4011 Reset Password - validation (Password Copy-Paste) - pass
			@Test(priority=7)
			public void validateCopyPasteOfPassword() 
			{
				
				String password="qwerty@1";
				String expected= "Password should not contain space";
				page = new ForgotPassword();
				page.copyPasteThePassword(expected, password); 
				
			}
			
			//TC-4012 Password encryption pass
			@Test(priority=8)
			public void validatetEncryptedPassword() throws InterruptedException {
				log = new Adminlogin();
				log.testPasswordEncryption("preetham@enhanzed.com", "qwerty@1");
			}
			
			
			//TC-4014 Reset Password - validation pass
			@Test(priority=9)
			public void validateResetPasswordForPasswordMismatch()
			{
				System.out.println("Reset password - passwords mismatch");
				String password="qwerty@1";
				String confirmPassword="qwertyio";
				String expected= "Password and confirm password does not match!";
				page = new ForgotPassword();
				page.enterDifferentPassword(expected, password, confirmPassword);
				System.out.println("password mismatch");
			}
			
			
			
			
			 @AfterMethod
			   public void end() throws InterruptedException
			   {
				 tearDown();
			   }

}
