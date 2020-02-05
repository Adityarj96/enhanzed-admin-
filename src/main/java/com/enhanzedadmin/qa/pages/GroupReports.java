package com.enhanzedadmin.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class GroupReports extends Testbaseadmin
{
	
	 @FindBy(xpath="//z[contains(text(),'REPORTS')]")
	 public WebElement reports ;
	 
	 @FindBy(xpath="//z[contains(text(),'Group Reports')]")
	 public WebElement groupreports;
	 
	 @FindBy(xpath="//input[contains(@placeholder,'Search Groups')]")
	 public WebElement searchgroups;
	 
	 @FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][1]")
	 public WebElement malegraph;

     @FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][2]")
     public WebElement femalegraph;

	 @FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][3]")
	 public WebElement unknowngraph;

	 @FindBy(xpath="//*[name()='text' and contains(text(),'Male')]")
	 public WebElement malepie;

	 @FindBy(xpath="//*[name()='text' and contains(text(),'Female')]")
	 public WebElement femalepie;

	 @FindBy(xpath="//*[name()='text' and contains(text(),'Unknown')]")
	 public WebElement unkwnonpie;
	
	 @FindBy(xpath="//input[contains(@name,'tn')]")
	 WebElement topicnametextbox;
	
	 @FindBy(xpath="//a[contains(text(),'Next')]")
	 WebElement clickNext;
	 
	 @FindBy(xpath="//p[contains(text(),'Topics assigned')]")
	 WebElement topicassigned;
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[4]/div[1]/p[2]")
	 WebElement topicassignedcount;
	 
	 @FindBy(xpath="//p[contains(text(),'# Users Subscribed')]")
	 WebElement usersSubscribed;
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[4]/div[2]/p[2]")
	 WebElement usersSubscribedCount;
	 
	 @FindBy(xpath="//p[contains(text(),'# Users Completed')]")
	 WebElement usersCompleted;
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[4]/div[3]/p[2]")
	 WebElement usersCompletedCount;
	 
	 @FindBy(xpath="//p[contains(@class,'mgpara ng-binding')]")
	 WebElement groupName;
	 
	 @FindBy(xpath="//p[contains(@class,'uboxp1') and contains(text(),'TOTAL USERS ')]")
	 WebElement totalUsers;
	 
	 @FindBy(xpath="//p[contains(@class,'uboxp1') and contains(text(),'ACTIVE TODAY')]")
	 WebElement activeToday;
	 
	 @FindBy(xpath="//p[contains(@class,'dboxp1') and contains(text(),'USERS BY PLATFORM')]")
	 WebElement usersByPlatform;
	 
	 @FindBy(xpath="//p[contains(@class,'gboxp1') and contains(text(),'USERS BY GENDER')]")
	 WebElement usersByGender;
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/p")
	 WebElement totalUserscont;
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/p")
	 WebElement activeUsersCount;
	 
	 @FindBy(xpath="//p[contains(@class,'mgpara1 ng-binding')]")
     public WebElement numberofusers;
	 
	 @FindBy(xpath="//div[contains(@id,'swal2-content')]")
	 public WebElement errormessage;
	 
	 @FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	 public WebElement groupokbutton;
	 
	 @FindBy(xpath="//input[contains(@name,'tn')]")
	 public WebElement topicname;
	 
	 @FindBy(css="table>tbody>tr")
	 public List <WebElement> searchtopic; 
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[5]/div[2]/table/tbody/tr[1]/td[2]")
	 public WebElement topicsearchresults; 
	 
	 @FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[5]/div[2]/table/tbody/tr[1]/td[3]")
	 public WebElement topicssubscribed; 
	 
	 
	 
	  
	 public GroupReports()  {
			super();
			PageFactory.initElements(driver,this);
			
	}
	 
	 
	 public void clickGroupreports()
	 {
		 groupreports.click();
	 }
	 
	 public void clickNext()
	 {
		 clickNext.click();
	 }
	
	  public boolean checkTopicAssigned()
	  {
		
		return topicassigned.isDisplayed();
	  }
	  
	  public boolean checkTopicAssignedCount()
	  {
		 
		  return topicassignedcount.isDisplayed();
	  }
	  
	  public boolean checkUsersSubscribed()
	  {
		 
		 return usersSubscribed.isDisplayed();
	  }
	  
	  public  boolean checkUsersSubscribedCount()
	  {
		  
		  return usersSubscribedCount.isDisplayed();
	  }
	  
	  public boolean checkUsersCompleted()
	  {
		  
		  return usersCompleted.isDisplayed();
	  }
	  
	  public boolean checkUsersCompletedCount()
	  {
		  
		  return usersCompletedCount.isDisplayed();
	  }
	  
	  public boolean checkTotalUsersHeading()
	  {
		 
		  return totalUsers.isDisplayed();
	  }
	  
	  public boolean checkActiveToday()
	  {
		 
		  return activeToday.isDisplayed();
	  }
	  
	  public boolean checkTotalUsersCount()
	  {
		 
		  return totalUserscont.isDisplayed();
	  }
	  
	  public boolean checkActiveUsersCount()
	  {
		 
		  return activeUsersCount.isDisplayed();
	  }
	
	 public void checkGroupInfo(String groupname)
	 {
	    searchgroups.sendKeys(groupname);
	    String numberoffusers=numberofusers.getText();
	    String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
	    if(usernumber=="0" || Integer.parseInt(usernumber)==0)
	    {
	     groupName.click();
		 Assert.assertEquals(errormessage.getText(), "Group has no users");
		 groupokbutton.click();	
	    }
	    else
	    {
	    	groupName.click();
	    	SoftAssert sa=new SoftAssert();
			sa.assertTrue(checkTopicAssigned(), "The heading for topic assigned is not displayed");
			sa.assertTrue(checkTopicAssignedCount(),"The Topic assigned count is not displayed");
			sa.assertTrue(checkUsersSubscribedCount(),"The Topic assigned count is not displayed");
			sa.assertTrue(checkUsersCompleted(),"The users count is not displayed");
			sa.assertTrue(checkUsersCompletedCount(),"The users completed count is not displayed");
			sa.assertTrue(checkTotalUsersHeading(),"The total users heading is not displayed");
			sa.assertTrue(checkActiveToday(),"The active users heading is not displayed");
			sa.assertTrue(checkTotalUsersCount(),"The total users ");
			sa.assertTrue(checkActiveUsersCount(),"The active users heading is not displayed");
			sa.assertAll();
	    }
	    
	 }
	 
	 
	 public void checkTopics(String groupname,String topicName) throws InterruptedException
	 {
		 searchgroups.sendKeys(groupname);
		 String numberoffusers=numberofusers.getText();
		    String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
		    if(usernumber=="0" || Integer.parseInt(usernumber)==0)
		    {
		     groupName.click();
			 Assert.assertEquals(errormessage.getText(), "Group has no users");
			 groupokbutton.click();	
		    }
		    else
		    {
		    	groupName.click();
		    	
		    	
		    	Thread.sleep(5000);
		    	
		    	
		    	JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("window.scrollBy(0,1000)");
		    	
		    	
		        topicname.sendKeys(topicName);
		        for(int i=1;i<=searchtopic.size()-1;i++)
		        {
		           if(searchtopic.get(i).getText().contains("No Data"))
		           {
		        	   System.out.println("The topic is not subscribed for the group");
		           }		           
		           else if(searchtopic.get(i).getText().contains(topicName))
		           {
		        	   Assert.assertTrue(topicsearchresults.isDisplayed(), "The topicname is not displayed");
		        	   Assert.assertTrue(topicssubscribed.isDisplayed(), "The topicsubscribed is not displayed");
		        	   
		           }
	             }
	 } 
}
}