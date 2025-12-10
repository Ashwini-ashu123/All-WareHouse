package AllPages;

import static java.lang.Thread.sleep;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Sitevisit {
	 WebDriver driver;
	 
	 public Sitevisit(WebDriver driver) {
		 this.driver = driver;
		 driver.manage().window().maximize();
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath="//button[contains(text(),'Schedule Site Visit')]")
	 WebElement sitevisitSch;
	 
	 @FindBy(xpath="(//input[@name='Visit_Date'])[1]")
	 WebElement datefield;
	 
	 @FindBy(xpath="(//input[@name='Visit_Date'])[2]")
	 WebElement timefield;
	 
	 @FindBy(xpath="//input[@name='No_of_People_Planned']")
	 WebElement noOfVisit;
	 
	 @FindBy(xpath="//select[@name='Unit_Bundle']")
	 WebElement unitBundle;
	 
	 @FindBy(xpath="//button[contains(text(),'Save')]")
	 WebElement save;
	 
	 @FindBy(xpath="(//article[@class='slds-card slds-has-top-magnet'])[1]")
	 private WebElement article;
	 
	 @FindBy(xpath="//records-entity-label")
	 WebElement sitevisitHead;
	 
	 @FindBy(xpath="//button[@name='Site_Visit__c.Mark_Complete']")
	 WebElement markComplete;
	 
	 @FindBy(xpath="(//span[@class='slds-checkbox_faux'])[3]")
	 WebElement toggle;
	 
	 @FindBy(xpath="//button[contains(text(),'Capture Image')]")
	 WebElement captureImg;
	 
	 @FindBy(xpath="//button[contains(text(),'Next')]")
	 private WebElement Next;
	 
	 @FindBy(xpath="//img[@alt='Captured Image']")
	 WebElement imgSrc;
	 
	 @FindBy(xpath="//lightning-formatted-location")
	 WebElement svCompleted;
	 
	 @FindBy(xpath="//lightning-formatted-text[contains(text(),'Completed')]")
	 WebElement completed;
	 
	 public WebElement getArticle() {
		 return article;
	 }
	 
	 public WebElement getNext() {
		 return Next;
	 }
	 
	 
	 public void schSiteVisit() throws Exception {
		 sleep(3000);
		 WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(60));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView({block: 'center'});", sitevisitSch);
		 js.executeScript("arguments[0].click();", sitevisitSch);
		 WebElement date1 = wait.until((ExpectedConditions.visibilityOf(datefield)));
		 date1.click();
		 String datefill = "25-Dec-2025";
		 String timeFill = "3.30PM";
		 String visitNu = "3";
		 date1.sendKeys(datefill);
		 WebElement time1 = wait.until((ExpectedConditions.visibilityOf(timefield)));
		 timefield.click();
//		 timefield.sendKeys(timeFill);
		 wait.until(ExpectedConditions.elementToBeClickable(noOfVisit)).sendKeys(visitNu);
		 sleep(3000);
		 wait.until(ExpectedConditions.elementToBeClickable(unitBundle)).click();
		 Select sel = new Select(unitBundle);
		 sel.selectByIndex(1);  
		 sleep(3000);
		 save.click();
      }
	 
	 public void verifySiteVisit(String Name) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 WebElement ActualText = wait.until(ExpectedConditions.visibilityOfElementLocated(( By.xpath("//a[contains(text(),'"+Name+"')]"))));
		 String Result1 = ActualText.getText();
		 System.out.println(Result1);
		 String Result2 = Name;
		 Assert.assertTrue(Result1.contains(Result2), 
                  "The actual text does not contain the expected substring.");
	 }
	 
	 public void VerifySVStatus_click(String Name) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 WebElement Sitevisit = wait.until(ExpectedConditions.visibilityOfElementLocated(( By.xpath("//a[contains(text(),'"+Name+"')]"))));
		 WebElement textdata = wait.until(ExpectedConditions.visibilityOf(article));
		 String text1 = textdata.getText();
		 System.out.println(text1);
//		 Assert.assertTrue(text1.contains("Scheduled"),"No the site visit is not in scheduled status");
		 String link = Sitevisit.getAttribute("href");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.open(arguments[0], '_blank');", link);
//		 Sitevisit.click();
		 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));  // new tab index is usually 1
		 System.out.println("Switched to new tab.");
		}
	 
	 public void verify_in_SitevisitPage() throws Exception {
		 sleep(10000);
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 String AcutalText = wait.until(ExpectedConditions.visibilityOf(sitevisitHead)).getText();
		 String ExpectedText = "Site Visit";
		 Assert.assertEquals(AcutalText, ExpectedText,"no the user is not in Site visit page");
		 
		}
	 
	 public void siteVisitProcess() throws TimeoutException, Exception {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.elementToBeClickable(markComplete)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(toggle)).click();
//		 wait.until(ExpectedConditions.elementToBeClickable(captureImg)).click();
		 System.out.println("Capture img click");
		 wait.until(ExpectedConditions.elementToBeClickable(Next)).click();
		 System.out.println("Click next");
//		 WebElement imageElement = wait.until(ExpectedConditions.visibilityOf(imgSrc));  
		 sleep(10000);
//		if (imageElement.isDisplayed()) {
//		    System.out.println("Image is displayed.");
//		    sleep(5000);
//		    File screenshot = imageElement.getScreenshotAs(OutputType.FILE);
//		    File destFile = new File(System.getProperty("user.dir") + "/screenshots/CaptureImages/SiteVisitImage.png");;
//		    FileUtils.copyFile(screenshot, destFile);
//		    System.out.println("Image captured successfully: " + destFile.getAbsolutePath());
//		}
		wait.until(ExpectedConditions.elementToBeClickable(Next)).click();
		sleep(5000);
	 }
	 
	 public void verifySiteVisitComplete(String Name) throws Exception {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//		 wait.until(ExpectedConditions.visibilityOf(svCompleted));
//			String locationUpdate = svCompleted.getText();
//			if(locationUpdate.matches(".*\\d+.*")) {
//				System.out.println("location updated successfully");
//			}else {
//				System.out.println("Location is not updated");
//			}
//			String ActualText = wait.until(ExpectedConditions.visibilityOf(completed)).getText();
//			String ExpectedText = "Completed";
//			Assert.assertEquals(ActualText, ExpectedText,"Site visit is not in completed");
//		 WebElement backToSiteVist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'"+Name+"')])[4]")));
//			((JavascriptExecutor) driver).executeScript("window.open()");
//         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1));
		 WebElement ele = driver.findElement(By.xpath("(//span[contains(text(),'" + Name + "')])[4]/parent::*"));
         Actions actions = new Actions(driver);
		 actions.contextClick(ele).perform();
          // Press ↓ key to move to "Open link in new tab"
		 actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			
			sleep(5000);
			}
		 
	 }

