package com.enhanzedadmin.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class AssignTopicToGroup extends Testbaseadmin {
	
            AssignTopicToUser user;
	        //Assign tab
			@FindBy(xpath="//z[contains(text(),'ASSIGN')]")
			public WebElement assignTab;
			
			//To Users tab
			@FindBy(xpath="//z[contains(text(),'To Groups')]")
			public WebElement toGroup;
			
			//Search users search box
			@FindBy(xpath="//input[@name='searchName']")
			public WebElement searchGroup;
			
			@FindBy(xpath="//div[@class='mgname']")
			public WebElement verifyGroup;
			
			@FindBy(xpath="//p[contains(@class,'mgpara ng-binding')]")
			public WebElement clickGroup;
			
			@FindBy(xpath="//input[@ng-model='globalSearchTermAuto']")
			public WebElement searchTopicUnassignedTab;
			
			@FindBy(xpath="//input[@ng-model='globalSearchTermAuto1']")
			public WebElement searchTopicAssignedTab;
			
			@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[2]")
			public WebElement verifytopic;
			
			@FindBy(xpath="//button[contains(text(),'Assign')]")
			public WebElement assignButton;
			
			@FindBy(xpath="//input[@class='md-datepicker-input']")
			public WebElement datePicker;
			
			@FindBy(xpath="//a[text()='ASSIGNED TOPICS']")
			public WebElement assignedTopicsTab;
			
			@FindBy(xpath="//div[@id=\"content\"]/div/div[2]/table/tbody/tr[1]/td[2]")
			public WebElement verifyAssignedTopicInAssignedTab;
			
			@FindBy(xpath="//button[@class='swal2-confirm button1']")
			public WebElement okButton;
			
			
			@FindBy(xpath="//button[@class='md-datepicker-triangle-button md-icon-button md-button']")
			public WebElement datePickerOpen;
			
			
			@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[4]")
			public WebElement NoData;
			
			@FindBy(xpath="//ul[contains(@class,'pagination ng-isolate-scope ng-not-empty ng-valid')]")
			public WebElement pagination;
			
			@FindBy(xpath="//div[contains(@class,'groupcard')]")
			public WebElement allGroups;
			
			@FindBy(xpath="//a[contains(text(),'Next')]")
			public WebElement next;
			
			@FindBy(xpath="//a[contains(text(),'First')]")
			public WebElement first;
			
			@FindBy(xpath="//a[contains(text(),'Last')]")
			public WebElement last;
			
			
			@FindBy(css="table>tbody>tr")
			public List <WebElement> results;
			
			@FindBy(xpath="//p[contains(@class,'mgpara1 ng-binding')]")
			public WebElement numberofusers;
			
			 @FindBy(xpath="//div[contains(@id,'swal2-content')]")
			 public WebElement errormessage;
			
			 @FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
			 public WebElement groupokbutton;
			 
			 @FindBy(xpath="/html/body/div[3]/div[2]/md-calendar/div/md-virtual-repeat-container/div/div[2]/table/tbody[5]/tr[3]/td[2]/span")
			 public WebElement selDate ;
			
			 @FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[4]")
			 public WebElement nodata;
			
			
			public AssignTopicToGroup() 
			{
				super();
			PageFactory.initElements(driver,this);
			user=new AssignTopicToUser();
			}
			
			
			public void clickAssignTab()
			{
				assignTab.click();
			}
			
			public void clickToGroup()
			{
				toGroup.click();
			}
			
			public boolean checkSearchTopic()
			{
				return searchGroup.isDisplayed();
			}
			
			
			public boolean checkpagination()
			{
				return pagination.isDisplayed();
			}
			
			public boolean checkAllGroup()
			{
				return allGroups.isDisplayed();
			}
			
			public boolean checkgroupassignedtab()
			{
				return searchTopicUnassignedTab.isDisplayed();
			}
			
			
			public void assignTopicToGroup(String groupName,String topicName)
			{
					searchGroup.sendKeys(groupName);
					String name = verifyGroup.getText();
					System.out.println(name);
					
					if(nodata.isDisplayed())
					{
						System.out.println("No data");
					}
					if(groupName.equalsIgnoreCase(name))
					{
						String numberoffusers=numberofusers.getText();
						System.out.println(numberoffusers);
						String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
						
						if(usernumber=="0" || Integer.parseInt(usernumber)==0)
						{
							sleep(3000);
							clickGroup.click();
							Assert.assertEquals(errormessage.getText(),"Group has no users to assign topics");
							groupokbutton.click();
						}
						else {
						verifyGroup.click();
						user.searchTopicUnassignedTab.sendKeys(topicName);
						for (int j = 0; j < results.size(); j++) 
						{
							if(results.get(j).getText().contains("No Data"))
							{
								System.out.println("No such topic is present in the List or the topic might be assigned to the user");
							}
							else if(results.get(j).getText().contains(topicName))
							{
								user.calendarDropdown.click();
								JavascriptExecutor executor = (JavascriptExecutor)driver;
								executor.executeScript("arguments[0].click();", selDate);
								
								new WebDriverWait(driver, 80).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'addsavebutton1')]")));
								driver.findElement(By.xpath("//button[contains(@class,'addsavebutton1')]")).click();
								
								sleep(6000);
								okButton.click();
								
								sleep(4000);
								assignedTopicsTab.click();
								
								searchTopicAssignedTab.sendKeys(topicName);
								
								Assert.assertEquals(topicName,user.assignedtopicscheck.getText() , "The topic is not in the assigned tab ");
							}
						}
						
					}
			}
}
			
			public void unassignTopicToGroup(String groupName,String topicName)
			{
				searchGroup.sendKeys(groupName);
				String name = verifyGroup.getText();
				System.out.println(name);
				if(groupName.equalsIgnoreCase(name))
				{
					String numberoffusers=numberofusers.getText();
					System.out.println(numberoffusers);
					String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
					if(usernumber=="0" || Integer.parseInt(usernumber)==0)
					{
						sleep(3000);
						clickGroup.click();
						Assert.assertEquals(errormessage.getText(), "Group has no users to assign topics");
						groupokbutton.click();
					}
					else {
						verifyGroup.click();
						user.assignedTopicsTab.click();
						searchTopicAssignedTab.sendKeys(topicName);
						for (int j = 0; j < results.size(); j++) 
						{
							if(results.get(j).getText().contains("No Data"))
							{
								System.out.println("No such topics assigned to the group");
							}
							
							else if(results.get(j).getText().contains(topicName))
							{
								
								new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'addsavebutton1')]")));
								driver.findElement(By.xpath("//button[contains(@class,'addsavebutton1')]")).click();
								
								
								sleep(3000);
								user.yesbutton.click();
								sleep(3000);
								okButton.click();
								
								sleep(3000);
								user.unassignedTopicsTab.click();
								
								searchTopicUnassignedTab.sendKeys(topicName);
								
								Assert.assertEquals(topicName,user.assignedtopicscheck.getText() , "The topic is not in the unassigned tab ");
								
							}
						
			}
			
}
			}
}
}

					
					
		

				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			

