package com.enhanzedadmin.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.concurrent.TimeUnit;

//import com.enhamzed.qa.util.Xls_Reader;
import com.enhanzedadmin.qa.base.Testbaseadmin;

public class UserReports extends Testbaseadmin {
	
	  //page factory for reports

	@FindBy(xpath="//z[contains(text(),'REPORTS')]")
	public WebElement reports;

	@FindBy(xpath="//z[contains(text(),'Users Reports')]")
	WebElement userreports;

	@FindBy(xpath="//z[contains(text(),'Content Reports')]")
	WebElement contentreports;

	@FindBy(xpath="//z[contains(text(),'Group Reports')]")
	WebElement groupreports;

	@FindBy(xpath="//div[@class='ubox1']//p[@class='uboxp2 ng-binding']")
	WebElement totalusers;

	@FindBy(xpath="//div[@class='ubox4']//p[@class='uboxp2 ng-binding']")
	WebElement totalactive;

	@FindBy(xpath="//div[@class='box2']")
	WebElement usersplatform;

	@FindBy(xpath="//a[normalize-space(.)='»']")
	WebElement forwardbutton;

	@FindBy(xpath="//a[@ng-switch-when='last']")
	WebElement lastpage;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][1]")
	WebElement malegraph;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][2]")
	WebElement femalegraph;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-slice')][3]")
	WebElement unknowngraph;

	@FindBy(xpath="//*[name()='text' and contains(text(),'Male')]")
	WebElement malepie;

	@FindBy(xpath="//*[name()='text' and contains(text(),'Female')]")
	WebElement femalepie;

	@FindBy(xpath="//*[name()='text' and contains(text(),'Unknown')]")
	WebElement unkwnonpie;

	@FindBy(xpath="//input[contains(@name,'EMAILID')]")
	WebElement searchtextbox;
	
	@FindBy(xpath="//input[contains(@name,'TN')]")
	WebElement topicNameSearch;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[4]/div[2]/table/tbody/tr[1]/td[2]/a")
	WebElement subscribedTopic;
	

	@FindBy(xpath="//ul[contains(@class,'pagination ng-table-pagination ng-scope')]")
	WebElement   pagination;

	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement clickuser;

	@FindBy(xpath="//a[contains(text(),'User Reports')]")
	WebElement clickbreadcrumb;

	@FindBy(xpath="//a[contains(text(),'CERTIFICATES')]")
	WebElement certificates;

	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/div[1]/button/span")
	WebElement closebutton;

	@FindBy(xpath="//td[contains(text(),'No Data')]")
	WebElement nodata;

	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/p/span")
	WebElement emailid;
	   
	@FindBy(css="table>tbody>tr")
	WebElement row ;

	@FindBy(xpath="//*[@id='content']/div/div[3]")
	WebElement certificate ;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-group nv-series-0')]")
	WebElement topic1;
	   
	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-group nv-series-1')]")
	WebElement topic2;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-group nv-series-2')]")
	WebElement topic3;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-group nv-series-3')]")
	WebElement topic4;

	@FindBy(xpath="//*[name()='g' and contains(@class,'nv-group nv-series-4')]")
	WebElement topic5;

	@FindBy(xpath="//td[contains(@role,'button')]")
	WebElement contenttopic;
	
	@FindBy(css="table>tbody>tr")
	List<WebElement> searchresults;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement names;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[4]/div[2]/table/tbody/tr[1]/td[2]/a")
	WebElement subscribedTopicNames;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[3]/div[1]/p[2]")
	WebElement lastActive;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[3]/div[2]/p[2]")
	WebElement topicsNotStarted;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[3]/div[3]/p[2]")
	WebElement topicsInProgress;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[3]/div[4]/p[2]")
	WebElement topicsCompleted;
	
	@FindBy(xpath="/html/body/div/div[2]/div[3]/div/div[3]/div[5]/p[2]")
	WebElement certificatesClaimed;
	
	@FindBy(xpath="//a[contains(text(),'»')]")
	WebElement forwardbuttonclick;
	

	public UserReports()  {
	super();
	PageFactory.initElements(driver,this);
	}

	//methods for clicking reports dropdown
	public void clickReports()
	{
	reports.click();
	}

	public void clickUserReports()
	{
	userreports.click();
	}

	public void clickContentReports()
	{
	contentreports.click();
	}

	public void clickGroupReport()
	{
	groupreports.click();
	}

	public boolean checkTotalUsers()
	{
	return totalusers.isDisplayed();
	}

	public boolean checkTotalActiveUsers()
	{
	return totalactive.isDisplayed();
	}

	public boolean checkUsersbyPlatform()
	{
	return usersplatform.isDisplayed();
	}
	
	
	public boolean checkLastActive()
	{
		return lastActive.isDisplayed();
	}
	
	public boolean checkTopicNotStarted()
	{
		return topicsNotStarted.isDisplayed();
	}
	
	public boolean checkTopicsInProgress()
	{
		return topicsInProgress.isDisplayed();
	}
	
	public boolean checkTopicsCompleted()
	{
		return topicsCompleted.isDisplayed();
	}
	
	public boolean checkCertificates()
	{
		return certificatesClaimed.isDisplayed();
	}
	
	public void checkMouseHover() throws InterruptedException
	{
	Actions action = new Actions(driver);
	action.moveToElement(malegraph).build().perform();
	System.out.println(malegraph.getText());

	Thread.sleep(3000);

	action.moveToElement(femalegraph).build().perform();
	System.out.println(femalegraph.getText());


	Thread.sleep(2000);
	action.moveToElement(unknowngraph).build().perform();
	System.out.println( unknowngraph.getText());

	}

	public void clickTestReports() throws InterruptedException
	{
	malepie.click();
	Thread.sleep(2000);
	malepie.click();

	femalepie.click();
	Thread.sleep(2000);
	femalepie.click();

	unkwnonpie.click();
	Thread.sleep(2000);
	unkwnonpie.click();
	}

	public void searchUsers(String emailId,String topicName)
	{
	searchtextbox.sendKeys(emailId);
	
	for (int i = 0; i < searchresults.size(); i++)
	{
		if(searchresults.get(i).getText().contains("No Data"))
		{
        	System.out.println("No such user is present in the  group");
		}
		
		if(searchresults.get(i).getText().contains(emailId))
		{
			names.click();
			sleep(3000);
			topicNameSearch.sendKeys(topicName);
			
			if(searchresults.get(i).getText().contains("No Data"))
		{
				System.out.println("No such topic is subscribed by the user");			
		}
			else if(searchresults.get(i).getText().contains(topicName))
			{
				subscribedTopicNames.click(); 
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
			}
	}
	}
	}
	
	public void checkUI(String emailId)
	{
		searchtextbox.sendKeys(emailId);
		for (int i = 0; i < searchresults.size(); i++)
		{
			if(searchresults.get(i).getText().contains("No Data"))
			{
				System.out.println("No such user is present in the  group");
			}
			
			if(searchresults.get(i).getText().contains(emailId))
			{
				names.click(); 
				SoftAssert sa=new SoftAssert();
				  sa.assertTrue(checkLastActive(),"The last active is not displayed");
				  sa.assertTrue(checkTopicNotStarted(),"The topic not started is not displayed");
				  sa.assertTrue(checkTopicsInProgress(),"The topic in progress is not displayed");
				  sa.assertTrue(checkTopicsCompleted(),"The topics completed is not displayed");
				  sa.assertTrue(checkCertificates(),"The certificates is not displayed");
				  sa.assertAll();
			}
		}
		
	}
	
	public void checkPagination()
	{
		for(int i=1;i<=37;i++)
		{
			forwardbuttonclick.click();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	



	public void checkContentReport(String topicsearch ) throws InterruptedException
	{
	contentreports.click();


	Actions action = new Actions(driver);

	Thread.sleep(3000);
	action.moveToElement(topic1).build().perform();


	Thread.sleep(3000);

	action.moveToElement(topic2).build().perform();



	Thread.sleep(2000);
	action.moveToElement(topic3).build().perform();

	Thread.sleep(2000);
	action.moveToElement(topic4).build().perform();

	Thread.sleep(2000);
	action.moveToElement(topic5).build().perform();
	String paginationsize=driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div[2]/div[2]/div/div/div/ul/li[10]/a")).getText();
	int pgsize=Integer.parseInt(paginationsize);
	       
	for(int i=1;i<=pgsize;i++)
	{
	forwardbutton.click();
	}

	   searchtextbox.sendKeys(topicsearch);
	   WebElement row= driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div[2]/div[2]/table/tbody/tr/td"));
	if(row.getText().contains("No Data"))
	{
	System.out.println("This topic has no data");
	}

	else if(contenttopic.getText().contains(topicsearch))
	{
	System.out.println("The search result is seen ");
	subscribedTopic.click();
	}
	}


}
