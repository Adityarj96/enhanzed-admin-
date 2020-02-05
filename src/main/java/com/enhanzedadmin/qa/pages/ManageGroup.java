package com.enhanzedadmin.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class ManageGroup extends Testbaseadmin {
	
	CreateUser user;
	
	 //page factory for creating groups
	   //check for users and groups
	@FindBy(xpath="//z[contains(text(),'USER & GROUPS ')]")
	public  WebElement usersnadgroups;
	
	//type email
	@FindBy(xpath="//input[contains(@id,'email')]")
	public  WebElement email;

	//click on manage groups
	@FindBy(xpath="//z[contains(text(),'Manage Groups')]")
	public WebElement manageGroup;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/button[2]")
	public WebElement addBtnEmptyUser;

	//click create group
	@FindBy(xpath="//button[@class='adduserbutton']")
	public WebElement creategroupbutton;

	//click create group
	@FindBy(xpath="//input[@name='tdescription']")
	public WebElement groupname;

	//click add button
	@FindBy(xpath="//button[@class='button1']")
	public  WebElement clickadd;
	
	@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	public  WebElement clickok;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	public  WebElement clickokpopup;
	
	
	//click pagination next
    @FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/div[9]/ul")
    public WebElement pagination;
    
    @FindBy(xpath="//p[contains(@class,'mgpara ng-binding')]")
    public  WebElement groupnametext;
    
    @FindBy(xpath="//input[@placeholder='Search Groups']")
   public WebElement searchgroup;
    
    @FindBy(xpath="//input[@placeholder='Search Users']")
    WebElement searchUsers;
    
    
    @FindBy(xpath="//html/body/div[3]/div/div/div[2]/div[1]/div/div/p[1]")
    public WebElement creategrouperrormessage ;
    
    @FindBy(xpath="//a[contains(text(),'Users & Groups')]")
    public WebElement userandgroups;
    
    @FindBy(xpath="//li[contains(text(),'Manage Groups')]")
    public WebElement managegroups;
    
	@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
	public WebElement addBtn;
    
    @FindBy(xpath="//p[contains(@class,'mgpara1 ng-binding')]")
	public WebElement numberofusers;
    
    @FindBy(xpath="//p[contains(@class,'mgpara ng-binding')]")
    WebElement groupNameText;
    
    @FindBy(xpath="//button[@ng-click='deletegroup()']")
	public WebElement deleteGroupBtn;
    
    @FindBy(xpath="//button[@class='swal2-confirm button1']")
	WebElement clickYesBtn;
    
    @FindBy(xpath="//div[2]/div/div[3]/button[1]")
	private WebElement clickOK;
    
    @FindBy(xpath="//span[contains(@class,'swal2-x-mark swal2-animate-x-mark')]")
	 WebElement errormessage;
    
    @FindBy(xpath="//div[contains(@id,'swal2-content')]")
    public WebElement errormessagetext;
    
    @FindBy(xpath="//p[contains(text(),'APAC Sales Team')]")
    public  WebElement groupapac;
    
    @FindBy(xpath="//div[contains(@class,'swal2-validationerror')]")
    public  WebElement emptygrouperror;
    
    @FindBy(xpath="//div[@ng-show='filterData.length!=0']")
	private WebElement groupsPresent;
    
    //click on add user
  	@FindBy(xpath="//button[contains(@class,'button1 ng-scope')]")
  	public  WebElement addUser;
  	
  	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/button[2]")
  	public  WebElement addEmptyuserUser;
  	
  	
  	@FindBy(xpath="//button[contains(text(),'Remove')]")
	private WebElement removeUserBtn;
  	
  	@FindBy(xpath="//button[contains(@class,'button2 footerbtn2')]")
	private WebElement cancelbuttoncreategroupopup;
  	
  	@FindBy(xpath="//div[contains(text(),'No Data')]")
	public WebElement nodata;
  	
  	@FindBy(xpath="//input[contains(@name,'UNAME')]")
	public WebElement usernamefield;
	
	@FindBy(xpath="//input[contains(@name,'EMAILID')]")
	public WebElement emailid;
	
	@FindBy(xpath="//input[contains(@name,'LA')]")
	public WebElement userstaus;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")
	public WebElement adduserbtn;
	
	@FindBy(xpath="//thead[contains(@class,'ng-scope')]")
	public WebElement table;
	
    
	public  ManageGroup()  {
	super();
	PageFactory.initElements(driver,this);
	user=new CreateUser();
	 }
	   
	   
	   public void clickUsersAndGroups()
		{
			usersnadgroups.click();
		}
		
		public void clickManageGroups()
		{
			manageGroup.click();
		}
		
		public boolean checkcreategroup()
		{
			return creategroupbutton.isDisplayed();
		}
		
		public boolean checksearchgroup()
		{
			return searchgroup.isDisplayed();
		}
		
		public boolean checkAllgroups()
		{
			return groupsPresent.isDisplayed();
		}
		
		public boolean checkcreategrouptextbox()
		{
			sleep(3000);
			return groupname.isDisplayed();
		}	
		
		public boolean checkgroupaddbutton()
		{
			return clickadd.isDisplayed();
		}
		
		public boolean checkcancelgrouppopup()
		{
			return cancelbuttoncreategroupopup.isDisplayed();
		}
		
		
	
		 
	 //create new group
	public void createNewGroup(String namegroup)
	{
	usersnadgroups.click();
	manageGroup.click();
	creategroupbutton.click();

	groupname.sendKeys(namegroup);
    
	clickadd.click();
	
	clickok.click();
	sleep(3000);
	
	searchgroup.sendKeys(namegroup);

	Assert.assertEquals(groupnametext.getText(), namegroup);
	}
	
	
	public void checkGroupUI(String namegroup )
	{
		searchgroup.sendKeys(namegroup);
		
	    if(groupnametext.getText().contains(namegroup))
	    {
	    	groupnametext.click();
	    }
	}
	
	
	public boolean checkbreadcrumb()
	{
		return userandgroups.isDisplayed();	
	}
	
	public boolean  checkbreadcrumbmanagegroup()
	{
		return managegroups.isDisplayed();
	}
	
	public  boolean checkCreateGroupButton()
	{
		return creategroupbutton.isDisplayed();
	}
	
	
	
	public  boolean checkPagination()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		return	pagination.isDisplayed();
	}
	
	public void deleteGroup(String groupName)throws InterruptedException
	{
		searchgroup.sendKeys(groupName);
		
		String numberoffusers=numberofusers.getText();
		String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
		
		if(Integer.parseInt(usernumber)==0)
		{
		  	groupNameText.click();
		  	deleteGroupBtn.click();
			clickYesBtn.click();
		}
		else
		{		   
			System.out.println("There are users present in the group");
		}
		
}
	
	public void addUserToGroup(String groupName,String emailId) throws InterruptedException
	{
		searchgroup.sendKeys(groupName);
		String name = groupnametext.getText();
		String numberoffusers=numberofusers.getText();
		String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
		System.out.println(usernumber);
		if(groupName.equalsIgnoreCase(name))
		{
			if(Integer.parseInt(usernumber)==0)
			{
			groupnametext.click();
			sleep(3000);
			addEmptyuserUser.click();
			email.sendKeys(emailId);
			addBtn.click();
			sleep(2000);
			clickOK.click();
			System.out.println("Yes");
				
			}
			
			else if(Integer.parseInt(usernumber)>0)
			{
				groupnametext.click();
				sleep(3000);
				adduserbtn.click();
				email.sendKeys(emailId);
				addBtn.click();
				if(errormessagetext.getText().contains("User already exists in the group"))
				{
					sleep(3000);
					clickOK.click();
					
				}
				
				else if(errormessagetext.getText().contains("Not able to add the user to group. Please contact production support team"))
				{
					clickOK.click();
					Assert.assertEquals(errormessagetext.getText(),"Not able to add the user to group. Please contact production support team");
				}
				else if(errormessagetext.getText().contains("User successfully added to this group"))
				{
					sleep(3000);
					clickOK.click();
				}
				
				
				System.out.println("No");
			}
	}
	}
			
			
		
	
	public void removeUserGroup(String groupName,String emailId)
	{
		searchgroup.sendKeys(groupName);
		String name = groupnametext.getText();
		
		String numberoffusers=numberofusers.getText();
		String usernumber=numberoffusers.replaceAll("[^-?0-9]", " ").trim();
		
		
		 if(groupName.equalsIgnoreCase(name) && (usernumber=="0" || Integer.parseInt(usernumber)==0))
		{
			 System.out.println("The user has been deleted");
		}
		 
		 else if(groupName.equalsIgnoreCase(name) && Integer.parseInt(usernumber)>=0)
		 {
			 
			groupnametext.click();
			emailid.sendKeys(emailId);
			List<WebElement> results = driver.findElements(By.cssSelector("table>tbody>tr"));
			for (int i = 0; i < results.size(); i++)
			{
				 if(results.get(i).getText().contains(emailId))
				{
					 sleep(3000);
					 removeUserBtn.click();
					 sleep(3000);
						clickok.click();
						
						clickokpopup.click();
				}
			}
			
		    }
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

