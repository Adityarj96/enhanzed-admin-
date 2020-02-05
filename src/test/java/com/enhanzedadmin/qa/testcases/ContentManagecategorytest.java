package com.enhanzedadmin.qa.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.enhanzedadmin.qa.pages.ContentManageCategories;
import com.enhanzedadmin.qa.pages.CreateTopic;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContentManagecategorytest extends Testbaseadmin
{
	 AdminorgcodeUI org;
	 Adminlogin log;
	 ContentManageCategories content;
	 TestUtil testutil;
	 
	 String sheetName="AddCategory";
	 
	 String sheetName1="Edit category";
	 
	 String sheetName2="Addsubcategory";
	 
	 String sheetName3="EditSubcategory";
	 
	 
	 public ContentManagecategorytest() {
			super();
		}
	 
	 @BeforeMethod
		public void setup() throws InterruptedException {
		 
			//initialization();
			org=new AdminorgcodeUI();
			org.typeorganisation(prop.getProperty("orgcode"));
			log=new Adminlogin();
			log.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		    content=new  ContentManageCategories();
					
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
	 
	 @DataProvider
	 public Object[][] getTestData3()
	 {
		Object data[][]= testutil.getTestData(sheetName3);
		return data; 
	 }
	
	 //check the UIof the category
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check all the UI attributes of the category")
	 @Test(priority=40)
	 public void checkCategoryUI()
	 {
		 content.content.click();
		 content.managecategories.click();
		 
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(content.checkbreadcrumb(), "The breadcrumb is not displayed");
		 sa.assertTrue(content.checkaddcategorybutton(), "The addcategory button is not displayed");
		 sa.assertTrue(content.checksearchcategory(), "The searchcategory is not displayed");
		/* sa.assertTrue(content.checkListcategory(), "The listcategory is not displayed");*/
		 sa.assertAll(); 
		 
		 System.out.println("1");
	 }
	 
	 //check the pop up 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To chceck the pop up has all the UI attributes")
	 @Test(priority=41)
	 public void checkAddCategoryPopUpUI()
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.addcategory.click(); 
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(content.checkAddcategorynameTextbox(), "The add category text box is not displayed");
		 sa.assertTrue(content.checkAddcategoryimage(), "The add category image is not displayed");
		 sa.assertTrue(content.checkAddbutton(), "The add category button is not displayed");
		 sa.assertTrue(content.checkCancelButton(), "The cancel category button is not displayed");
		 sa.assertAll();
		 System.out.println("2");
	 }
	 
	 //Check for the error mesages for adding the category 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check the error messages will be displayed when the user does not add any category")
	 @Test(priority=42)
	 public void checkErrormessages()
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.addcategory.click();
		 sleep(3000);
		 content.addpopup.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(content.errormessage1.isDisplayed(), "The error message name is not displayed");
		 sa.assertTrue(content.errormessage2.isDisplayed(), "The error message image is not displayed");
		 sa.assertAll();
		 
		 System.out.println("3");
	 }
	 
	 //check for the correct error mesages
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check the error messages will be displayed when the user does not add category name and category image")
	 @Test(priority=43)
	 public void checkcorrecterrormessge()
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.addcategory.click(); 
		 sleep(3000);
		 content.addpopup.click();
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals(content.errormessage1.getText(), "Category name cannot be empty");
		 sa.assertEquals(content.errormessage2.getText(), "Please select a Category Image");
		 sa.assertAll();
		 
		 System.out.println("4");
	 }
	 
	 //check messgae for the category image 
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check whether the error message for category name when the category name is added")
	 @Test(priority=44)
	 public void checkerormessageforcategoryimage()
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.addcategory.click(); 
		 content.categoryname.sendKeys("Test category");
		 sleep(3000);
		 content.addpopup.click();
		 Assert.assertEquals(content.errormessage2.getText(), "Please select a Category Image");
		 System.out.println("5");
	 }
	 
	 //check the error message for category name
	 
	 @Severity(SeverityLevel.TRIVIAL)
	 @Description("To check whether the error message for category name when it is not added")
	 @Test(priority=45)
	 public void checkForcategorynameErrormsg() throws AWTException
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.addcategory.click();
		 content.addCategoryImage();
		 sleep(3000);
		 content.addpopup.click();
		 Assert.assertEquals(content.errormessage1.getText(), "Category name cannot be empty");
		 
		 System.out.println("6");
		 
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the category is getting created or not ")
	 @Test(priority=46,dataProvider="getTestData")
	 public void checkAddingcategory(String CategoryName) throws AWTException
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.checkaddingcategory(CategoryName);
		 System.out.println("7");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the duplicate category is getting added or not")
	 @Test(priority=47,dataProvider="getTestData")
	 public void checkAddingDuplicateCategory(String CategoryName) throws AWTException
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.checkAddingSamecategory(CategoryName);
		 System.out.println("8");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the category can be edited or not")
	 @Test(priority=48,dataProvider="getTestData1")
	 public void checkEditCategory(String CategoryName,String NewCatname)
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.checkEditingcategorybyspace(CategoryName,NewCatname);
		 System.out.println("9");
	 }
	 
	 @Severity(SeverityLevel.MINOR)
	 @Description("To check all the UI attributes for adding sub category")
	 @Test(priority=49)
	 public void checkAddSubcategoryUI()
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.searchcategory.sendKeys("All humanities");
		 content.dropdown.click();
		 content.clicksubcategory();
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(content.checksubcategorytitle(), "The title is not dsipalyed");
		 sa.assertTrue(content.checksubcategorytitletext(), "The text box is not displayed");
		 sa.assertTrue(content.checksubcategorysubmit(), "The submit button is not  displayed");
		 sa.assertTrue(content.checkcancelbutton(), "The cancel button is  not displayed");
		 sa.assertAll();
		 System.out.println("10");
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check whether the blank sub category can be added or not")
	 @Test(priority=50)
	 public void checkaddingblanksubcategory()
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.searchcategory.sendKeys("All humanities");
		 content.dropdown.click();
		 content.clicksubcategory();
		 content.subcategorysubmit.click();
		 Assert.assertEquals(content.subcategoryerrormsg.getText(),"Sub category cannot be empty", "The message is not displayed");
		 System.out.println("11");
		 
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check whether the sub category can be added or not")
	 @Test(priority=51,dataProvider="getTestData2")
	 public void checkadddSubcategory(String CategoryName,String subcategory )
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.addsubcategory(CategoryName,subcategory); 
		 System.out.println("12");
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check whether the duplicate sub category can be added or not")
	 @Test(priority=52,dataProvider="getTestData2")
	 public void checkaddingDuplicateSubcategory(String CategoryName,String subcategory)
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.addsubcategory(CategoryName,subcategory);
		 sleep(2000);
		 Assert.assertEquals(content.addduplicatecategory.getText(),"Sub category already exist", "The pop up didnt occur");
		 System.out.println("13");
	 }
	 
	 @Severity(SeverityLevel.NORMAL)
	 @Description("To check whether the sub category can be edited or not ")
	 @Test(priority=53,dataProvider="getTestData3")
	 public void checkEditSubcategory(String CategoryName)
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.editsubcategory(CategoryName);
		 System.out.println("14");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the sub category can be deleted or not ")
	 @Test(priority=54,dataProvider="getTestData3")
	 public void checkdeleteSubcategory(String CategoryName)
	 {
		 content.content.click();
		 content.managecategories.click(); 
		 content.deletesubcategory(CategoryName);
		 System.out.println("15");
	 }
	 
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("To check whether the  category can be deleted or not ")
	 @Test(priority=55,dataProvider="getTestData3")
	 public void checkdeletingcategory(String CategoryName)
	 {
		 content.content.click();
		 content.managecategories.click();
		 content.deletecategory(CategoryName);
		 System.out.println("16");
		 
	 }
	
	 @AfterMethod
	   public void end() throws InterruptedException
	   {
		 tearDown();
	   }
	
}
