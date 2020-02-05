package com.enhanzedadmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.MyProfile;

public class MyProfileTest extends Testbaseadmin {
	
	MyProfile mp;
	 AdminorgcodeUI org;
	 Adminlogin log;
	
	public MyProfileTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		org=new AdminorgcodeUI();
		org.typeorganisation(prop.getProperty("orgcode"));
		
		log=new Adminlogin();
		log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		mp=new MyProfile();
	}
	
	@Test(priority=1)
	public void signOut() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(mp.profileUserName(), "the user name is not displayed");	
		sa.assertTrue(mp.profileImage(), "the profile image is not displayed");	
         sa.assertAll();		
		
		
		sleep(6000);
	  mp.clickSignOut();
	
	}
	
	@AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }

}
