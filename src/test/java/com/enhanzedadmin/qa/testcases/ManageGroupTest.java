package com.enhanzedadmin.qa.testcases;

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
import com.enhanzedadmin.qa.pages.ManageGroup;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class ManageGroupTest extends Testbaseadmin{
	
	AdminorgcodeUI org;
	Adminlogin log;
	TestUtil testutil;
	String sheetName = "ManageGroupSheet";
	
	String sheetName1="AddUserToGroupNew";

	ManageGroup group;

	public ManageGroupTest() {
	super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
	org=new AdminorgcodeUI();
	org.typeorganisation(prop.getProperty("orgcode"));
	log=new Adminlogin();
	log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
    group=new ManageGroup();
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
	 
  
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check UI for group") 
	 @Test(priority=29)
	 public void checkUI()
	 {
		 group.usersnadgroups.click();
		 group.manageGroup.click(); 
		 SoftAssert sa = new SoftAssert();
		 sa.assertTrue(group.checkbreadcrumb(), "the users and groups breadcrumb is not present");
		 sa.assertTrue(group.checkbreadcrumbmanagegroup(), "The manage breadcrumb is not present");
		 sa.assertTrue(group.checkCreateGroupButton(),"The creategroup button is not present");
		 sa.assertAll(); 
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check UI for creategroup") 
	 @Test(priority=30)
	 public void checkcreategroupUI()
	 {
		 group.usersnadgroups.click();
		 group.manageGroup.click();
		 group.creategroupbutton.click();
		 SoftAssert sa = new SoftAssert();
		 sa.assertTrue(group.checkcreategrouptextbox(), "the textbox is not displayed");
		 sa.assertTrue(group.checkgroupaddbutton(), "the add button is not displayed");
		 sa.assertTrue(group.checkcancelgrouppopup(), "the add button is not displayed");
		 sa.assertAll(); 
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message when create group text field is empty") 
	 @Test(priority=31)
	 public void checkEmptyGroupNameCreation()
	 {
		 group.usersnadgroups.click();
		 group.manageGroup.click();
		 group.creategroupbutton.click();
		 sleep(2000);
		 group.clickadd.click();
		 Assert.assertEquals(group.creategrouperrormessage.getText(), "Group name cannot be empty");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To create a group")
     @Test(priority=32,dataProvider="getTestData")
	 public void createGroup(String namegroup)
	 {
	 group.createNewGroup(namegroup);
	 }
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check error message when create group text field is empty") 
	 @Test(priority=33,dataProvider="getTestData")
	 public void checkGroupUItest(String namegroup)
	 {
		 group.usersnadgroups.click();
		 group.manageGroup.click();
		 group.checkGroupUI(namegroup);
		 SoftAssert sa = new SoftAssert(); 
	     sa.assertTrue(group. addBtnEmptyUser.isDisplayed(), "the add button isnot displayed");
		 sa.assertTrue(group.deleteGroupBtn.isDisplayed(), "the delete button is not displayed");
		 sa.assertAll();
	 }
	 
	 @Severity(SeverityLevel.MINOR)
	 @Description("To check error message when the admin clicks on add button without adding user email id") 
	 @Test(priority=34,dataProvider="getTestData")
	 public void addEmptyUserToGroup(String namegroup)
	 {
		 group.clickUsersAndGroups();
		 group.clickManageGroups();
		 group.searchgroup.sendKeys(namegroup);
		 group.groupnametext.click();
		 sleep(3000);
		 group.addEmptyuserUser.click();
		 sleep(3000);
		 group.addBtn.click();
		 Assert.assertEquals(group.emptygrouperror.getText(), "Please enter the user email id");
	 }
	 
	
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whetehr the admin can add user to the group")
	 @Test(priority=35,dataProvider="getTestData1")
	 public void addUserToGroup(String groupName,String emailId) throws InterruptedException
	 {
		 group.clickUsersAndGroups();
		 group.clickManageGroups(); 
		 group.addUserToGroup(groupName,emailId);
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the admin can remove the user from the group")
	 @Test(priority=36,dataProvider="getTestData1")
	 public void removeUserFromGroup(String groupName,String emailId)
	 {
		 group.clickUsersAndGroups();
		 group.clickManageGroups(); 
		 group.removeUserGroup(groupName, emailId);
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the admin can delete the group")
	 @Test(priority=37,dataProvider="getTestData")
	 public void deleteGroup(String groupName) throws InterruptedException
	 {
		group.clickUsersAndGroups();
		group.clickManageGroups();
		group.deleteGroup(groupName); 
		group.searchgroup.sendKeys(groupName);
		Assert.assertTrue(group.nodata.isDisplayed());
	}
	 
	 //test case to check whether if there are no users then the admin can add in the group
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check whether the error message is displayed when the user does not add email id of the user ")
     @Test(priority=38)
	 public void addEmptyUserToGroup()
	 {
		 group.clickUsersAndGroups();
		 group.clickManageGroups(); 
		 group.groupapac.click();
		 group.addUser.click();
		 group.addBtn.click();
		 Assert.assertEquals(group.emptygrouperror.getText(), "Please enter the user email id");
	 }
	 

	 @AfterMethod
	  public void end() throws InterruptedException
	  {
	     tearDown();
	  }


}
