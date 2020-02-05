package com.enhanzedadmin.qa.testcases;

import com.enhanzedadmin.qa.base.Testbaseadmin;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.CreateUser;
import com.enhanzedadmin.qa.pages.EnableAndDisableUser;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class EnableAndDisableUserTest extends Testbaseadmin {
	
	AdminorgcodeUI org;
	Adminlogin log;
	CreateUser create;
	TestUtil testutil;
	EnableAndDisableUser user;

	String sheetName = "EnableDisable";

	public EnableAndDisableUserTest() 
	{
	super();
	}

	 @BeforeMethod
	public void setup() throws InterruptedException, IOException {

	org=new AdminorgcodeUI();
	org.typeorganisation(prop.getProperty("orgcode"));
	log=new Adminlogin();
	log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
	create=new CreateUser();
	user=new EnableAndDisableUser();

	}
	  
	@DataProvider
	public Object[][] getTestData()
	{
	Object data[][]= testutil.getTestData(sheetName);
	return data;
	}
	   
	@Severity(SeverityLevel.CRITICAL)
	@Description("check whether the user can be enabled or not")
	@Test(priority=64,dataProvider="getTestData")
	public void userEnableDisable(String  userName) throws InterruptedException
	{
	create.clickUsersAndGroups();
	create.clickManageUsers();
	user.typeUserSearchTextBox(userName);
	user.checkUserStatus();
	 }
	 
	@Severity(SeverityLevel.CRITICAL)
	@Description("check whether the userdetails can be edited or not")
	 @Test(priority=65,dataProvider="getTestData")
	 public void editUser(String  userName) throws InterruptedException
	   {
	      create.clickUsersAndGroups();
	      create.clickManageUsers();
	      user.typeUserSearchTextBox(userName);
	      user.editUser();        
	   }
	 
	@Severity(SeverityLevel.CRITICAL)
	@Description("check whether the userdetails editing can be canceled or not")
	 @Test(priority=66,dataProvider="getTestData")
	 public void cancelEditUser(String  userName) throws InterruptedException
	   {
	      create.clickUsersAndGroups();
	      create.clickManageUsers();
	      user.typeUserSearchTextBox(userName);
	      user.cancelChanges();        
	   }
	   
	  
	 @AfterMethod
	  public void end() throws InterruptedException
	  {
		 tearDown();
	  }
	     

}
