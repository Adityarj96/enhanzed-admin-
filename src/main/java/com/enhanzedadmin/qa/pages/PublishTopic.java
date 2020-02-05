package com.enhanzedadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class PublishTopic extends Testbaseadmin {
	
	//xpath for clicking the content
			@FindBy(xpath="//z[contains(text(),'CONTENT')]")
			private WebElement content;

			//xpath for manage topics
			@FindBy(xpath="//z[contains(text(),'Manage Topics')]")
			private WebElement manageTopics;
			
			//xpath for adding overview
			@FindBy(xpath="//input[@name='searchName']")
			private WebElement searchTopicBox;

			
			//xpath for adding overview
			@FindBy(xpath="//a[@ng-click='topicdetail(row)']")
			private WebElement clickTopicName;
			
			//click unpublish button
			@FindBy(xpath="//div[@id=\"content\"]/div[1]/button[1]")
			private WebElement publishOrUnpublishBtn;
			
			//click unpublish button
			@FindBy(xpath="//button[contains(text(),' Make Topic available on cloudsearch')]")
			private WebElement cloudSearchBtn;
			
			//click unpublish button
			@FindBy(xpath="//button[contains(text(),' Make Topic available only for assigning')]")
			private WebElement assignOnlyBtn;
			
			//click OK button
			@FindBy(xpath="//button[contains(text(),'OK')]")
			private WebElement clickOKBtn;
			
			public PublishTopic() 
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
			
			//publish the topic on cloud search
			public void publishTopicCloudSearch(String topicName)
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
				
				String text = publishOrUnpublishBtn.getText();
				if(text.equalsIgnoreCase("Publish"))
				{
					publishOrUnpublishBtn.click();
					sleep(3000);
					cloudSearchBtn.click();
					sleep(3000);
					clickOKBtn.click();
					sleep(3000);
					System.out.println("Topic is published successfully");
					
					
				}
				else
				{
				System.out.println("Topic is already published");
				}
			}
			
			//publish the topic only for assigned users
			public void publishTopicAssignOnly(String topicName)
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
				
				String text = publishOrUnpublishBtn.getText();
				if(text.equalsIgnoreCase("Publish"))
				{
					publishOrUnpublishBtn.click();
					sleep(3000);
					assignOnlyBtn.click();
					sleep(3000);
					clickOKBtn.click();
					sleep(3000);
					System.out.println("Topic is published successfully");
					
				}
				else
				{
				System.out.println("Topic is already published");
				}
			}
			

}
