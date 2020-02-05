package com.enhanzedadmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;

import com.enhanzedadmin.qa.pages.Dashboard;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Dashboardtest extends Testbaseadmin
{

	 Adminlogin log;
	 Dashboard dash;
	 AdminorgcodeUI org;
	 
	 
	 public Dashboardtest() {
			super();
		}
	 
	  @BeforeMethod
			public void setup() throws InterruptedException {
				org=new AdminorgcodeUI();
				org.typeorganisation(prop.getProperty("orgcode"));
				log=new Adminlogin();
				dash=new  Dashboard();
				log.login(prop.getProperty("uname"), prop.getProperty("pwd"));	
		}
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("To check all the UI attributes of the dashbaord page")
	  @Test(priority=13)
	  public void checkUIAttribute()
	  {
		    SoftAssert sa=new SoftAssert();
			sa.assertTrue(dash.checkTotalUsers(), "The total users are not displayed");
			sa.assertTrue(dash.checkTotalTopics(), "The total topics are not displayed");
			sa.assertTrue(dash.checkActiveUsers(), "The Actiave users are not displayed");
			sa.assertTrue(dash.checkTopicsStarted(), "The topics staretd are not displayed");
			sa.assertTrue(dash.checkGraph(), "The graph is not displayed");
			sa.assertAll();  
	  }
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("To check the working of the graph")
	  @Test(priority=14)
	  public void checkgraph()
	  {
		  sleep(3000);
		  dash.month.click();
		  sleep(3000);
		  dash.year.click();
	  }
	  
	  
	  @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }

}
