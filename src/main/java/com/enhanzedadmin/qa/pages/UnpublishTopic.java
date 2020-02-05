package com.enhanzedadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class UnpublishTopic extends Testbaseadmin {
	
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
	
	//click yes button
	@FindBy(xpath="//button[@class='swal2-confirm button1']")
	private WebElement clickYesBtn;
			
	//click OK button
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement clickOKBtn;
	
	public UnpublishTopic() 
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
	
	//unpublishing the topic
	public void unPublishTopic(String topicName)
	{
		implicitWait(40);
		searchTopicBox.sendKeys(topicName);
		try
		{
		String name = clickTopicName.getText();
		
		if(topicName.equalsIgnoreCase(name))
		{
			clickTopicName.click();
			System.out.println(name + " is clicked");
		}
		else
		{
			System.out.println("Invalid Topic");
		}
		
		String text = publishOrUnpublishBtn.getText();
		if(text.equalsIgnoreCase("Unpublish"))
		{
			publishOrUnpublishBtn.click();
			sleep(3000);
			clickYesBtn.click();
			sleep(3000);
			clickOKBtn.click();
			sleep(3000);
			System.out.println("Topic unpublished successfully");
			
			
		}
		else
		{
		System.out.println("Publish the topic first to unpublish it");
		}
		}
		catch(Exception e)
		{
			System.out.println("No Data");
		}
	
	}

}
