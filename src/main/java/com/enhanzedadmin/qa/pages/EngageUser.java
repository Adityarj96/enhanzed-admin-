package com.enhanzedadmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class EngageUser extends Testbaseadmin {
	
	@FindBy(xpath="//z[contains(text(),'ENGAGE')]")
	public  WebElement engageTab;
	
	@FindBy(xpath="//z[contains(text(),'With Users')]")
	public  WebElement withUsersTab;
	
	@FindBy(xpath="//input[contains(@name,'EMAILID')]")
	public  WebElement searchUsers;
	
	@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]")
	public  WebElement verifyUser;
	
	@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")
	public  WebElement clickUser;
	
	@FindBy(xpath="//input[@name='ntitle']")
	public  WebElement messagetitle;
	
	
	@FindBy(xpath="//textarea[@name='ntitle']")
	public  WebElement messageDescription;
	
	
	@FindBy(xpath="//input[@ng-click='url()']")
	public  WebElement urlClickCheckbox;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement checkbox;
	
	@FindBy(xpath="//input[@name='obj.url']")
	public  WebElement url;
	
	@FindBy(xpath="//td[contains(text(),'No Data')]")
	public WebElement nodata;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[5]")
	public WebElement disableduser;
	
	@FindBy(css="table>tbody>tr")
	public List <WebElement> results;
	
	
	@FindBy(xpath="//button[@ng-click='sendmsg()']")
	public  WebElement sendMessageButton;
	
	@FindBy(xpath="//button[contains(text(),' Send Notification ')]")
	public  WebElement sendNotification;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/div/div/div/ul/li[11]/a")
	public  WebElement frwrdbutton;
	
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	public  WebElement okButton;
	
	@FindBy(xpath="//p[contains(@ng-if,'error == true')]")
	public  WebElement errormsg1;
	
	@FindBy(xpath="//p[contains(@ng-if,'error1 == true')]")
	public  WebElement errormsg2;
	
	@FindBy(xpath="//p[contains(@ng-if,'error3 == true')]")
	public  WebElement errormsg3;
	
	@FindBy(xpath="//input[contains(@name,'UNAME')]")
	public WebElement usernamefield;
	
	@FindBy(xpath="//input[contains(@name,'EMAILID')]")
	public WebElement emailid;
	
	@FindBy(xpath="//input[contains(@name,'UR')]")
	public WebElement userroletextbox;
	
	@FindBy(xpath="//input[contains(@name,'LA')]")
	public WebElement userstaus;
	
	
	public EngageUser() 
	{
		super();
	PageFactory.initElements(driver,this);
	}
	
	public void clickEngageTab()
	{
		engageTab.click();
	}
	
	public void clickWithUsers()
	{
		withUsersTab.click();
	}
	
	//Sending notification for single user with engage tab
	public void sendNotificationSingleUser(String emailId)
	{
		clickEngageTab();
		clickWithUsers();
		searchUsers.sendKeys(emailId);
		try
		{
		String name = verifyUser.getText();
		if(name.equalsIgnoreCase(emailId))
		{
			clickUser.click();
			sleep(3000);
			messagetitle.sendKeys("New Topic will be assigned tomorrow");
			messageDescription.sendKeys("Topic should be completed within one week of the date assigned");
			urlClickCheckbox.click();
			url.sendKeys("https://www.codeproject.com");
			sendMessageButton.click();
			sleep(3000);
			okButton.click();
			System.out.println("Message Sent Successfully");	
		}
		}
		catch(Exception e)
		{
			System.out.println("No such user is present");
		}
	}
	public void sendNotificationMultipleUser()
	{
		clickEngageTab();
		clickWithUsers();
		
		//fetching all the usernames
		
		 ArrayList<String> list=new ArrayList<String>();
		 list.add(0, "tiesto@gmail.com");
		 list.add(1, "tiesto@gmail.com");
		 list.add(2, "babugoud@enhanzed.com");
		 list.add(3,"naresh@enhanzed.com");
	     list.add(4,"rjaditya96@gmail.com");
	     list.add(5,"sumana@enhanzed.com");
	     list.add(6,"shreeja@enhanzed.com");
	     list.add(7,"preetham@enhanzed.com");
	     list.add(8,"nareshgutti12@gmail.com");
	     list.add(9,"bpmanjula@jssuni.edu.in");
	     list.add(10,"ramya.3394@gmail.com");
	     list.add(11,"varunbharadwaj2018@gmail.com");
	     list.add(12,"v@t.com");
	     list.add(13,"rani05885@gmail.com");
	    
		 
		 for(int i=0;i<list.size();i++)
		 {
			 emailid.sendKeys(list.get(i).toString());
			 sleep(3000);
			 
			 if(nodata.isDisplayed() || !checkbox.isDisplayed())
			 {
				 System.out.println("The user may be disabled or the user may not have any data");
				 searchUsers.clear();
			 }
			  
			 else
			 {
				 sleep(3000);
				 checkbox.click();
				 sleep(3000);
				 searchUsers.clear(); 
			 }
			 
		 }
		 
		 sendNotification.click();
		 messagetitle.sendKeys("New Topic will be assigned tomorrow");
		 messageDescription.sendKeys("Topic should be completed within one week of the date assigned");
		 urlClickCheckbox.click();
		 url.sendKeys("https://www.codeproject.com");
		 sendMessageButton.click(); 
	}
	
	public void checkPagination()
	{
		for(int i=1;i<=23;i++)
		{
			frwrdbutton.click();	
		}	
	}
	
	public void searchUserontermname(String searchterm)
	{
		usernamefield.sendKeys(searchterm);
		for (int i = 0; i < results.size(); i++) 
		{
			if(results.get(i).getText().contains("No Data"))
			{
				System.out.println("No such user is present in the  group");
			}
			else if(results.get(i).getText().contains(searchterm))
			{
				Assert.assertTrue(results.get(i).getText().equalsIgnoreCase(searchterm), "The search functionality is not working properly");
			}
			
		}
	}
	
	
	public void searchUseronterm(String searchterm)
	{
		emailid.sendKeys(searchterm);
		for (int i = 0; i < results.size(); i++) 
		{
			
		
			if(results.get(i).getText().contains("No Data"))
			{
				System.out.println("No such user is present in the  group");
			}
			else if(results.get(i).getText().contains(searchterm))
			{
				Assert.assertTrue(results.get(i).getText().contains(searchterm), "The search functionality is not working properly");
			}
			
		}
		
	}
	
	
	public void searchUserontermstatus(String searchterm)
	{
		userstaus.sendKeys(searchterm);
		for (int i = 0; i < results.size(); i++) 
		{
			
			if(results.get(i).getText().contains("No Data"))
			{
				System.out.println("No such user is present in the  group");
			}
			else if(results.get(i).getText().contains(searchterm))
			{
				Assert.assertTrue(results.get(i).getText().contains(searchterm), "The search functionality is not working properly");
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
