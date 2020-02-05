package com.enhanzedadmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class EngageGroup extends Testbaseadmin {
	
	EngageUser user;
	ManageGroup group;
	
	@FindBy(xpath="//z[contains(text(),'With Groups')]")
	private WebElement withGroupsTab;
	
	
	@FindBy(xpath="//p[contains(@class,'mgpara ng-binding')]")
	private WebElement verifyGroupname;
	
	@FindBy(xpath="//button[@class='mgroup']")
	public WebElement clickGroup;
	
    @FindBy(xpath="//p[contains(@class,'mgpara1 ng-binding')]")
	public WebElement numberofusers;
    
    @FindBy(xpath="//textarea[contains(@ng-model,'mtitle')]")
   	public WebElement groupmessagetitle;
    
    @FindBy(xpath="//textarea[contains(@ng-model,'mdesc')]")
   	public WebElement groupmessagedescription;
    
    @FindBy(xpath="//input[@type='checkbox']")
   	public WebElement grouplinkcheckbox;
    
    @FindBy(xpath="//input[contains(@ng-model,'obj.url')]")
   	public WebElement groupurl;
    
    @FindBy(xpath="//button[contains(@class,'button1')]")
   	public WebElement groupsend;
    
    @FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
   	public WebElement groupokbutton;
    
    @FindBy(xpath="//div[contains(@class,'swal2-icon swal2-error swal2-animate-error-icon')]")
   	public WebElement errorimage;
    
    @FindBy(xpath="//div[contains(@id,'swal2-content')]")
   	public WebElement errormessage;
    
    @FindBy(xpath="//input[contains(@placeholder,'Search Groups')]")
   	public WebElement searchgroup;
    
    
    @FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div[1]/p[1]")
   	public WebElement groupmsgtitleerror;
    
    @FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/p[1]")
   	public WebElement groupmsgdescriptionerror;
    
    @FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div[4]/p[1]")
   	public WebElement groupurlerror; 
    
    
    
    
    
	
	public EngageGroup() 
	{
		super();
	PageFactory.initElements(driver,this);
	user=new EngageUser();
	
	}
	

	public void clickWithGroups()
	{
		withGroupsTab.click();
	}
	
	//Sending notification for single user with engage tab
	public void sendNotificationGroup(String groupName)
	{
		user.clickEngageTab();
		clickWithGroups();
		searchgroup.sendKeys(groupName);
		
		String numberoffusers=numberofusers.getText();
		System.out.println(numberoffusers);
		String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
		
		System.out.println(usernumber);
		
		if(usernumber=="0" || Integer.parseInt(usernumber)==0)
		{
			clickGroup.click();
			Assert.assertEquals(errormessage.getText(), "Group has no users");
			groupokbutton.click();	
		}
		else
		{
			clickGroup.click();
			groupmessagetitle.sendKeys("Test notification");
			groupmessagedescription.sendKeys("This will be test notification");
			sleep(3000);
			grouplinkcheckbox.click();
			groupurl.sendKeys("https://www.codeproject.com");
			groupsend.click();
		}
		
		}
	
	   
	public void checkbreadcrumb()
	{
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Engage");
		alist.add("With Groups");
		
		ArrayList<String> List_Compare = new ArrayList<String>();
		                List<WebElement> New_List = driver.findElements(By.cssSelector("ol.breadcrumb>li"));
		for(WebElement list_item: New_List){
		   List_Compare.add(list_item.getText());
		}
		try{
		   Assert.assertEquals(alist, List_Compare);
		   System.out.println("Equal lists");
		}catch(Throwable e){
		   System.err.println("Lists are not equal. "+e.getMessage());
		}
	}
	}

		
		
		
		
		
		
		
		
		
	


		
		
	
