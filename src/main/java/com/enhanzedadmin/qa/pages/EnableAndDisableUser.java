package com.enhanzedadmin.qa.pages;

import com.enhanzedadmin.qa.base.Testbaseadmin;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnableAndDisableUser extends Testbaseadmin {
	
	ManageUser user;

	//page factory for selecting the elements

	//element for searching the elements
	@FindBy(xpath="//input[contains(@name,'EMAILID')]")
	WebElement searcTextBox;

	//element for enable and disable user
	@FindBy(xpath="//button[contains(@ng-show,'!editdata')][1]")
	WebElement ablityStatus;

	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr")
	WebElement name;

	@FindBy(xpath="//button[contains(@class,'close')]")
	WebElement  close;

	@FindBy(xpath="//a[normalize-space(.)='»']")
	WebElement  paginationNext;

	@FindBy(xpath="//ul[contains(@class,'pagination ng-table-pagination ng-scope')]")
	WebElement  pagination;

	@FindBy(xpath="//li[contains(@class,'ng-scope')]//a[normalize-space(.)='»']")
	WebElement  clickNextButton;

	@FindBy(xpath="//*[@id='content']/div/div[2]/div[2]/div/div/div/ul/li/a")
	WebElement  getPageSize;

	@FindBy(xpath="//td[contains(text(),'No Data')]")
	WebElement noData  ;

	@FindBy(xpath="//button[contains(@class,'disablebutton userbtn ng-binding')]")
	WebElement userStatus;

	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement yesButtonPopup;

	@FindBy(xpath="//*[@id='swal2-content']")
	WebElement alertMessage;

	@FindBy(xpath="//button[normalize-space(.)='OK']")
	WebElement clickOkButton;

	@FindBy(xpath="//button[contains(@class,'editbutton userbtn')]")
	WebElement editButton;

	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement okButton;
	
	@FindBy(xpath="//button[@ng-click='reset()']")
	WebElement cancelButton;



	public  EnableAndDisableUser()
	{
	super();
	PageFactory.initElements(driver,this);
	user=new ManageUser();
	}


	public void typeUserSearchTextBox(String userName)
	{
	searcTextBox.sendKeys(userName);
	}

	

	//Enable and disable user
	public void checkUserStatus() throws InterruptedException
	{
	    List<WebElement>name=driver.findElements(By.xpath("//*[@id='content']/div/div[2]/div[2]/table/tbody/tr/td[1]/a"));
	    int getName=name.size();
	    System.out.println("Total number of users "+getName);

	    String bfxp="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[";
	    String afxp="]/td[1]/a";

	    for(int i=1;i<=getName;i++)
	    	{
	    		String actualXpath=bfxp+i+afxp;
	    		WebElement ele=driver.findElement(By.xpath(actualXpath));
	    		new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(ele)).click();

	    		Thread.sleep(3000);
	    		userStatus.click();

	    		Thread.sleep(3000);
	    		yesButtonPopup.click();
	   
	    		System.out.println("The user is"+userStatus.getText());
	   
	    		clickOkButton.click();  
	    	}
	}

	//editing user details
	public void editUser() throws InterruptedException
	{
		List<WebElement> name=driver.findElements(By.xpath("//*[@id='content']/div/div[2]/div[2]/table/tbody/tr/td[1]/a"));
		int getName=name.size();
		System.out.println("Total number of users "+getName);

		String bfxp="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[";
		String afxp="]/td[1]/a";

		for(int i=1;i<=getName;i++)
			{
				String actualxpath=bfxp+i+afxp;
				WebElement ele=driver.findElement(By.xpath(actualxpath));
				new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(ele)).click();

				Thread.sleep(3000);
				editButton.click();
	 
				user.typeName.clear();
				user.typeName.sendKeys("test name"+i);
				//  user.contactnumber.sendKeys(Keys.BACK_SPACE);

				user.contactNumber.clear();
				user.contactNumber.sendKeys("7894562580");
	 
				
	 
				user.typeAddress.clear();
	 
				user.typeAddress.sendKeys("medford qa");
	 
				user.save.click();
	 
				okButton.click();
	 
			}
	}
	
	//For cancelling editing changes
	public void cancelChanges()
	{
		List<WebElement> name=driver.findElements(By.xpath("//*[@id='content']/div/div[2]/div[2]/table/tbody/tr/td[1]/a"));
		int getName=name.size();
		System.out.println("Total number of users "+getName);

		String bfxp="//*[@id='content']/div/div[2]/div[2]/table/tbody/tr[";
		String afxp="]/td[1]/a";

		for(int i=1;i<=getName;i++)
			{
				String actualxpath=bfxp+i+afxp;
				WebElement ele=driver.findElement(By.xpath(actualxpath));
				new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(ele)).click();

				sleep(3000);
				editButton.click();
	 
				user.typeName.clear();
				user.typeName.sendKeys("test name"+i);
				//  user.contactnumber.sendKeys(Keys.BACK_SPACE);

				user.contactNumber.clear();
				user.contactNumber.sendKeys("7894562580");
	 
				// user.typeaddress.sendKeys(Keys.BACK_SPACE);
	 
				//  Thread.sleep(3000);
				//user.clickGender();
				// user.typeaddress.sendKeys(Keys.BACK_SPACE);
	 
				user.typeAddress.clear();
	 
				user.typeAddress.sendKeys("medford qa");
	 
				
				cancelButton.click();
	 
			}
	}


}
