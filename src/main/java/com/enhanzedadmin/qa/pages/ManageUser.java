package com.enhanzedadmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class ManageUser extends Testbaseadmin
{
	
	//pagefactory for create and search users
	
	//check for users and groups
	@FindBy(xpath="//z[contains(text(),'USER & GROUPS ')]")
	private WebElement usersAndGroups;
	
	//click on manage users
	@FindBy(xpath="//z[contains(text(),'Manage Users')]")
	private WebElement manageUsers;
	
	//click on create user
	@FindBy(xpath="//button[contains(@class,'adduserbutton')]")
	private WebElement clickCreateUser;
	
	//type name
	@FindBy(xpath="//input[contains(@placeholder,'Name')]") 
	public WebElement typeName;
	
	//type email
	@FindBy(xpath="//input[contains(@placeholder,'Email')]")
	public  WebElement email;
	
	//type contact number
	@FindBy(xpath="//input[contains(@placeholder,'Contact No')]")
	public WebElement contactNumber;
	
	//select gender
	@FindBy(xpath="//select[@ng-model='ugender']/option[@value='2']")
	private WebElement selectGender;
	
	//type address
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement typeAddress;
	
	//select user role
	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/div[1]/div/div[3]/div[6]/select/option[2]")
	public  WebElement userRole;
	
	//select user group 
	@FindBy(xpath="//body[contains(@class,'modal-open')]//div[contains(@class,'modal fade ng-isolate-scope addusermodal in')]//div[contains(@class,'modal-dialog')]//div[contains(@class,'modal-content')]//div[contains(@class,'modal-content ng-scope')]//div[contains(@class,'modal-body')]//div//div[contains(@class,'userrightdata')]//div[4]//select[1]")
	WebElement genderClick;

	@FindBy(xpath="//option[contains(@value,'0')]")
	public WebElement genderSelect;

	@FindBy(xpath="//body[contains(@class,'modal-open')]//div[contains(@class,'modal fade ng-isolate-scope addusermodal in')]//div[contains(@class,'modal-dialog')]//div[contains(@class,'modal-content')]//div[contains(@class,'modal-content ng-scope')]//div[contains(@class,'modal-body')]//div//div[contains(@class,'userrightdata')]//div[6]//select[1]")
	WebElement roleClick;

	@FindBy(xpath="//option[contains(@value,'User')]")
	WebElement roleSelect;
	
	@FindBy(xpath="//select[contains(@ng-model,'groupid')]")
	 WebElement groupdropdown;
	
	//save button
	@FindBy(xpath="//button[@class='button1']")
	public WebElement save;
	
	//cancel button
	@FindBy(xpath="//button[@class='button2 footerbtn2']")
	private WebElement cancel;
	
	@FindBy(xpath="//div[@id='swal2-content']")
	public WebElement error;
	
	@FindBy(xpath="//div[@class='swal2-header']")
	public WebElement alertText;
	
	@FindBy(xpath="//p[@class='ng-scope']")
	public WebElement errorMessage;
	
	//ok button
	@FindBy(xpath="//button[@class='swal2-confirm button1']")
	public WebElement okButton;
	
	@FindBy(xpath="//button[contains(@class,'button2 footerbtn2')]")
	public WebElement cancelButton;
	
	@FindBy(xpath="//input[@placeholder='Search Users']")
	public WebElement searchuser;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[1]")
	public WebElement nodata;
	
	@FindBy(xpath="//a[contains(text(),'»')]")
	public WebElement forwrd;
	
	
		
	public ManageUser()  {
		super();
	PageFactory.initElements(driver,this);
	}
	
	public void clickUsersAndGroups()
	{
		usersAndGroups.click();
	}
	
	public void clickManageUsers()
	{
		manageUsers.click();
	}
	
	public void clickCreateUser()
	{
		clickCreateUser.click();
	}
	public void clickGender()
	{
		genderClick.click();
		sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div[3]/div[4]/select/option[4]")).click();		
	}
	
    //method for creating users 
	public void createNewUser(String name,String uemail,String contact,String address) throws InterruptedException
	{
		typeName.sendKeys(name);
		email.sendKeys(uemail);
		contactNumber.sendKeys(contact);
		clickGender();
		typeAddress.sendKeys(address);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div[3]/div[6]/select/option[2]"));
		roleSelect.click();
		save.click();
		
		
			if(alertText.getText().equalsIgnoreCase("oooops!"))
			{
				 System.out.println(error.getText());
				 Assert.assertEquals(error.getText(),"User already exist!");
			}
			else
			{
				System.out.println(error.getText());
				 Assert.assertEquals(error.getText(),"New User "+name+" created Successfully");
			}
			okButton.click();
		
	
}
	
	public void cancelNewCreateUser()
	{
		typeName.sendKeys("test");
		email.sendKeys("test234@gmail.com");
		contactNumber.sendKeys("7894561230");
		clickGender();
		typeAddress.sendKeys("Test address");
		roleClick.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div[3]/div[6]/select/option[2]"));
		roleSelect.click();
		cancelButton.click();
		
		
   		searchuser.sendKeys("test234@gmail.com");
   	    Assert.assertEquals(nodata.getText(),"No Data"); 
   		
	}
	
	public boolean checkNameField()
	{
		sleep(2000);
		return typeName.isDisplayed();
	}
	
	public boolean checkEmailField()
	{
		return email.isDisplayed();
	}
	
	public boolean checkContactNumber()
	{
		return contactNumber.isDisplayed();
	}
    
	public boolean checkGender()
	{
		return genderClick.isDisplayed();
	}
	
	public boolean checkAddress()
	{
		return typeAddress.isDisplayed();
	}
	
	public boolean checkRole()
	{
		return roleClick.isDisplayed();
	}
	
	public boolean checkGroup()
	{
		return groupdropdown.isDisplayed();
	}
	
	public boolean checkSaveButton()
	{
		return save.isDisplayed();
	}
	
	public boolean checkCancelButton()
	{
		return cancelButton.isDisplayed();
	}
	
	public void checkPagination()
	{
		for(int i=1;i<=23;i++)
		{
			forwrd.click();
		}
	}
	
	public void checkbreadcrumb()
	{
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Users & Groups");
		alist.add("Manage Users");
		
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
