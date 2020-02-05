package com.enhanzedadmin.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
import com.enhanzedadmin.qa.pages.CreateUser;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
public class ManageUserTest extends Testbaseadmin  
{
	 AdminorgcodeUI org;
	 Adminlogin log;
	 CreateUser create;
	 TestUtil testutil;
	 
	 String sheetName = "CreateUserSheet";
	 String sheetName1="SearchUsers";
	 String sheetName2="SearchUsersName";
	 String sheetName3="SearchUsersStatus";
	 
	 public ManageUserTest() {
			super();
		}
	
	    @BeforeMethod
		public void setup() throws InterruptedException {
		 
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
			create=new CreateUser();		
	}
	 
	 //To read the test data from the excel sheet 
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
	 
	 @DataProvider
	 public Object[][] getTestData3()
	 {
		Object data[][]= testutil.getTestData(sheetName3);
		return data; 
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check all the UI attributes of manage users page") 
	 @Test(priority=15)
	 public void checkUsersUI()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(create.checkNameColums(), "The name column header is not displayed");
		 sa.assertTrue(create.checkemailcolumn(), "The email column header is not displayed");
		 sa.assertTrue(create.checkLastActive(), "The lastactive column header is not displayed");
		 sa.assertTrue(create.checkUserstatus(), "The userstatus column header is not displayed");
		 sa.assertTrue(create.checkCreateUserbutton(), "The createuserbutton column header is not displayed");
		 sa.assertTrue(create.checkBreadcrumb(), "The breadcrumb is not displayed");
		 sa.assertAll();
		 
	 }
	 
	 //check all the UI attributes of the create user page 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check all the UI attributes of create users page") 
	 @Test(priority=16)
	 public void checkCreateUserUI()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 
		 Assert.assertTrue(create.checkNameField(),"The namefield is not displayed");
		 Assert.assertTrue(create.checkEmailField(),"The emailfield is not displayed");
		 Assert.assertTrue(create.checkContactNumber(),"The contactfield is not displayed");
		 Assert.assertTrue(create.checkGender(),"The gender field is not displayed");
		 Assert.assertTrue(create.checkAddress(),"The address field is not displayed");
		 Assert.assertTrue(create.checkRole(),"The role field is not displayed");
		 Assert.assertTrue(create.checkGroup(),"The group field is not displayed");
		 Assert.assertTrue(create.checkSaveButton(),"The savebutton field is not displayed");
		 Assert.assertTrue(create.checkCancelButton(),"The cancelbutton field is not displayed");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message  when name is blank") 
	 @Test(priority=17)
	 public void checkUserDetailsNameBlank()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser(); 
		 sleep(2000);
		 create.save.click();
		 String errormessage=create.errorMessage.getText();
		 Assert.assertEquals(errormessage, "Name cannot be empty"); 
	 }
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message  when email is blank") 
	 @Test(priority=18)
	 public void checkUserDetailsEmailblank()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.typeName.sendKeys("johndoe");
		 sleep(2000);
		 create.save.click();
		 String errormessage=create.errorMessage.getText();
		 Assert.assertEquals(errormessage, "Email cannot be empty"); 
	 }
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message  when gender is blank") 
	 @Test(priority=19)
	 public void checkUserDetailsGenderBlank()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.typeName.sendKeys("johndoe");
		 create.email.sendKeys("john@doe.com");
		 sleep(2000);
		 create.save.click();
		 String errormessage=create.errorMessage.getText();
		 Assert.assertEquals(errormessage, "Please select gender");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message  when role is blank") 
	 @Test(priority=20)
	 public void checkUserRoleBlank()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.typeName.sendKeys("johndoe");
		 create.email.sendKeys("john@doe.com");
		 create.genderSelect.click();
		 sleep(2000);
		 create.save.click();
		 String errormessage=create.errorMessage.getText();
		 Assert.assertEquals(errormessage, "User Role cannot be empty");
	 }
	 
	 //Test case to check the wrong email format 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check error message  when email format is wrong") 
	 @Test(priority=21)
	 public void wrongEmailFormatCheck()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.typeName.sendKeys("johndoe");
		 create.email.sendKeys("abcde.email.com");
		 create.genderSelect.click();
		 sleep(2000);
		 create.save.click();
		 String errormessage=create.errorMessage.getText();
		 Assert.assertEquals(errormessage, "Enter valid email Id");
	 } 
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check for create user") 	
	 @Test(priority=22,dataProvider="getTestData")
	 public void createduplicateuser(String uname,String email,String contact,String address) throws InterruptedException
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.createduplicateUser(uname, email, contact,address);
	 }
	          
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check for create user") 	
	 @Test(priority=23,invocationCount=2)
	 public void createuser() throws InterruptedException
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.createNewUser();
	 }
	
	 //check cancel feature in create 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check for cancel create user") 
	 @Test(priority=24)
	 public void cancelNewCreateUser()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.clickCreateUser();
		 create.cancelNewCreateUser(); 
	 }

	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check for cancel create user")
	 @Test(priority=25)
	 public void checkPagination()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.checkpagination();
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check for searchterm email")
	 @Test(priority=26,dataProvider="getTestData1")
	 public void searchUsers(String searchterm)
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.searchUseronterm(searchterm);
	 }
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check for searchterm name")
	 @Test(priority=27,dataProvider="getTestData2")
	 public void searchUsersname(String searchterm)
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.searchUserontermname(searchterm);
		 
	 }
	
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check breadcrumb sequence")
	 @Test(priority=28)
	 public void checkbreadcrumb()
	 {
		 create.clickUsersAndGroups();
		 create.clickManageUsers();
		 create.checkBreadcrumb();
	 }
	 
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
}
