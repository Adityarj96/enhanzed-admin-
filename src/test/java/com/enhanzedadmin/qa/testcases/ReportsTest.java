package com.enhanzedadmin.qa.testcases;

import com.enhanzedadmin.qa.base.Testbaseadmin;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.UserReports;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
public class ReportsTest extends Testbaseadmin {
	
	  AdminorgcodeUI org;
	  Adminlogin log;
	  UserReports report;
	  TestUtil testutil;
	  SoftAssert sa;

	  String sheetName = "UserReport";
	  String sheetName1 = "ContentReport";
	  String sheetName2 ="CheckUI";

	  public ReportsTest() {
	  super();
	  }


	  @BeforeMethod
	  public void setup() throws InterruptedException, IOException {

	 
	  org=new AdminorgcodeUI();
	  org.typeorganisation(prop.getProperty("orgcode"));
	  log=new Adminlogin();
	  log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
	  report=new  UserReports();
	  sa=new SoftAssert();

	  }
	  @DataProvider
	  public Object[][] getTestData()
	  {
	  Object data[][]= testutil.getTestData(sheetName);
	  return data;
	  }

	  @DataProvider
	  public Object[][] getTestData1()
	  {
	  Object data[][]= testutil.getTestData(sheetName1);
	  return data;
	  }
	  
	  @DataProvider
	  public Object[][] getTestData2()
	  {
	  Object data[][]= testutil.getTestData(sheetName2);
	  return data;
	  }
      
	  @Severity(SeverityLevel.TRIVIAL)
	  @Description("This test case needs to check UI attributes of userreports")
	  @Test(priority=67)
	  public void checkUIofUserreports() throws InterruptedException
	  {
	  report.clickReports();
	  report.clickUserReports();
	  sa.assertTrue(report.checkTotalUsers(),"The total users are not displayed");
	  sa.assertTrue(report.checkTotalActiveUsers(),"The total active users are not displayed");
	  sa.assertTrue(report.checkUsersbyPlatform(),"The users by platform attribute is not displayed");
	  sa.assertAll();
	  }

	  @Severity(SeverityLevel.TRIVIAL)
	  @Description("This test case needs to check mousehover on the graph")
	  @Test(priority=68)
	  public void checkMouseHovertest() throws InterruptedException
	  {
	  report.clickReports();
	  report.clickUserReports();
	  report.checkMouseHover();
	  report.clickContentReports();
	  }

	  @Severity(SeverityLevel.CRITICAL)
	  @Description("This test case needs to check userreports")
	  @Test(priority=69,dataProvider="getTestData")
	  public void checkUserReports(String emailId,String topicName)
	  {
	  report.clickReports();
	  report.clickUserReports();
	  report.searchUsers(emailId,topicName);
	  }
	  
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("This test case needs to check UI of userreports")
	  @Test(priority=70,dataProvider="getTestData2")
	  public void checkUIofUserReport(String emailId)
	  {
		  report.clickReports();
		  report.clickUserReports();
		  report. checkUI(emailId); 
	  }
	  
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("This test case needs to check the pagination feature")
	  @Test(priority=71)
	  public void checkPagination()
	  {
		  report.clickReports();
		  report.clickUserReports();
		  report.checkPagination();
	  }
	  
	  
	  
	  
	  @AfterMethod
	    public void end() throws InterruptedException
	    {
	  tearDown();
	    }


}
