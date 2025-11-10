package AllPages;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	WebElement searchUnit;
	
	@FindBy(xpath="//input[@placeholder='Enter Unit Number....']")
	WebElement searchUnitByText;
	
	@FindBy(xpath="//td/div[@title='Name']")
	WebElement verifyUnit;
	
	@FindBy(xpath="(//lightning-input//span//input[@type='checkbox'])[4]")
	WebElement checkboxUnit;
	
	@FindBy(xpath="//button[contains(text(),'Add Unit')]")
	WebElement addUnit;
	
	@FindBy(xpath="//flowruntime-screen-field//strong")
	WebElement UnitVerify;
	
	@FindBy(xpath="//lightning-icon[@class='slds-icon-utility-close slds-icon_container']")
	WebElement close;
	
	@FindBy(xpath="//button[contains(text(),'Generate Proposal')]")
	WebElement generateProp;
	
	@FindBy(xpath="//span[@class='slds-form-element__label']/preceding-sibling::span")
	WebElement propcheckbox;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement nextbutton;
	
	@FindBy(xpath="//input[@name='Save_Proposal_as']")
	WebElement propName;
	
	

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
	
	public void VerifyStage(String StageName) throws Exception {
		driver.navigate().refresh();
		sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement stage = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//a[@title='" + StageName + "']")));
		String acutal = stage.getText();
		String expected = StageName;
		Assert.assertEquals(expected, acutal,"Not in the stage");
		System.out.println(acutal +","+ expected);
	}
	
	public void searchUnitAdd(String UnitName) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(searchUnit)).click();
		System.out.println("click search unit");
		WebElement UnitSearch = wait.until(ExpectedConditions.elementToBeClickable(searchUnitByText));
		UnitSearch.sendKeys(UnitName);
		sleep(3000);
		UnitSearch.sendKeys(Keys.ENTER);
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(verifyUnit));
		String EUnitName = verifyUnit.getText();
		Assert.assertEquals(EUnitName,UnitName,"Unit name is not matched");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",checkboxUnit);
		js.executeScript("arguments[0].click()",checkboxUnit);
		wait.until(ExpectedConditions.elementToBeClickable(addUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(UnitVerify));
		String UnitText = UnitVerify.getText(); 
		String ActualVerifyText = "Units Created Successfully";
		Assert.assertEquals(UnitText, ActualVerifyText,"Unit option is not added successfully");
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();
	}
	
	public void generatePropsal() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(generateProp)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", propcheckbox);
		js.executeScript("arguments[0].click()", propcheckbox);
		wait.until(ExpectedConditions.elementToBeClickable(nextbutton)).click();
		sleep(7000);
		String ProposalName = "test automation proposal";
		WebElement propNa = wait.until(ExpectedConditions.visibilityOf(propName));
		propNa.click();
		propNa.sendKeys(ProposalName);
		wait.until(ExpectedConditions.elementToBeClickable(nextbutton)).click();
	}
	
	public void verifyPropGenerate() throws Exception{
		driver.navigate().refresh();
		sleep(4000);
		String ProposalName = "test automation proposal.Pdf";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement fileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+ProposalName+"')]")));
		js.executeScript("arguments[0].scrollIntoView()",fileName);
		String propName = fileName.getText();
		Assert.assertEquals(ProposalName,propName,"Proposal pdf is not generated");
		System.out.println(ProposalName + " , " + propName);
		
	}
	
	
	
	
	

}
