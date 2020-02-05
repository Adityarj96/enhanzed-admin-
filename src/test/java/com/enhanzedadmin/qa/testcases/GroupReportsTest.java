package com.enhanzedadmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.enhamzed.qa.util.TestUtil;
import com.enhanzedadmin.qa.base.Testbaseadmin;
import com.enhanzedadmin.qa.pages.Adminlogin;
import com.enhanzedadmin.qa.pages.AdminorgcodeUI;
import com.enhanzedadmin.qa.pages.EngageUser;
import com.enhanzedadmin.qa.pages.GroupReports;


public class GroupReportsTest extends Testbaseadmin
{
	 AdminorgcodeUI org;
	 Adminlogin log;
	 GroupReports grpRep;
	 TestUtil testutil;
	
	 
	 String sheetName = "GroupReports";
	 String sheetName1 = "GroupReportstopics";
	 
	 public GroupReportsTest() {
			super();
		}
	 
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			grpRep=new GroupReports();
			
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
	 
	 
	@Test(priority=1,dataProvider="getTestData")
	public void checkUI(String groupname)
	{	
		grpRep.reports.click();
		grpRep.clickGroupreports();
		grpRep.checkGroupInfo(groupname);
	}
	
	@Test(priority=2,dataProvider="getTestData1")
	public void checkGroupReports(String groupname,String topicName) throws InterruptedException
	{
		grpRep.reports.click();
		grpRep.clickGroupreports();
		grpRep.checkTopics(groupname,topicName);
	}
	
	
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
}
