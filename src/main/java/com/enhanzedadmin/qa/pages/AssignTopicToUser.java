package com.enhanzedadmin.qa.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class AssignTopicToUser extends Testbaseadmin {

	EngageUser user;
	//Assign tab
		@FindBy(xpath="//z[contains(text(),'ASSIGN')]")
		public WebElement assignTab;
		
		//To Users tab
		@FindBy(xpath="//z[contains(text(),'To Users')]")
		public WebElement toUsers;
		
	
		@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
		public WebElement verifyUser;
		
		@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a")
		public WebElement userClick;
		
		@FindBy(xpath="//input[@ng-model='globalSearchTermAuto']")
		public WebElement searchTopicUnassignedTab;
		
		@FindBy(xpath="//input[@ng-model='globalSearchTermAuto1']")
		public WebElement searchTopicAssignedTab;
		
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[2]")
		public WebElement verifytopic;
		
		@FindBy(xpath="//button[contains(@class,'addsavebutton1 ng-scope')]")
		public WebElement assignButton;
		
		@FindBy(xpath="//input[@class='md-datepicker-input']")
		public WebElement datePicker;
		
		@FindBy(xpath="//a[text()='ASSIGNED TOPICS']")
		public WebElement assignedTopicsTab;
		
		@FindBy(xpath="//a[text()='UNASSIGNED TOPICS']")
		public WebElement unassignedTopicsTab;
		
		@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
		public WebElement okButton;
		
		@FindBy(xpath="//button[@class='md-datepicker-triangle-button md-icon-button md-button']")
		public WebElement datePickerOpen;
		
		@FindBy(css="table>tbody>tr")
		public List <WebElement> results;
		
		@FindBy(xpath="//li[contains(@class,'listinactive')]//a[contains(text(),'ASSIGNED TOPICS')]")
		public WebElement assignedtopics;
		
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[2]")
		public WebElement assignedtopicscheck;
		
		
		@FindBy(xpath="//ul[contains(@class,'pagination ng-table-pagination ng-scope')]")
		public WebElement pagination;
		
		@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a")
		public WebElement searchresult;
		
		@FindBy(xpath="//*[@id='content']/div/nav/ol/li[2]/a")
		public WebElement tousersbreadcrumb;
		
		@FindBy(css="ol.breadcrumb>li")
		public List<WebElement> breadcrumb;
		
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[3]/md-datepicker/div[1]/button")
		WebElement calendarDropdown;
		
		@FindBy(xpath="/html/body/div[3]/div[2]/md-calendar/div/md-virtual-repeat-container/div/div[2]/table/tbody[5]/tr[3]/td[2]/span")
		public WebElement selDate;
		
		@FindBy(xpath="//a[contains(text(),'»')]")
		public WebElement forwrdbutton;
		
		@FindBy(xpath="//button[contains(text(),'Unassign')]")
		public WebElement unassignButton;
		
		@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
		public WebElement yesbutton;
		
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[4]")
		private WebElement status;
		
		@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[2]")
		private WebElement verifyAssignedTopicInAssignedTab;
		
		
		@FindBy(xpath="//input[contains(@name,'UNAME')]")
		public WebElement usernamefield;
		
		@FindBy(xpath="//input[contains(@name,'EMAILID')]")
		public WebElement emailid;
		
		@FindBy(xpath="//input[contains(@name,'UR')]")
		public WebElement userrole;
		
		@FindBy(xpath="//input[contains(@name,'LA')]")
		public WebElement userstaus;
		
		
		
		public AssignTopicToUser() 
		{
			super();
		PageFactory.initElements(driver,this);
		user=new EngageUser();
		}
		
		public boolean checkunassignedtab()
		{
			return assignedTopicsTab.isDisplayed();
		}
		
		public boolean checkassignedtab()
		{
			return unassignedTopicsTab.isDisplayed();
		}
		
		public boolean checkSearchtextbox()
		{
			return searchTopicUnassignedTab.isDisplayed();
		}
		
		public boolean checkpagination()
		{
			return pagination.isDisplayed();
		}
		
		public void clickAssignTab()
		{
			assignTab.click();
		}
		
		public void clickToUsers()
		{
			toUsers.click();
		}
		
		
		public void assignTopicToUsers(String emailID, String topicName) throws InterruptedException
		{
			emailid.sendKeys(emailID);
			for (int i = 0; i < results.size(); i++) 
			{
				if(results.get(i).getText().contains("No Data"))
				{
					System.out.println("No such user is present in the  group");
				}
				else if(results.get(i).getText().contains(" Disabled"))
				{
					System.out.println("The user is dsiabled");
				}
				
				else if(results.get(i).getText().contains(" Active"))
				{
					userClick.click();
					sleep(4000);
					searchTopicUnassignedTab.sendKeys(topicName);
					sleep(4000);
					for (int j = 0; j < results.size(); j++) 
					{
						if(results.get(j).getText().contains("No Data"))
						{
							System.out.println("No such topic is present in the List or the topic might be assigned to the user");
						}
						else if(results.get(j).getText().contains(topicName))
						{
							calendarDropdown.click();
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();", selDate);
							
							new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'addsavebutton1 ng-scope')]")));
							driver.findElement(By.xpath("//button[contains(@class,'addsavebutton1 ng-scope')]")).click();
							
							sleep(6000);
							okButton.click();
							
							sleep(4000);
							assignedTopicsTab.click();
							
							searchTopicAssignedTab.sendKeys(topicName);
							
							Assert.assertEquals(topicName,assignedtopicscheck.getText() , "The topic is not in the assigned tab ");
						}
					}
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
					/*Assert.assertEquals(results.get(i).getText().contains(searchterm) , "The search functionality is not working properly");*/
					Assert.assertTrue(results.get(i).getText().contains(searchterm), "The search functionality is not working properly");
				}
				
			}
		}
		
		
		
		public void searchUsersactivestatus(String searchterm)
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
		
		
		
		
		
		
		public void UnassignTopictouser(String emailID,String topicName)
		{
			emailid.sendKeys(emailID);
			for (int i = 0; i < results.size(); i++) 
			{
				if(results.get(i).getText().contains("No Data"))
				{
					System.out.println("No such user is present in the  group");
				}
				else if(results.get(i).getText().contains(" Disabled"))
				{
					System.out.println("The user is dsiabled");
				}
				
				else if(results.get(i).getText().contains(" Active"))
				{
					userClick.click();
					sleep(3000);
					assignedTopicsTab.click();
					searchTopicAssignedTab.sendKeys(topicName);
					for (int j = 0; j < results.size(); j++) 
					{
						if(results.get(j).getText().contains("No Data"))
						{
							System.out.println("No such topics assigned to the group");
						}
						
						else if(results.get(j).getText().contains(topicName))
						{
							
							new WebDriverWait(driver, 50).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'addsavebutton1')]")));
							driver.findElement(By.xpath("//button[contains(@class,'addsavebutton1')]")).click();
							
							
							sleep(3000);
							yesbutton.click();
							sleep(3000);
							okButton.click();
							
							sleep(3000);
							unassignedTopicsTab.click();
							
							searchTopicUnassignedTab.sendKeys(topicName);
							
							Assert.assertEquals(topicName,assignedtopicscheck.getText() , "The topic is not in the unassigned tab ");
							
						}
					}
					
				}
				}
		}
		
		public void checkBreadcrumb()
		{
			ArrayList<String> alist = new ArrayList<String>();
			alist.add("Assign");
			alist.add("To Users");
			
			for(int i=0;i<=breadcrumb.size()-1;i++)
			{
				String checkbc=breadcrumb.get(i).getText();
				//Assert.assertEquals(alist,checkbc);	
			}
			
			
		}
		
		
		
		public void checkPagination()
		{
			for(int i=1;i<=23;i++)
			{
				forwrdbutton.click();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
			
