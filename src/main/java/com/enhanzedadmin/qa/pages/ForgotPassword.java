package com.enhanzedadmin.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class ForgotPassword extends Testbaseadmin {
	
	 //Forgot password 
	  @FindBy(xpath="//button[@class='loginforgotpwd']")
	  WebElement forgotPasswordButton;
	
	  //Forgot password popup
	  @FindBy(xpath="//div[@class='modal-content']")
	  private List<WebElement> forgotPasswordPopup;
	  
	  //Email text box
	  @FindBy(xpath="//input[@placeholder='Email']")
	  private List<WebElement> emailTextBox;
	  
	  //Email text box
	  @FindBy(xpath="//input[@class='loginmail1 ng-pristine ng-untouched ng-valid ng-empty ng-valid-email']")
	  private WebElement emailId;
	  
	  //Error message 
	  @FindBy(xpath="//p[@class='ng-scope']")
	  private List<WebElement> errorMessage;
	  
	  //Error message in reset page 
	  @FindBy(xpath="//div[@id='swal2-validationerror']")
	  private List<WebElement> errorMessageResetPage;
	  
	
	  //Error message in reset page 
	  @FindBy(xpath="//div[@id=\"swal2-content\"]/span[1]")
	  private List<WebElement> errorMessageResetPagecode;
	  
	  //Next button
	  @FindBy(xpath="//button[@ng-click='next()']")
	  private WebElement nextButton;
	  
	  //Password reset popup
	  @FindBy(xpath="//div[@class='swal2-popup swal2-modal sweetalertPass swal2-show']")
	  private WebElement passwordResetPopup;
	  
	  //Verification code
	  @FindBy(xpath="//input[@id='code']")
	  private WebElement verificationCodeTextbox;
	  
	  //Password textbox
	  @FindBy(xpath="//input[@id='pwd']")
	  private WebElement passwordTextbox;
	  
	  //Confirm password text box
	  @FindBy(xpath="//input[@id='cpwd']")
	  private WebElement confirmPasswordTextBox;
	  
	  //Submit button
	  @FindBy(xpath="//button[@class='swal2-confirm button1']")
	  private WebElement submitButton;
	  
	  //Cancel button
	  @FindBy(xpath="//button[@class='swal2-cancel button2']")
	  private WebElement cancelButton;
	  
	  public ForgotPassword()  
	  {
		  super();
		PageFactory.initElements(driver,this);
	  }

	  
	  //Test forgot password 
	  public void forgotPassword()
	  {
		  sleep(3000);
		  forgotPasswordButton.click();
		  
		  if(emailTextBox.size()>0)
		  {
			  System.out.println("Email textbox is displayed");
		  }
		  else
		  {
			  Assert.fail("Email textbox is not displayed");
		  }
	  }
	  
	  //Validate the error message
	  public void validateErrorMessage()
	  {
		  sleep(5000);
		  forgotPasswordButton.click();
		  sleep(5000);
		  emailId.sendKeys("su@enhanzed.co");
		  nextButton.click();
		  sleep(3000);
		  if(errorMessage.size()>0)
		  {
			  System.out.println(errorMessage.get(0).getText());
		  }
		  else
		  {
			  Assert.fail();
		  }
	  }


	 //vaidate reset password page
	public void validateRestePasswordPage()
	{
		sleep(5000);
		forgotPasswordButton.click();
		sleep(5000);
		emailId.sendKeys("preetham@enhanzed.com");
		nextButton.click();		
	}
	
	// verify presence of reset password popup
		public boolean resetPasswordPopupValidation() {

			return passwordResetPopup.isDisplayed();

		}

		// verify presence of verification code textbox
		public boolean verificationCodeTextboxrValidation() {

			return verificationCodeTextbox.isDisplayed();

		}		

		// verify presence of password textbox
		public boolean passwordTextboxValidation() {

			return passwordTextbox.isDisplayed();
		}
		
		// verify presence of confirm password textbox
		public boolean confirmPasswordTextboxValidation() {

			return confirmPasswordTextBox.isDisplayed();

		}
		
		//vaidate reset password for invalid verification code
		public void validateRestePasswordWithInvalidCode()
		{
			sleep(5000);
			forgotPasswordButton.click();
			sleep(5000);
			emailId.sendKeys("preetham@enhanzed.com");
			nextButton.click();	
			sleep(5000);
			verificationCodeTextbox.sendKeys("123456");
			passwordTextbox.sendKeys("qwerty@1");
			confirmPasswordTextBox.sendKeys("qwerty@1");
			submitButton.click();
			sleep(6000);
			if(errorMessageResetPagecode.size()>0)
			  {
				  System.out.println(errorMessageResetPagecode.get(0).getText());
			  }
			  else
			  {
				  Assert.fail();
			  }
		}

		//validate reset password for invalid password 
		public void invalidPassword(String expected, String password) 
		{
			sleep(5000);
			forgotPasswordButton.click();
			sleep(5000);
			emailId.sendKeys("preetham@enhanzed.com");
			nextButton.click();	
			sleep(5000);
			verificationCodeTextbox.sendKeys("123456");
				passwordTextbox.sendKeys(password);
				confirmPasswordTextBox.sendKeys(password);
				submitButton.click();
				if(errorMessageResetPage.size()>0)
				  {
					 String actual=errorMessageResetPage.get(0).getText();
					 System.out.println("Actual messsage is= "+actual);
					 Assert.assertEquals(actual, expected);
				  }
				  else
				  {
					  Assert.fail("No error messages");
				  }
			}
	
		//validate the copy and paste of the password
		public void copyPasteThePassword(String expected, String password)
		{
			sleep(5000);
			
			forgotPasswordButton.click();
			sleep(5000);
			emailId.sendKeys("preetham@enhanzed.com");
			nextButton.click();	
			sleep(8000);
			verificationCodeTextbox.sendKeys("123");
			passwordTextbox.sendKeys("qwerty@1");
			passwordTextbox.sendKeys(Keys.CONTROL,"a","c");			
			confirmPasswordTextBox.sendKeys(Keys.CONTROL,"v");
			submitButton.click();
			if(errorMessageResetPage.size()>0)
			  {
				 String actual=errorMessageResetPage.get(0).getText();
				 System.out.println("Actual messsage is= "+actual);
				 Assert.assertEquals(actual, expected);
			  }
			  else
			  {
				  Assert.fail();
			  }
			
		}

		//Validate reset password with mismatch in password and confirm password
		public void enterDifferentPassword(String expected, String password, String confirmPassword)
		{
			sleep(5000);
			forgotPasswordButton.click();
			sleep(5000);
			emailId.sendKeys("preetham@enhanzed.com");
			nextButton.click();	
			sleep(5000);
			verificationCodeTextbox.sendKeys("123456");
			passwordTextbox.sendKeys(password);
			confirmPasswordTextBox.sendKeys(confirmPassword);
			submitButton.click();
			if(errorMessageResetPage.size()>0)
			  {
				 String actual=errorMessageResetPage.get(0).getText();
				 System.out.println("Actual messsage is= "+actual);
				 Assert.assertEquals(actual, expected);
			  }
			  else
			  {
				  Assert.fail();
			  }
			
		}	

}
