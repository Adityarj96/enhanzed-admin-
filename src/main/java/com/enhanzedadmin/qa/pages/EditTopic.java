package com.enhanzedadmin.qa.pages;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class EditTopic extends Testbaseadmin {
	
		//xpath for clicking the content
		@FindBy(xpath="//z[contains(text(),'CONTENT')]")
		private WebElement content;

		//xpath for manage topics
		@FindBy(xpath="//z[contains(text(),'Manage Topics')]")
		private WebElement manageTopics;
		
		//xpath for the button to save topic
		@FindBy(xpath="//button[@ng-click='saveon()']")
		private WebElement saveTopic;
		
		//xpath for adding overview
		@FindBy(xpath="//div[@id=\"content\"]/div[2]/div[3]/div/div/div/textarea")
		
		private WebElement addOverview;
		
		//xpath for adding overview
		@FindBy(xpath="//input[@name='searchName']")
		private WebElement searchTopicBox;

		
		//xpath for adding overview
		@FindBy(xpath="//a[@ng-click='topicdetail(row)']")
		private WebElement clickTopicName;
		
		//xpath for adding overview
		@FindBy(xpath="//button[@ng-click='edittopic()']")
		private WebElement clickEditButton;
		
		//xpath for overview tab click
		@FindBy(xpath="//*[@id=\"divimg\"]/div/ul/li[1]")
		private WebElement overviewTabClick;
		
		//xpath for overview tab click
		@FindBy(xpath="//button[@ng-click='savetopic()']")
		private WebElement saveBtnAfterEdit;
		
		//xpath for overview tab click
		@FindBy(xpath="//button[@ng-click='discardchanges()']")
		private WebElement discardBtnAfterEdit;
		
		//click yes button
		@FindBy(xpath="//button[@class='swal2-confirm button1']")
		private WebElement clickYesBtn;
		
		//click OK button
		@FindBy(xpath="//button[contains(text(),'OK')]")
		private WebElement clickOKBtn;
		
		
		//click unpublish button
		@FindBy(xpath="//div[@id=\"content\"]/div[1]/button[1]")
		private WebElement unpublishBtn;
		
		//click nugget title
		@FindBy(xpath="//div[@class='topicdesc']")
		private List<WebElement> nuggetTitle;
				
		//click unpublish button
		@FindBy(xpath="//div[@class='panel-body']")
		private List<WebElement> objects;
		
		
		public EditTopic() 
		{
			super();
		PageFactory.initElements(driver,this);
		
		}
		
		//Click on Content tab
		public void clickContent()
		{
			content.click();
		}
		
		//Click on Manage Topics
		public void clickManageTopics()
		{
			manageTopics.click();
		}
		
		public void editTopic(String topicName,String editText)
		{
			implicitWait(40);
			searchTopicBox.sendKeys(topicName);
			try
			{
			String name = clickTopicName.getText();
			
			if(topicName.equalsIgnoreCase(name))
			{
				clickTopicName.click();
				System.out.println(name + "is clicked");
			}
			else
			{
				System.out.println("Invalid Topic");
			}
			
			
			String text = unpublishBtn.getText();
			if(text.equalsIgnoreCase("Unpublish"))
			{
				unpublishBtn.click();
				sleep(3000);
				clickYesBtn.click();
				sleep(3000);
				clickOKBtn.click();
				sleep(3000);
				clickEditButton.click();
			}
			else
			{
			sleep(3000);
			clickEditButton.click();
			}
			sleep(3000);
			overviewTabClick.click();
			sleep(3000);
			addOverview.clear();
			sleep(3000);
			addOverview.sendKeys(editText);
			sleep(3000);
			saveBtnAfterEdit.click();
			sleep(3000);
			clickYesBtn.click();
			sleep(3000);
			System.out.println("Topic Edited successfully");
			}
			catch(Exception e)
			{
				System.out.println("No such topic is present");
			}
			
		}
		
		public void discardTopic(String topicName,String editText)
		{
			implicitWait(40);
			searchTopicBox.sendKeys(topicName);
			
			try
			{
			String name = clickTopicName.getText();
			
			if(topicName.equalsIgnoreCase(name))
			{
				clickTopicName.click();
				System.out.println(name + "is clicked");
			}
			else
			{
				System.out.println("Invalid Topic");
			}
			
			
			String text = unpublishBtn.getText();
			if(text.equalsIgnoreCase("Unpublish"))
			{
				unpublishBtn.click();
				sleep(3000);
				clickYesBtn.click();
				sleep(3000);
				clickOKBtn.click();
				sleep(3000);
				clickEditButton.click();
				
			}
			else
			{
			sleep(3000);
			clickEditButton.click();
			}
			sleep(3000);
			overviewTabClick.click();
			sleep(3000);
			addOverview.clear();
			sleep(3000);
			addOverview.sendKeys(editText);
			sleep(3000);
			discardBtnAfterEdit.click();
			sleep(3000);
			System.out.println("Discarded the edited things");
			
			}
			catch(Exception e)
			{
				System.out.println("No such topic name is present");
			}
			
		}
		
		
		public void deleteNugget(String topicName,String nuggetName)
		{
			implicitWait(40);
			searchTopicBox.sendKeys(topicName);
			
			
			String name = clickTopicName.getText();
			
			if(topicName.equalsIgnoreCase(name))
			{
				clickTopicName.click();
				System.out.println(name + "is clicked");
			}
			else
			{
				System.out.println("Invalid Topic");
			}
			
			
			String text = unpublishBtn.getText();
			if(text.equalsIgnoreCase("Unpublish"))
			{
				unpublishBtn.click();
				sleep(3000);
				clickYesBtn.click();
				sleep(3000);
				clickOKBtn.click();
				sleep(3000);
				clickEditButton.click();
				
			}
			else
			{
			sleep(3000);
			clickEditButton.click();
			}
			List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div/div[2]/div/uib-accordion/div/div/div[1]/h4/a/span/div/input"));	
			
			 for (int i=0; i<element.size();i++)
			 {
				 //driver.navigate().refresh();
				 sleep(7000);
				 
				 //System.out.println(element.get(i).getAttribute("value"));
				 if(element.get(i).getAttribute("value").equalsIgnoreCase(nuggetName))
				 {
					 System.out.println("Inside for loop");
					 sleep(5000);
					 driver.findElement(By.xpath("//div[@id='content']/div[2]/div[3]/div/div/div[2]/div/uib-accordion/div/div["+(i+1)+"]/div[2]/div/div/div[1]/button")).click();
					 sleep(5000);
					saveBtnAfterEdit.click();
					clickYesBtn.click();
					 
					System.out.println("exiting for loop");
					break;
				 }
			
			 }
			
			
			
			
			
		}
		
		
		
		public void removeObject(String topicName) throws InterruptedException
		{
		searchTopicBox.sendKeys(topicName);
		String name = clickTopicName.getText();
		
		if(topicName.equalsIgnoreCase(name))
		{
			clickTopicName.click();
			System.out.println(name + "is clicked");
		}
		else
		{
			System.out.println("Invalid Topic");
		}
		
		String text = unpublishBtn.getText();
		if(text.equalsIgnoreCase("Unpublish"))
		{
			unpublishBtn.click();
			sleep(3000);
			clickYesBtn.click();
			sleep(3000);
			clickOKBtn.click();
			sleep(3000);
			clickEditButton.click();
		editTopic();

		}
		else
		{
		Thread.sleep(2000);
		clickEditButton.click();
		editTopic();
		}

		}

		public   void editTopic() throws InterruptedException
		{
			try {
			   int nuggetCount=10;
			        List<WebElement> objName=driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div/div[2]/div/uib-accordion/div/div/div/div/div/div/div/button/span"));
			        int objectCount=objName.size();
			        System.out.println("the total number of  delete buttons are "+objectCount);
			        for(int i=1;i<=objectCount;i++)
			        {
			        for(int j=1;j<=nuggetCount;j++) {
			        if(i==2&&j==2)
			        {
			        WebElement ele=driver.findElement(By.xpath("//*[@id='content']/div[2]/div[3]/div/div/div[2]/div/uib-accordion/div/div["+i+"]/div[2]/div/div/div["+j+"]/div/button/span"));
			        ele.click();
			        saveBtnAfterEdit.click();
			        clickYesBtn.click();
			        }
			        }
			        }
			}catch(NoSuchElementException e)
			{
			System.out.println("there is no eleemnt present");
			}
		}

		
		
		
		
		
			
			
			
		

		


}
