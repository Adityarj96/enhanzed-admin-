package com.enhanzedadmin.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class ContentManageCategories extends  Testbaseadmin
{
	//content
	@FindBy(xpath="//z[contains(text(),'CONTENT')]")
	public  WebElement content;
	
	//manage categories
	@FindBy(xpath="//z[contains(text(),'Manage Categories')]")
	public  WebElement managecategories;
    
	//manage objects
	
	
	//manage topics 
	@FindBy(xpath="//z[contains(text(),'Manage Topics')]")
	public  WebElement managetopics;
	
	//add category
	@FindBy(xpath="//button[contains(text(),' Add Category ')]")
	public  WebElement addcategory;
	
	//categoy name 
	@FindBy(xpath="//input[contains(@name,'cname')]")
	public  WebElement categoryname;
	
	//upload image
	@FindBy(xpath="//div[contains(@class,'button2 ng-pristine ng-untouched ng-valid ng-empty')]")
	public  WebElement categoryimage;
	
	//add button
	@FindBy(xpath="//button[contains(@class,'button1')]")
	public  WebElement addpopup;
	
	@FindBy(xpath="//button[contains(@class,'button2 footerbtn2')]")
	public  WebElement cancelpopup;
	
	//breadcrumb
	@FindBy(css="ol.breadcrumb")
	public  WebElement breadcrumb;
	
	//error msg 1
	@FindBy(xpath="//p[contains(text(),'Category name cannot be empty ')]")
	public  WebElement errormessage1;
	
	//error msg 2
	@FindBy(xpath="//p[contains(text(),'Please select a Category Image ')]")
	public  WebElement errormessage2;
	
	//search table
	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[2]/td")
	public List <WebElement> searchgroupresults;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[2]/td")
	public WebElement searchgroupresults1;
	
	@FindBy(xpath="//div[contains(@class,'ng-binding')]/span")
	public  WebElement categorynamelist;
	
	
	@FindBy(xpath="//input[contains(@placeholder,'Search Categories')]")
	public  WebElement searchcategory;
	
	@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	public  WebElement okbutton;
	
	@FindBy(xpath="//div[contains(@id,'swal2-content')]")
	public  WebElement addexistingcategorymsg;
	
	@FindBy(xpath="//button[contains(@alt,'Delete')][1]")
	public WebElement editcategory;

	@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	public WebElement submit;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div[1]/h4/div[1]/button[3]")
	public WebElement dropdown;
	
	@FindBy(xpath="//*[@id='723']/div/div/div/p")
	public WebElement firstsubcategory;
	
	@FindBy(xpath="//input[contains(@id,'txtevent')]")
	public WebElement  subcategorytxtbox;
	
	@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	public WebElement  subcategorysubmit;
	
	@FindBy(xpath="//button[contains(@class,'swal2-cancel button2')]")
	public WebElement  subcategorycancel;
	
	@FindBy(xpath="//h2[contains(@id,'swal2-title')]")
	public WebElement  subcategorytile;
	
	@FindBy(xpath="//div[contains(@id,'swal2-validationerror')]")
	public WebElement  subcategoryerrormsg;
	
	@FindBy(xpath="//button[contains(@ng-click,'addsubcategory(category,null,index)')]")
	public WebElement subcategorydropdown;
	
	@FindBy(xpath="//div[contains(@id,'swal2-content')]")
	public WebElement addduplicatecategory;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div[2]/div[1]/div[1]/button[1]")
	public WebElement subcategorylist;
	
	@FindBy(xpath="//button[contains(@ng-click,'editScategory(category,an,index,$index)')]")
	public WebElement editsubcategory;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div[2]/div[1]/div[1]/button[2]")
	public WebElement deletesubcategory;
	
	@FindBy(xpath="//button[contains(@ng-click,'deletewarn(category)')]")
	public WebElement deletecategory;
	
	
	
	
	@FindBy(xpath="//button[contains(@class,'button2')]")
	public WebElement cancel;
	
	@FindBy(xpath="//input[contains(@name,'cname')]")
	public WebElement editcatname;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement submitsubcategory;
	
	public ContentManageCategories() 
	{
		super();
	PageFactory.initElements(driver,this);
	}
	
	public boolean checkbreadcrumb()
	{
		return breadcrumb.isDisplayed();
	}
	
	public boolean checkaddcategorybutton()
	{
		return addcategory.isDisplayed();
	}
	
	public boolean checksearchcategory()
	{
		return searchcategory.isDisplayed();
	}
	
	
	
	public boolean checkAddcategorynameTextbox()
	{
		sleep(3000);
		return categoryname.isDisplayed();
	}
	
	public boolean checkAddcategoryimage()
	{
		return categoryimage.isDisplayed();
	}
	
	public boolean checkAddbutton()
	{
		return addpopup.isDisplayed();
	}
	
	public boolean checkCancelButton()
	{
		return cancelpopup.isDisplayed();
	}
	
	public boolean checksubcategorytitle()
	{
		return subcategorytile.isDisplayed();
	}
	
	public boolean checksubcategorytitletext()
	{
		return subcategorytxtbox.isDisplayed();
	}
	
	public boolean checksubcategorysubmit()
	{
		return subcategorysubmit.isDisplayed();
	}
	
	public boolean checkcancelbutton()
	{
		return subcategorycancel.isDisplayed();
	}
	
	
	public void clicksubcategory()
	{
		sleep(5000);
		 Actions actions = new Actions(driver);
        actions.moveToElement(subcategorydropdown).click().perform();
	}
	
	
	public void addCategoryImage() throws AWTException
	{
        sleep(3000);
		categoryimage.click();
		sleep(5000);
		//add topic image
		StringSelection sel = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\topicwhite-1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		Robot robot = new Robot();    
		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(3000);
	}
	
	
     public void checkaddingcategory(String CategoryName) throws AWTException
     {
    	 addcategory.click();
    	 categoryname.sendKeys(CategoryName);
    	 addCategoryImage();
    	 sleep(3000);
    	 addpopup.click();
    	 sleep(3000);
    	 okbutton.click();
    	 sleep(5000);
    	 searchcategory.sendKeys(CategoryName);
    	 for(int i=1;i<=searchgroupresults.size()-1;i++)
    	 {
    		 if(searchgroupresults.get(i).getText().contains(CategoryName))
    		 {
    			Assert.assertEquals(categorynamelist.getText(),CategoryName, "The search result does not contains the category");
    		 }
    		 else if(searchgroupresults.get(i).getText().contains("No Data"))
    		 {
    			 System.out.println("The search result is not present");
    		 }
    	 } 
     }
     
     public void checkAddingSamecategory(String CategoryName) throws AWTException
     {
    	 searchcategory.sendKeys(CategoryName);
    	 for(int i=1;i<=searchgroupresults.size()-1;i++)
    	 {
    		 if(searchgroupresults.get(i).getText().contains(CategoryName))
    		 {
    			 Assert.assertEquals(categorynamelist.getText(),CategoryName, "The search result does not contains the category"); 
    		 }
    	 }
    	 
    	 sleep(3000);
    	 addcategory.click();
    	 categoryname.sendKeys(CategoryName);
    	 addCategoryImage();
    	 sleep(3000);
    	 addpopup.click();
    	 
    	 sleep(3000);
    	
    	 Assert.assertEquals(addexistingcategorymsg.getText(), "Category already exist", "The message is not displayed");
    	 okbutton.click(); 
     }
     
     public void checkEditingcategorybyspace(String CategoryName,String NewCatname)
     {
    	 searchcategory.sendKeys(CategoryName); 
    	 if(searchgroupresults1.getText().contains(CategoryName))
    	 {
    		 editcategory.click();
    		 
    		 categoryname.clear();
    		 
    		 categoryname.sendKeys(NewCatname);
    		 
    		 addpopup.click();
    		 
    		 Assert.assertEquals(addexistingcategorymsg.getText(), "Category edited Successfully");
    	 }
    	 
    	 else if(searchgroupresults1.getText().contains("No Data"))
    	 {
    		 System.out.println("The category deos not exits");
    	 }
    	 
     }
     
     
     public void addsubcategory(String CategoryName ,String subcategory)
     {
    	 searchcategory.sendKeys(CategoryName);
    	 if(searchgroupresults1.getText().contains(CategoryName))
    	 {
    		 dropdown.click(); 
    		 
    		 sleep(5000);
    		 Actions actions = new Actions(driver);
             actions.moveToElement(subcategorydropdown).click().perform();
             subcategorytxtbox.sendKeys(subcategory);
             subcategorysubmit.click();
             sleep(2000); 
    	 }
    	 
    	 else if(searchgroupresults1.getText().contains("No Data"))
    	 {
    		 System.out.println("The category name does not exist");
    	 }
		 }
     
     public void editsubcategory(String CategoryName)
     {
    	 searchcategory.sendKeys(CategoryName);
    	 if(searchgroupresults1.getText().contains(CategoryName))
    	 {
    		 dropdown.click();
    		 
    		 sleep(5000);
    		 Actions actions = new Actions(driver);
            actions.moveToElement(subcategorylist).click().perform();
            editcatname.clear();
	    	editcatname.sendKeys("Test subcategory");
	    	submitsubcategory.click();
    	 }
    	 
    	 else if(searchgroupresults1.getText().contains("No Data"))
    	 {
    		 System.out.println("no such category is displayed");
    	 }
    		 
    	 }
     
     public void deletesubcategory(String CategoryName)
     {
    	 searchcategory.sendKeys(CategoryName); 
    	 if(searchgroupresults1.getText().contains(CategoryName))
    	 {
    		dropdown.click();  
    		sleep(5000);
    		Actions actions = new Actions(driver);
            actions.moveToElement(deletesubcategory).click().perform();
            submit.click();
    	 }
     }
     
     public void deletecategory(String CategoryName )
     {
    	 searchcategory.sendKeys(CategoryName); 
    	 if(searchgroupresults1.getText().contains(CategoryName))
    	 {
    		 deletecategory.click();
    		 submit.click();
    		 sleep(3000);
    		 searchcategory.sendKeys(CategoryName);
    		 Assert.assertTrue(searchgroupresults1.getText().contains("No Data"));
    	 } 
     }
     }
		 
    	 
     


     
     
     
     
     
     
     
     
     
     
     
     
     
     


	
	
	
	
	


