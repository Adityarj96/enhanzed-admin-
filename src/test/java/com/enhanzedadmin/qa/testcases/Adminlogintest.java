package com.enhanzedadmin.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


public class Adminlogintest extends Testbaseadmin 
{
	 Adminlogin log;
	 AdminorgcodeUI org;
	 public Adminlogintest()
	 {
		 super();
	 }
	 
	@BeforeMethod
	public void setup()
	{
		 log=new Adminlogin();
		 org=new AdminorgcodeUI();
	}
	 
	//Test case to check whether an error message is shown when the user tries to login with blank email id and passowrd 
	
	@Description("To test whether an error message when an invalid email id is displayed")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=1)
	 public void checkBlankEmailPwd() throws InterruptedException
	 {
		 org.typeorganisation(prop.getProperty("orgcode"));
		 log.login(prop.getProperty("uname3"), prop.getProperty("pwd3"));
		 WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/p"));
		 Assert.assertEquals(login.getText(), "Enter a valid email id");
		 System.out.println("1");
	 }
	
	
	
	//Test case to check for change in the organisation code 
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("To test whether the given org code goes to the same org login ")
	@Test(priority=2)
	public void checkChangeOrganisationcode()throws InterruptedException
	{
		 org.typeorganisation(prop.getProperty("orgcode"));
		 log.clickchangeorganisation();
		 org.typeorganisation(prop.getProperty("orgcode3"));
		 WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/p"));
		 Assert.assertEquals(login.getText(), "Admin Dashboard");  
		 System.out.println("2");
	}
	
	
	
	//Test case to check whether valid email id and invalid password is given 
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("To test error message occurs when valid email id and invalid password is given")
	@Test(priority=3)
	public void checkValidEmailIdInvalidPwd()throws InterruptedException
	{
		org.typeorganisation(prop.getProperty("orgcode"));
		log.login(prop.getProperty("uname"), prop.getProperty("pwd2"));
		WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/p"));
		Assert.assertEquals(login.getText(), "Invalid username or password!");
		System.out.println("3");
	}
	
	//Test case to check whether the valid email id and invalid password is given (length is less)
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("To test error message occurs when valid email id and invalid password(length is less) is given")
	@Test(priority=4)
	public void checkValidEmailIdInvalidPwdLengthless()throws InterruptedException
	{
		org.typeorganisation(prop.getProperty("orgcode"));
		log.login(prop.getProperty("uname"), prop.getProperty("pwdd"));
		WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[5]/p"));
		Assert.assertEquals(login.getText(), "Password must be at least 8 characters");
		System.out.println("4");
	}
	
	//Test case to check whether the invalid email id and valid password is given
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("To test error message occurs when invalid email id and invalid password is given")
	@Test(priority=5)
	public void checkInvalidEmailInvalidPwd()throws InterruptedException
	{
		org.typeorganisation(prop.getProperty("orgcode"));
		log.login(prop.getProperty("uname1"), prop.getProperty("pwd1"));
		WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/p"));
		Assert.assertEquals(login.getText(), "Enter a valid email id");
		System.out.println("5");
	}
	
	//Test case to check whether the unregistered user can login or not 
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("To test whether un registered admin can acess admin dashbaord")
	@Test(priority=6)
	public void checkUnregisteredAdmin()throws InterruptedException
	{
		org.typeorganisation(prop.getProperty("orgcode"));
		log.login(prop.getProperty("uname4"), prop.getProperty("pwd4"));
		WebElement login= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/p"));
		Assert.assertEquals(login.getText(), "User does not exist!");
		System.out.println("6");
	}
	
	//Test case to check all the UI attributes of Admin

	@Severity(SeverityLevel.NORMAL)
	@Description("This test case needs to check all the UI attributes are present or not")
	@Test(priority=7)
	public void checkUIAttributes()
	{
		org.typeorganisation(prop.getProperty("orgcode"));
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(log.emailIdTextBox(), "The email id text box is not present");
		sa.assertTrue(log.passwordTextBox(), "The password text box is not present");
		sa.assertTrue(log.loginButton(), "The login button is not present");
		sa.assertTrue(log.adminDashboardText(), "The admin dashbaord text is not displayed");
		sa.assertTrue(log.logo(), "The logo is not displayed");
		sa.assertTrue(log.changeOrgCode(), "The change org code is not displayed");
		sa.assertTrue(log.forgotPasswordLink(), "The forgot password link is not displayed");
		sa.assertAll();
		System.out.println("7");
	}
	
	//Test case to check the valid user can login sucessfully or not

	@Severity(SeverityLevel.CRITICAL)
	@Description("This test case needs to check whetehr the admin can login sucessfully to the portal")
	@Test(priority=8)
	public void checkValidEmailLogin() throws InterruptedException
	{
		org.typeorganisation(prop.getProperty("orgcode"));	
		log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		Assert.assertTrue(log.username.isDisplayed(),"The username is not displayed");
		System.out.println("8");
	}
	
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }	
	 
	 
}
