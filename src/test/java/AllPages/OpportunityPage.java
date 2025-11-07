package AllPages;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OpportunityPage {
   WebDriver driver;
   Enquiry enquiry;
	
	public OpportunityPage(WebDriver driver) {
		this.driver = driver;
		this.enquiry = new Enquiry(driver);  
		driver.manage().window().maximize();
	    PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath="(//span[text()='Opportunities'])[1]")
	WebElement oppTab;
	
	@FindBy(xpath="//h1[contains(text(),'Opportunities')]")
	WebElement OppVerify;
	
	@FindBy(xpath="//a[@title='Qualified']")
	WebElement qualifiedText;
	
	@FindBy(xpath="//lightning-tabset//li[@title='Search Units']")
	By searchUnit;
	
	@FindBy(xpath="//input[@placeholder='Enter Unit Number....']")
	WebElement searchUnitByText;
	
	@FindBy(xpath="//td/div[@title='Name']")
	WebElement verifyUnit;
	
	@FindBy(xpath="(//lightning-input//span//input[@type='checkbox'])[4]")
	WebElement checkboxUnit;
	
	
	public void SelectOpp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(oppTab)).click();
//		oppTab.click();
		sleep(3000);
		String actualText = OppVerify.getText();
		String expectedText = "Opportunities";
		Assert.assertEquals(expectedText, actualText,"Not in opportunity page");
	}
	
	public void searchField(String name) throws Exception {
		enquiry.enqSearchoption(name);
	}
	
	public void VerifyStage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(qualifiedText));
		String acutal = qualifiedText.getText();
		String expected = "Qualified";
		Assert.assertEquals(expected, acutal,"Not in the stage of qualified");
	}
	
	public void searchUnitAdd(String UnitName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(searchUnit)).click();
		WebElement UnitSearch = wait.until(ExpectedConditions.elementToBeClickable(searchUnitByText));
		UnitSearch.sendKeys(UnitName +Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(verifyUnit));
		String EUnitName = verifyUnit.getText();
		Assert.assertEquals(EUnitName,UnitName,"Unit name is not matched");
		
		
		
	}
	
	
	
	
	
	
	

}
