package com.enhanzedadmin.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;


/**
 * This is the page factory for content: manage content page 
 * @author Aditya r javali
 * 
 */

public class ContentManageContent extends Testbaseadmin
{
	String topictileaudio="";
	String topicName;
	
	public String path1="C:\\Users\\vitnita enhanzed\\Desktop\\file_example_MP3_700KB.mp3";
	public String path2="C:\\Users\\vitnita enhanzed\\Desktop\\topicwhite-1.png";
	public String path3="C:\\Users\\vitnita enhanzed\\Desktop\\CR018-2-7.html";
	public String path4="C:\\Users\\vitnita enhanzed\\Desktop\\SampleVideo_1280x720_1mb.mp4";
	public String path5="C:\\Users\\vitnita enhanzed\\Desktop\\xpath cheat sheet.pdf";
	
	
	//element content 
	@FindBy(xpath="//z[contains(text(),'CONTENT')]")
	public  WebElement content;
	
	//element manage content
	@FindBy(xpath="//z[contains(text(),'Manage Content')]")
	public  WebElement manageContent;
	
	//element add topic 
	@FindBy(xpath="//button[contains(text(),' Add Topic ')]")
	public  WebElement addTopic;
	
	//element add button pop up 
	@FindBy(xpath="//button[contains(@class,'button1') and contains(text(),' Add ')]")
	public  WebElement addTopicPopUp;
	
	//element cancel button 
	@FindBy(xpath="//button[contains(@class,'button2 footerbtn2') and contains(text(),'Cancel')]")
	public  WebElement addCancelPopUp;
	
	//error message when the topic name is empty 
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div[1]/p[1]")
	public  WebElement topicTitleEmptymsg;
	
	//error message when the topic image is not present
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/div/p")
	public  WebElement topicImageErrorMessage;
	
	//topic add image button
	@FindBy(xpath="//div[contains(@name,'categoryfile')]")
	public  WebElement topicAddimage;
	
	//topic title text box
	@FindBy(xpath="//input[contains(@name,'cname')]")
	public  WebElement topicTitletextBox;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div[1]")
	public  WebElement duplicateTopicNameErrorMessage;
	
	@FindBy(xpath="//button[contains(text(),'Browse')]")
	public WebElement browseForFile;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[1]")
	public WebElement addAudio;

	@FindBy(xpath="//input[contains(@name,'tdescription')]")
	public WebElement addTitle;
	
	@FindBy(xpath="//div[contains(@class,'ql-editor ql-blank')]")
	public WebElement addHTMLContent;
	
	
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement addDescription;
	
	@FindBy(xpath="//button[contains(@class,'button1') and contains(text(),'Create HTML')]")
	public WebElement createHTML;
	
	
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement addVideodesc;
	
	@FindBy(xpath="//input[@name='nduration']")
	public WebElement addDuration;
	
	@FindBy(xpath="//span[contains(text(),'All medical topics')]")
	public WebElement category;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement savebutton;
	
	@FindBy(xpath="//input[contains(@name,'searchName')]")
	public WebElement searchTextbox;
	
	@FindBy(css="table>tbody")
	public List<WebElement> searchResults;
	
	@FindBy(css="table>tbody>tr>td>div>div>h4>div>a")
	public WebElement topicname;
	
	@FindBy(xpath="//button[contains(text(),'Add Object')]")
	public WebElement addObject;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
	public WebElement audiotitleerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/p[1]")
	public WebElement audiodescriptionerrormsg;
    
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/p[1]")
	public WebElement audiodurationemptymsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
	public WebElement fileuploaderrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[2]")
	public WebElement addNarative;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[1]")
	public WebElement createhtml;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/p[1]")
	public WebElement htmltitleerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/p")
	public WebElement htmlcontenterrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[4]/p[1]")
	public WebElement htmlcategoryerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[2]")
	public WebElement upload_html;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/p")
	public WebElement uploadhtmlerror;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[3]")
	public WebElement addPdf;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
	public WebElement pdftitleerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
	public WebElement pdfuploaderrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[5]/p[1]")
	public WebElement pdfcategoryerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[5]")
	public WebElement addInteractivity;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[6]")
	public WebElement addVideo;

	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
	public WebElement videotitleerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/p[1]")
	public WebElement videodescriptionerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/p[1]")
	public WebElement videodurationerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
	public WebElement videofileerrormsg;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[4]")
	public WebElement addQuiz;
	
	@FindBy(xpath="//button[contains(text(),'Formative Quiz With Feedback')]")
	public WebElement formativequizwithfeedback;
	
	@FindBy(xpath="//button[contains(@ng-click,'addques()')]")
	public WebElement addquestion;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div/p[1]")
	public WebElement quizTitleErrorMessage;
	
	
	public ContentManageContent() 
	{
		super();
	PageFactory.initElements(driver,this);
	}
	
	
	public void clickContent()
	{
		content.click();	
	}
	
	public void clickManageContent()
	{
		manageContent.click();
	}
	
	public void clickAddTopic()
	{
		addTopic.click();
	}
	
	public void clickAddPopUP()
	{
		sleep(2000);
		addTopicPopUp.click();
	}
	
	public void clickOnTopicName(String topicName)
	{
		sleep(5000);
		driver.findElement(By.xpath("//a[.='"+topicName+"']")).click();
	}
	
	public void clickOnObjectName(String index) throws AWTException, InterruptedException
	{
		sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button["+index+"]")).click();
		if(index.contains("1"))
		{
			addAudio();
		}
		
		if(index.contains("2"))
		{
			addNarativeObject();
		}
		
		if(index.contains("3"))
		{
			addPdfobject();
		}
		
		if(index.contains("6"))
		{
			addVideoObject();
		}
	}
	
	public void addAudioObject()
	{
		sleep(3000);
		addAudio.click();
	}
	
	public void clicksavebutton()
	{
		sleep(3000);
		savebutton.click();
	}
	
	public void addNarative()
	{
		sleep(3000);
		addNarative.click();
	}
	
	public void addPdf()
	{
		sleep(3000);
		addPdf.click();
	}
	
	public void addInteractivity()
	{
		sleep(3000);
		addInteractivity.click();
	}
	
	public void addVideo()
	{
		sleep(3000);
		addVideo.click();
	}
	
	public void addQuiz()
	{
		sleep(3000);
		addQuiz.click();
	}
	
	
	//add audio file
	public void addFile(String path) throws AWTException, InterruptedException
	{
		 sleep(3000);
		 browseForFile.click();
		 sleep(5000);
		 //add topic image
		 StringSelection sel = new StringSelection(path);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 Robot robot = new Robot();    
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			// Release Enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);      
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
	}
	
	public void addTopicImage(String path) throws AWTException, InterruptedException
	{
		sleep(3000);
		topicAddimage.click();
		 sleep(5000);
		 //add topic image
		 StringSelection sel = new StringSelection(path);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 Robot robot = new Robot();    
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			// Release Enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);      
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
	}
	
	public void addAudio() throws AWTException, InterruptedException
	{
		
		sleep(3000);
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		addDescription.sendKeys("Test ttile description");
		addDuration.sendKeys("5");
		addFile(path1);
		sleep(3000);
		clicksavebutton();
		sleep(4000);
	}
	
	public void addNarativeObject()
	{
		sleep(3000);
		createHTML.click();
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		addHTMLContent.sendKeys(RandomStringUtils.randomAlphabetic(100));
		sleep(3000);
		clicksavebutton();
		sleep(4000);		
	}
	
	public void addPdfobject() throws AWTException, InterruptedException
	{
		sleep(3000);
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		addFile(path5);
		clicksavebutton();
		sleep(4000);	
	}
	
	public void addVideoObject() throws AWTException, InterruptedException
	{
		sleep(3000);
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10)); 	
		addDescription.sendKeys("Test ttile description");
		addDuration.sendKeys("5");
		addFile(path4);
		clicksavebutton();
		sleep(4000);
		
	}
	
	//add audio object
	public void addObject(String topicName,String index) throws AWTException, InterruptedException
	{
		searchTextbox.sendKeys(topicName);
		for(int i=0;i<=searchResults.size()-1;i++)
		{
			if(searchResults.get(i).getText().contains("No Data"))
			{
				System.out.println("There is no such topic");
			}
			if(searchResults.get(i).getText().contains(topicName))
			{
				clickOnTopicName(topicName);
				addObject.click();
				clickOnObjectName(index);
				
				
				
				
				/*sleep(3000);
				addAudio.click();
				addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));	
				String atitle=addTitle.getAttribute("value");
				topictileaudio=atitle;
				addDescription.sendKeys(RandomStringUtils.randomAlphabetic(20));
				addDuration.sendKeys("5");
				addaudiofile();
				category.click();
				savebutton.click();
				sleep(10000);*/
			}
		}
		
		
		
		/*objtitlesearchtextbox.sendKeys(topictileaudio);
		System.out.println(atitle);
		sleep(4000);
		publish.click();
		okbutton.click();
		sleep(10000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());*/
	}
	
	public void addDummyObject()
	{
		searchTextbox.sendKeys("Manufacturing");
		for(int i=0;i<=searchResults.size()-1;i++)
		{
			if(searchResults.get(i).getText().contains("No Data"))
			{
				System.out.println("There is no such topic");
			}
			
			if(searchResults.get(i).getText().contains("Manufacturing"))
			{
				sleep(5000);
				topicname.click();	
				addObject.click();
	        }
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
}
