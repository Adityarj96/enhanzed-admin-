package com.enhanzedadmin.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InvocationEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enhanzedadmin.qa.base.Testbaseadmin;

/**
 * 
 * @author Aditya r javali
 * @category manage objects page 
 *
 */
public class ContentManageObjects extends  Testbaseadmin
{
     
	CreateTopic topic;
	String topictile="";
	String topictilevimeo="";
	String topictileaudio="";
	String topictilenarative="";
	String topictitlehtml="";
	String topicpdf="";
	String topicvideo="";
	public String path1="C:\\Users\\vitnita enhanzed\\Desktop\\file_example_MP3_700KB.mp3";
	public String path2="C:\\Users\\vitnita enhanzed\\Desktop\\Test audio for uploading the new file.mp3";
	            
	@FindBy(xpath="//z[contains(text(),'Manage Objects')]")
	public  WebElement manageobjects;
	
	@FindBy(xpath="//z[contains(text(),'CONTENT')]")
	public  WebElement content;
	
	
	@FindBy(xpath="//button[contains(text(),'Add Object')]")
	public  WebElement addobjectbutton;
	
	@FindBy(xpath="//input[contains(@name,'OBJECT_DETAILS.ttitle')]")
	public  WebElement searchttile;
	
	@FindBy(xpath="//input[contains(@name,'OBJECT_DETAILS.crby')]")
	public  WebElement searchcreatedby;
	
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
	
	@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
	public WebElement addVideodesc;
	
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
		
		@FindBy(xpath="//button[contains(text(),'Cancel')]")
		public WebElement cancelbutton;
		
		@FindBy(xpath="//input[contains(@name,'OBJECT_DETAILS.ttitle')]")
		public WebElement searchtitle;
		
		@FindBy(xpath="//div[contains(@class,'ql-editor ql-blank')]")
		public WebElement htmlcontent;
		
		@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
		public WebElement ytdescription;
		
		@FindBy(xpath="//span[contains(text(),'All medical topics')]")
		public WebElement category;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[7]/div/div[1]/label/span")
		public WebElement categoryvideo;
		
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[7]/div/div[1]/label/span")
		public WebElement subcategory;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[5]/div/div[1]/label/span")
		public WebElement subcategorynarative;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[6]/div/div[1]/label/span")
		public WebElement subcategorynarativeupload;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[7]/div/div[1]/label/span")
		public WebElement subcategoryyt;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[6]/div/div[1]/label/span")
		public WebElement subcategorypdfupload;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
		public WebElement audiotitleerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/p[1]")
		public WebElement audiodescriptionerrormsg;
	    
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/p[1]")
		public WebElement audiodurationemptymsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
		public WebElement fileuploaderrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[6]/p[1]")
		public WebElement categoryerrormsg;
		
		@FindBy(xpath="//button[contains(text(),'Save')]")
		public WebElement savebutton;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[1]")
		public WebElement createhtml;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[2]")
		public WebElement upload_html;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/p[1]")
		public WebElement htmltitleerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/p")
		public WebElement htmlcontenterrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[4]/p[1]")
		public WebElement htmlcategoryerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/p")
		public WebElement uploadhtmlerror;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[5]/p[1]")
		public WebElement uploadcategoryerror;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
		public WebElement pdftitleerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
		public WebElement pdfuploaderrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[5]/p[1]")
		public WebElement pdfcategoryerrormsg;
		
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[1]/p[1]")
		public WebElement videotitleerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[2]/p[1]")
		public WebElement videodescriptionerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/p[1]")
		public WebElement videodurationerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
		public WebElement videofileerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div[6]/p[1]")
		public WebElement videocategoryerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/p")
		public WebElement embedediderrormessge;
		
		@FindBy(xpath="//button[contains(text(),'Formative Quiz With Feedback')]")
		public WebElement formativequizwithfeedback;
		
		@FindBy(xpath="//button[contains(text(),'Formative Quiz')][2]")
		public WebElement formativequiz;
       
		@FindBy(xpath="//button[contains(text(),'Summative Quiz')]")
		public WebElement sumativequiz;
		
		
		@FindBy(xpath="//button[contains(@ng-click,'addques()')]")
		public WebElement addquestion;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/button[3]")
		public WebElement addquizquestion;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div[2]/p[1]")
		public WebElement addquestionerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div/p[1]")
		public WebElement quizTitleErrorMessage;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div[4]/p[3]")
		public WebElement addoptionserrormsg;
		
		@FindBy(xpath="//textarea[contains(@name,'tdescription')]")
		public WebElement addqDescrition;
		
		@FindBy(xpath="//input[contains(@name,'tdescription')]")
		public WebElement addqDescritionForQuiz;
		
		
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div[4]/p[3]")
		public WebElement optionserrormessage;
		

		@FindBy(xpath="//input[contains(@name,'iopts')][1]")
		public WebElement firstoption;
		
		@FindBy(xpath="//button[@ng-click='savequiz()']")
		public WebElement saveQuiz;
		
		@FindBy(xpath="//button[contains(@ng-click,'Catsavequiz()')]")
		public WebElement saveobjectquiz;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div[2]/p[1]")
		public WebElement quizcategoryerrormsg;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[1]/label/span")
		public WebElement quizcategory;
		
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div[3]/div/div[1]/label/span")
		public WebElement quizsubcategory;
		
		
		
			
		@FindBy(xpath="//input[contains(@name,'OBJECT_DETAILS.ttitle')]")
		public WebElement objtitlesearchtextbox;
        
		@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")
		public WebElement objtitle;
		
		@FindBy(xpath="//button[contains(@class,'swal2-confirm button1')]")
		public WebElement okbutton;
		
		@FindBy(xpath="//button[contains(text(),' Unpublish ')]")
		public WebElement unpublish;
		
		@FindBy(xpath="//button[contains(text(),'Publish')]")
		public WebElement publish;
		
		@FindBy(xpath="//input[contains(@ng-model,'youtubevideodata.embd')]")
		public WebElement embededtextforsm;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[7]")
		public WebElement youtubebutton;
		
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/div/button[8]")
		public WebElement vimeobutton;
		
		@FindBy(xpath="//button[contains(text(),'Edit')]")
		public WebElement editobject;
		
		@FindBy(xpath="/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/button")
		public WebElement checksearcresults;
		
		@FindBy(xpath="//input[contains(@ng-model,'indObjects.OBJECT_DETAILS.ttitle')]")
		public WebElement ytEdittextbox;
		
		@FindBy(xpath="//textarea[contains(@ng-model,'indObjects.OBJECT_DETAILS.tdescription')]")
		public WebElement editDescriptionBox;
		
		@FindBy(xpath="//input[contains(@type,'number')]")
		public WebElement ytEditNumber;
		
		@FindBy(xpath="//input[contains(@ng-model,'indObjects.OBJECT_DETAILS.embeddedcode')]")
		public WebElement ytEditEmbededCode;
		
		
		
		
		
	public ContentManageObjects() 
	{
		super();
	PageFactory.initElements(driver,this);
	topic=new CreateTopic();
	}
	
	public void clickContent()
	{
		content.click();
	}
	
	public void clickManageObjects()
	{
		manageobjects.click();
	}
	
	public void clickAddObject()
	{
		addobjectbutton.click();
	}
	
	public void addAudioObject()
	{
		sleep(3000);
		addAudio.click();
	}
	
	public void clickQuizCategory()
	{
		sleep(3000);
		quizcategory.click();
	}
	
	public void addVideo()
	{
		sleep(3000);
		addVideo.click();
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
	
	public void addQuiz()
	{
		sleep(3000);
		addQuiz.click();
	}
	
	public void addYoutubeVideo()
	{
		sleep(3000);
		youtubebutton.click();
	}
	
	public void addVimeoVideo()
	{
		sleep(3000);
		vimeobutton.click();
	}
	
	public void clicksavebutton()
	{
		sleep(3000);
		savebutton.click();
	}
	
	public void clicksavefinalquizbutton()
	{
		saveobjectquiz.click();
		implicitWait(40);
	}
	
	
	public void addaudiofile() throws InterruptedException, AWTException
	{
		topic.addAudioObject();
	}
	
	public void selectcategory()
	{
		category.click();	
	}
	
	
	public void browseaudiofile(String path) throws AWTException, InterruptedException
	{
		browseForFile.click();
		//selecting the audio file from file system
		Thread.sleep(3000);
	    StringSelection selAudio = new StringSelection(path);
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
		
		
	}
	
	public void browsevideo() throws AWTException, InterruptedException
	{
		browseForFile.click();
		//selecting the audio file from file system
		Thread.sleep(3000);
	   StringSelection selAudio = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\CR018-3-1.mp4");
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
		
	}
	
	
	public void addnarativeobject() throws InterruptedException, AWTException
	{
		browseForFile.click();
		
		//selects narrative file from file system
		Thread.sleep(3000);
	    StringSelection selNarrative = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\CR018-2-7.html");
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
	}
	
	public void addinteractivityfile() throws InterruptedException, AWTException
	{
		browseForFile.click();
		//selects narrative file from file system
		Thread.sleep(3000);
	    StringSelection selNarrative = new StringSelection("C:\\Users\\vitnita enhanzed\\Desktop\\swipper.zip");
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
	}
	
	
	public void addpdfobject() throws InterruptedException, AWTException
	{
		
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
		Thread.sleep(1000);
		       
		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void clickaudioandpublish() throws AWTException, InterruptedException 
	{
		sleep(3000);
		addAudio.click();
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));	
		String atitle=addTitle.getAttribute("value");
		topictileaudio=atitle;
		addDescription.sendKeys(RandomStringUtils.randomAlphabetic(20));
		addDuration.sendKeys("5");
		browseaudiofile(path1);
		category.click();
		subcategory.click();
		savebutton.click();
		sleep(10000);
		objtitlesearchtextbox.sendKeys(topictileaudio);
		System.out.println(atitle);
		sleep(4000);
		publish.click();
		okbutton.click();
		sleep(10000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void clicknarativepublish()
	{
		sleep(4000);
		addNarative.click();
		sleep(3000);
		createhtml.click();
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		String atitle=addTitle.getAttribute("value");
		topictilenarative=atitle;
		htmlcontent.sendKeys(RandomStringUtils.randomAlphabetic(100));
		category.click();
		subcategorynarative.click();
		savebutton.click();
		sleep(8000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		okbutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void checkuploadhtml() throws InterruptedException, AWTException
	{
		sleep(4000);
		addNarative.click();
		sleep(6000);
		upload_html.click();
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		String atitle=addTitle.getAttribute("value");
		String topictitlehtml=atitle;
		addnarativeobject();
		category.click();
		subcategorynarativeupload.click();
		savebutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(topictitlehtml);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		sleep(3000);
		okbutton.click();
	/*	sleep(3000);*/
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void checkuploadpdf() throws InterruptedException, AWTException
	{
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(10));
		String atitle=addTitle.getAttribute("value");
		String topicpdf=atitle;
		addpdfobject();
		category.click();
		subcategorypdfupload.click();
		savebutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(topicpdf);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		okbutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(topicpdf);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void addInteractivityswiper() throws InterruptedException, AWTException
	{
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		String atitle=addTitle.getAttribute("value");
		addinteractivityfile();
		category.click();
		subcategorypdfupload.click();
		savebutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		okbutton.click();
		sleep(8000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void addVideoObject() throws AWTException, InterruptedException
	{
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8));
		addVideodesc.sendKeys(RandomStringUtils.randomAlphabetic(100));
		addDuration.sendKeys("5");
		String atitle=addTitle.getAttribute("value");
		String topicvideo=atitle;
		browsevideo();
		category.click();
	    categoryvideo.click();
		savebutton.click();
		sleep(10000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		okbutton.click();
		sleep(10000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	
	public void addYoutubeObject()
	{
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YT");
	    String atitle=addTitle.getAttribute("value");
	    topictile=atitle;
		ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(8));
		embededtextforsm.sendKeys("oFlIjXAh4_c");
		addDuration.sendKeys("10");
		category.click();
		subcategoryyt.click();
		savebutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		sleep(3000);
		publish.click();
		sleep(4000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	public void editObjectYT()
	{
		System.out.println(topictile);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(topictile);
		unpublish.click();
		sleep(8000);
		objtitlesearchtextbox.sendKeys(topictile);
		if(checksearcresults.getText().contains(topictile))
		{
			checksearcresults.click();
			sleep(2000);
			editobject.click();
			ytEdittextbox.clear();
			ytEdittextbox.sendKeys(RandomStringUtils.randomAlphabetic(8)+"YTedit");
			String editatitle=ytEdittextbox.getAttribute("value");
			System.out.println(editatitle);
			ytEditNumber.clear();
			ytEditNumber.sendKeys("10");
			ytEditEmbededCode.clear();
			ytEditEmbededCode.sendKeys("PYlkH7XWN1A");
			clicksavebutton();
		}
	}

	public void addVimeoObject()
	{
		addTitle.sendKeys(RandomStringUtils.randomAlphabetic(8)+"Vimeo");
		String atitle=addTitle.getAttribute("value");
		topictilevimeo=atitle;
		ytdescription.sendKeys(RandomStringUtils.randomAlphabetic(8));
		embededtextforsm.sendKeys("378840916");
		addDuration.sendKeys("10");
		category.click();
		subcategoryyt.click();
		savebutton.click();
		sleep(9000);
		objtitlesearchtextbox.sendKeys(atitle);
		/*System.out.println(atitle);*/
		sleep(3000);
		publish.click();
		okbutton.click();
		sleep(8000);
		objtitlesearchtextbox.sendKeys(atitle);
		System.out.println(atitle);
		Assert.assertTrue(unpublish.isDisplayed());
	}
	
	
	public void editObjectVimeo()
	{
		System.out.println(topictilevimeo);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(topictilevimeo);
		unpublish.click();	
		sleep(8000);
		objtitlesearchtextbox.sendKeys(topictilevimeo);
		if(checksearcresults.getText().contains(topictilevimeo))
		{
			checksearcresults.click();
			sleep(2000);
			editobject.click();
			ytEdittextbox.clear();
			ytEdittextbox.sendKeys(RandomStringUtils.randomAlphabetic(8)+"Vimeoedit");
			String editatitle=ytEdittextbox.getAttribute("value");
			System.out.println(editatitle);
			ytEditNumber.clear();
			ytEditNumber.sendKeys("10");
			ytEditEmbededCode.clear();
			ytEditEmbededCode.sendKeys("368564220");
			clicksavebutton();
			
		}
	}
	
	public void editAudio() throws AWTException, InterruptedException
	{
		System.out.println(topictileaudio);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(topictileaudio);
		unpublish.click();
		sleep(2000);
		okbutton.click();
		sleep(4000);
		objtitlesearchtextbox.sendKeys(topictileaudio);
		if(checksearcresults.getText().contains(topictileaudio))
		{
			sleep(2000);
			checksearcresults.click();
			sleep(2000);
			editobject.click();
			ytEdittextbox.clear();
			ytEdittextbox.sendKeys(RandomStringUtils.randomAlphabetic(8)+"audioedit");
			String editedaudio=ytEdittextbox.getAttribute("value");
			System.out.println(editedaudio);
			editDescriptionBox.sendKeys(RandomStringUtils.randomAlphabetic(20));
			browseaudiofile(path2);
			clicksavebutton();	
		}
	}
	
	public void editNarative() throws InterruptedException, AWTException
	{
		System.out.println(topictilenarative);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(topictilenarative);
		unpublish.click();
		sleep(2000);
		okbutton.click();
		sleep(4000);
		objtitlesearchtextbox.sendKeys(topictilenarative);
		if(checksearcresults.getText().contains(topictilenarative))
		{
			sleep(2000);
			checksearcresults.click();
			sleep(2000);
			editobject.click();
			ytEdittextbox.clear();
			ytEdittextbox.sendKeys(RandomStringUtils.randomAlphabetic(8)+"narativeedit");
			addnarativeobject();
			clicksavebutton();	
		}
		
	}
	
	
	public void editInteractive() throws InterruptedException, AWTException
	{
		System.out.println(topictitlehtml);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(topictitlehtml);
		unpublish.click();
		sleep(2000);
		okbutton.click();
		sleep(4000);
		objtitlesearchtextbox.sendKeys(topictitlehtml);
		if(checksearcresults.getText().contains(topictitlehtml))
		{
			sleep(2000);
			checksearcresults.click();
			sleep(2000);
			editobject.click();
			/*ytEdittextbox.clear();
			ytEdittextbox.sendKeys(RandomStringUtils.randomAlphabetic(8)+"narativeedit");
			addinteractivityfile();
			clicksavebutton();*/	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void checkEditNarative() throws InterruptedException, AWTException
	{
		System.out.println(atitle);
		sleep(4000);
		objtitlesearchtextbox.clear();
		objtitlesearchtextbox.sendKeys(atitle);
	    unpublish.click();
		okbutton.click();
		System.out.println(atitle);
		objtitlesearchtextbox.sendKeys(atitle);
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addQuizObjectsameoption() throws InterruptedException, AWTException
	{
		for(int i=1;i<=6;i++)
		{
		driver.findElement(By.xpath("//input[contains(@name,'tdescription')]["+i+"]")).sendKeys("Answer");
		}
		firstoption.click();
		}
	
	public void addQuizObjectdifferentoption() throws InterruptedException, AWTException
	{
		for(int j=1;j<=5;j++)
		{
			addqDescrition.sendKeys(RandomStringUtils.randomAlphabetic(10));
		for(int i=1;i<=6;i++)
		{
		driver.findElement(By.xpath("//input[contains(@name,'tdescription')]["+i+"]")).sendKeys("Answer"+i);
		}
		firstoption.click();
		if(j==5)
		{
			saveQuiz.click();
		}
		else {
			addquestion.click();
		}
	}
	}
}
