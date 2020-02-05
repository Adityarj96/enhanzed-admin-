package com.enhanzedadmin.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enhanzedadmin.qa.base.Testbaseadmin;

public class CreateTopic extends Testbaseadmin {

	
	//page factory for creating groups

	//xpath for clicking the content
	@FindBy(xpath="//z[contains(text(),'CONTENT')]")
	public WebElement content;

	//xpath for manage topics
	@FindBy(xpath="//z[contains(text(),'Manage Topics')]")
	public WebElement manageTopics;

	//xpath for create topic button
	@FindBy(xpath="//button[contains(@class,'adduserbutton ng-scope')]")
	public WebElement createTopic;

	//xpath for adding text to the topic
	@FindBy(xpath="//input[contains(@placeholder,'Add Title here...')]")
	public WebElement addTopicText;

	//xpath for clicking for adding image
	@FindBy(xpath="//div[@name='topicimage']")
	public WebElement addTopicImage;
	
	//xpath for clicking for adding image
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/form/div")
	public WebElement uploadTopicImage;
	
	//xpath for overview tab click
	@FindBy(xpath="//*[@id=\"divimg\"]/div/ul/li[1]")
	public WebElement overviewTabClick;

	//xpath for adding overview
	@FindBy(xpath="//*[@id='content']/div[2]/div[3]/div/div/textarea")
	public WebElement addOverview;

	//xpath for clicking on content
	@FindBy(xpath="//a[contains(text(),'CONTENT')]")
	public WebElement addContent;

	//xpath for adding preferences
	@FindBy(xpath="//a[contains(text(),'PREFERENCES')]")
	public WebElement addPreferences;

	//xpath for clicking free navigation button
	@FindBy(xpath="//span[contains(text(),'Free')]")
	public WebElement clickFreeNavigation;
	
	//check for regular or enforce
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div[1]/div[2]/label/span")
	public WebElement learningPathRegular;
	
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/label/span")
	public WebElement learningType;

	//xpath for adding nugget
	@FindBy(xpath="//div[contains(@class,'addnugget')]")
	public WebElement addNugget;

	@FindBy(xpath="//span[contains(text(),'All medical topics')]")
	public WebElement category;

	//xpath for adding nugget title
	@FindBy(xpath="//input[@name='ntitle']")
	public WebElement nuggetTitle;

	//xpath for add button
	@FindBy(xpath="//button[contains(@ng-click,'addnugget()')]")
	public WebElement addNuggetButton;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div[1]/p[1]")
	public WebElement nuggetErrorMesage;

	//xpath for adding object
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div/div/div[2]/div/div/uib-accordion/div/div[2]/div[2]/div/div[2]/div/div/p")
	public WebElement addObject;

	//xpath for adding audio
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[1]")
	public WebElement addAudio;

	//xpath for adding narative
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[2]")
	public WebElement addNarative;

	//xpath for adding pdf
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[3]")
	public WebElement addPdf;
	   
	//xpath for adding quiz
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[4]")
	public WebElement addQuiz;

	//xpath for adding interactivity
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[5]")
	public WebElement addInteractivity;

	//xpath for adding video
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[6]")
	public WebElement addVideo;


	//page factory for adding title and duration for the object includes uploading files  as well as

	//xpath for adding title
	@FindBy(xpath="//input[contains(@name,'tdescription')]")
	public WebElement addTitle;

	//xpath for description
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement addDescription;

	//xpath  for duration
	@FindBy(xpath="//input[@name='nduration']")
	public WebElement addDuration;

	//xpath for clicking on browse
	@FindBy(xpath="//button[contains(text(),'Browse')]")
	public WebElement browseForFile;

	//xpath for save button
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[5]/div/button[1]")
	public WebElement saveFile;

	//xpath for uploading the html file
	@FindBy(xpath="//button[contains(text(),'Upload HTML')]")
	public WebElement clickUploadHtml;

	//xpath for saving pdf
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[4]/div/button[1]")
	public WebElement saveButtonPdf;

	//xpath for adding quiz
	@FindBy(xpath="//button[contains(text(),' Formative Quiz')]")
	public WebElement clickFormativeQuiz;

	//xpath for adding question
	@FindBy(xpath="//button[contains(text(),'Add Question')]")
	public WebElement clickAAddQuestion;

	//xpath for adding question heading
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement addqDescrition;

	//xpath for adding question
	@FindBy(xpath="//button[contains(@class,'button3 ng-scope')]")
	public WebElement addQuestionButton;

	//xpath for adding cutoff score
	@FindBy(xpath="//input[@type='number']")
	public WebElement addCutOffScore;

	//xpath for save button
	@FindBy(xpath="//button[@ng-click='savequiz()']")
	public WebElement saveQuiz;
	
	//xpath for save button of html
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[4]/div/button[1]")
	public WebElement saveHtml;
		
	//xpath for save button of interactivity
	@FindBy(xpath="//button[@ng-click='saveswipper()']")
	public WebElement saveInteractivity;
		
	//xpath for save button of video
	@FindBy(xpath="//button[@ng-click='savevideo()']")
	public WebElement saveVideo;
	
	//xpath for the button to save topic
	@FindBy(xpath="//button[@ng-click='saveon()']")
	public WebElement saveTopic;
	
	//xpath for search topic box
	@FindBy(xpath="//input[@placeholder='Search Topics']")
	public WebElement searchBox;

	//xpath for topic name header
	@FindBy(xpath="//span[contains(text(),'Topic Name')]")
	public WebElement topicNameHeader;

	//xpath for created by header
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[2]/table/thead/tr[1]/th[2]/div")
	public WebElement createdByHeader;
			
	//xpath for created on header
	@FindBy(xpath="//span[contains(text(),'Created On')]")
	public WebElement createdOnHeader;
	
	@FindBy(xpath="//span[contains(text(),'Tags')]")
	public WebElement tags;
	
	@FindBy(xpath="//span[contains(text(),'Published')]")
	public WebElement published;
					
					
	//xpath for bread crumb
	@FindBy(xpath="//ol[@class='breadcrumb']")
	public WebElement breadCrumb;
	
	//xpath for bread crumb
	@FindBy(xpath="//button[@class='swal2-confirm button1']")
	public WebElement OKButton;
	
	//alert message 
	@FindBy(xpath="//div[contains(@id,'swal2-content')]")
	public WebElement topicerrormsgs;
	
	@FindBy(xpath="//span[contains(text(),'Published')]")
	public WebElement  publishedHeader ;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div[6]/div[1]/label/span")
	public WebElement  certificateyes;
		
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div[4]/div/div[1]/label/span")
	public WebElement subcategory;
		
	public CreateTopic() 
	{
	super();
	PageFactory.initElements(driver,this);
	}
	
	
	public void clickLearningPathRegular()
	{
		sleep(3000);
		learningPathRegular.click();
	}
	
	
	public void learningTypeclick()
	{
		sleep(3000);
		learningType.click();
	}
	
	
	
	
	public void clicksavetopic()
	{
		sleep(3000);
		saveTopic.click();
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
	
	//Clicks on create topic button
	public void clickCreateTopicButton()
	{
		createTopic.click();
	}
	
	public boolean createTopicBtn()
	{
		implicitWait(40);
		return createTopic.isDisplayed();
	}
	
	public boolean searchBox()
	{
		return searchBox.isDisplayed();
	}
	
	public boolean checkTags()
	{
		return tags.isDisplayed();
	}
	
	public boolean topicNameHeader()
	{
		return topicNameHeader.isDisplayed();
	}
	
	public boolean checkcreatedByHeader()
	{
		implicitWait(40);
		return createdByHeader.isDisplayed();
	}
	
	public boolean createdOnHeader()
	{
		return createdOnHeader.isDisplayed();
	}
	
	public boolean publishedHeader()
	{
		return publishedHeader.isDisplayed();
	}
	
	public boolean breadCrumb()
	{
		 return breadCrumb.isDisplayed();
	}
	
	
	public void clickpreferences()
	{
		addPreferences.click();
	}
	
	public void clickfreenavigation()
	{
		clickFreeNavigation.click();
	}
	
	public void clickCategory()
	{
		category.click();
	}
	
	public void clickContenttopic()
	{
		addContent.click();
	}
	
	public void clickcertificate()
	{
		certificateyes.click();
	}
	
	
	//Adding image file
	public void addImage() throws InterruptedException, AWTException
	{
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		//clicks on camera icon to upload image
		addTopicImage.click();
		
		Thread.sleep(5000);
		
		//add topic image
		StringSelection sel = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\topicwhite-1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void addImagegreatersize() throws InterruptedException, AWTException
	{
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		//clicks on camera icon to upload image
		addTopicImage.click();
		
		Thread.sleep(5000);
		
		//add topic image
		StringSelection sel = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\SampleJPGImage_30mbmb.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	//adding audio object
		public void addAudioObject() throws InterruptedException, AWTException
		{
			//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			Thread.sleep(3000);
			//selecting audio object
			addAudio.click();
			//Enter audio title
			addTitle.sendKeys("Audio title");
			//Enter audio description
			addDescription.sendKeys("Audio description");
			//enter duration
			addDuration.sendKeys("2");
			//browse the audio file
			browseForFile.click();
		
			//selecting the audio file from file system
			Thread.sleep(3000);
		   StringSelection selAudio = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\Testaudio.mp3");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selAudio,null);
			
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
			//Thread.sleep(1000);
			       
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(8000);
			saveFile.click();
			Thread.sleep(6000);
		}
		
		       //adding narrative object
				public void addNarrativeObject() throws InterruptedException, AWTException
				{
					//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					Thread.sleep(3000);
					//selecting narrative object
					addNarative.click();
					//clicks on upload html button
					clickUploadHtml.click();
					//enter narrative title
					addTitle.sendKeys("Narrative title");
					//enter duration
					addDuration.sendKeys("2");
					
					//browse the narrative html file
					browseForFile.click();
				
					//selects narrative file from file system
					Thread.sleep(3000);
				    StringSelection selNarrative = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\index.html");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selNarrative,null);
					
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
					Thread.sleep(1000);
					       
					// Press Enter
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					
					//Save the Html object
					saveHtml.click();
					Thread.sleep(6000);
				}
				
				
				//adding pdf object
				public void addPdfObject() throws InterruptedException, AWTException
				{
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					//Thread.sleep(3000);
					//selecting pdf object
					addPdf.click();
					//add pdf title
					addTitle.sendKeys("PDF title");
					//add duration
					addDuration.sendKeys("2");
					
					//browse the pdf file
					browseForFile.click();
				
					//select pdf file from file system
					Thread.sleep(3000);
				    StringSelection selPdf = new StringSelection("E:\\HandwashingWithAnanseBookCompressed.pdf");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selPdf,null);
					
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
					
					//save the pdf object
					Thread.sleep(5000);
					saveButtonPdf.click();
					Thread.sleep(6000);
				}
				
				
				
				//adding interactivity object
				public void addInteractivityObject() throws InterruptedException, AWTException
				{
					//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					Thread.sleep(3000);
					//selecting interactivity object
					addInteractivity.click();
					//add interactivity title
					addTitle.sendKeys("Interactivity title");
					//add duration
					addDuration.sendKeys("2");
					
					//browse the interactivity file
					browseForFile.click();
				
					//select interactivity file from file system
					Thread.sleep(3000);
				    StringSelection selInteractivity = new StringSelection("D:\\Enhanzed\\swipper\\000030-6-2-A.jpg");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selInteractivity,null);
					
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
					Thread.sleep(1000);
					       
					// Press Enter
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					
					//save interactivity object
					Thread.sleep(3000);
					saveInteractivity.click();
					Thread.sleep(6000);
				}
				
				
				//adding video object
				public void addVideoObject() throws InterruptedException, AWTException
				{
				
					Thread.sleep(3000);
					//selecting video object
					addVideo.click();
					//Enter video title
					addTitle.sendKeys("Video title");
					//Enter description for video
					addDescription.sendKeys("Description for video");
					//Enter duration
					addDuration.sendKeys("2");
					
					//browse the video file
					browseForFile.click();
				
					//select audio file from file system
					Thread.sleep(5000);
				    StringSelection selVideo = new StringSelection("D:\\Enhanzed\\Video Sample.mp4");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selVideo,null);
					
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
					Thread.sleep(1000);
					       
					// Press Enter
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					
					//save video object
					Thread.sleep(8000);
					saveVideo.click();
					Thread.sleep(6000);
				}
				
				//adding quiz object
				public void addQuizObject() throws InterruptedException, AWTException
				{
					
					addQuiz.click();
					//select formative quiz
					clickFormativeQuiz.click();
					//click on add question button
					addQuestionButton.click();
					
					//Iterating the questions- here entering 5 questions and 
					//adding 6 options for answers for each of the question and selecting answer
					int j;
					
					for(j=1;j<=5;j++)
					{
					addqDescrition.sendKeys("Question number" +j);
					
					for(int i=1;i<=6;i++)
					{
						//Iterating to enter 6 options as answers for each of the question
					driver.findElement(By.xpath("//input[contains(@name,'tdescription')]["+i+"]")).sendKeys("Answer"+i);
					}
					
					//Select radio button to set it as answer
					driver.findElement(By.xpath("//input[contains(@name,'iopts')][1]")).click();
					
					//after reaching for 5th question should save the questions
					if(j==5)
					{
				
						Thread.sleep(3000);
						saveQuiz.click();
						Thread.sleep(5000);
					}
					else
					{
						//if not 5th question then continue adding question
					driver.findElement(By.xpath("//button[@ng-click='addques()']")).click();
					
					}
					}
					//After creating questions and answers, set cutoff score and save the quiz
					driver.findElement(By.xpath("//input[@ng-model='cutoffsc']")).sendKeys("3");
					driver.findElement(By.xpath("//button[@ng-click='sumsavequiz(cutoffsc)']")).click();
				}
				
		
		public void addNugget(int j) throws InterruptedException
		{
			//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			Thread.sleep(5000);
			//click to add nugget
			addNugget.click();
			//Enter nugget title
			nuggetTitle.sendKeys("New nugget"+j);
			//Click on add nugget button
			addNuggetButton.click();
		}
		
		public void addPreferences()
		{
			
			//adding preferences
			addPreferences.click();
			//Select free navigation as 'yes' radio button
			clickfreenavigation();
		}
		
	
	//Topic creation method
	public void topicCreationContent(String topicname) throws InterruptedException, AWTException
	{
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		addTopicText.sendKeys(topicname);
		//Calling mathod to add an image
		addImage();
		//adding overview
		addOverview.sendKeys("Overview for new topic1");
		//calling method to add preferences
		addPreferences();
		//click on Content tab
		addContent.click();
		Thread.sleep(3000);
		//Iterating to create 10 nuggets and each nugget should have 6 objects of different type
		for(int j=1;j<=1;j++)
		{
		//calling method to add nugget
		addNugget(j);
		//selecting add object of different nugget
		for(int i=1;i<=5;i++)
		{		
			
		WebElement demo = driver.findElement(By.xpath("//div[@ng-repeat='nugget in nuggets track by $index']["+j+"]//p[@ng-click]"));
		//add object
		Thread.sleep(8000);
		//To click on the Add object
		Actions actions = new Actions(driver);
		actions.moveToElement(demo).click().perform();
		//Selecting different types of the object for each of the nugget		
		if(i==1)
		{
		addAudioObject();
		}
		else if(i==2)
		{
		//calling method to add narrative type of object
		addNarrativeObject();
		}
		else
		{
		//calling quiz object method
		addQuizObject();
		}
		}
		}
		saveTopic.click();
		System.out.println("Topic created successfully");
	}
	
	//checking for creation of topic when blank data is saved
	/*public void createBlankTopic()
	{
		sleep(5000);
		saveTopic.click();
		sleep(5000);
		 if(error.size()>0)
		  {
			  System.out.println(error.get(0).getText());
		  }
		  
		  else
		  {
			  System.out.println("Error in creating topic");
		  }
		OKButton.click();
		
	}*/
	
	//checking for creation of incomplete topic saved
	/*public void createIncompleteTopic()
	{
		addTopicText.sendKeys("demo topic");
		
		sleep(5000);
		
		//adding overview
		addOverview.sendKeys("Overview for new topic1");
		
		//calling method to add preferences
		addPreferences();
		sleep(5000);
		saveTopic.click();
		
		 if(error.size()>0)
		  {
			  System.out.println(error.get(0).getText());
		  }
		  
		  else
		  {
			  System.out.println("Error in creating topic");
		  }
		 OKButton.click();	
	}*/
	
	
}
