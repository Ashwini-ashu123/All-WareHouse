package AllPages;

import static java.lang.Thread.sleep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	 
	 public void schSiteVisit() throws Exception {
		 WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.elementToBeClickable(sitevisitSch)).click();
		 WebElement date1 = wait.until((ExpectedConditions.visibilityOf(datefield)));
		 date1.click();
		 String datefill = "25-Nov-2025";
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
}
