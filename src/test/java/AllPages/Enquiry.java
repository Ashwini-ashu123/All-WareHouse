package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.junit.Assert.*;

import static java.lang.Thread.sleep;

import java.time.Duration;

public class Enquiry {
	
	WebDriver driver;
	
	public Enquiry(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	    PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	WebElement mobile;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement Mail;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement Next;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement Name;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	@FindBy(name="Intent_Type")
	WebElement type;
	
	@FindBy(name="Budget_Range1__c")
	WebElement budget;
	
	@FindBy(xpath="(//div[@class='slds-form-element__control'])[1]")
	WebElement NOP;
	
	@FindBy(xpath="(//div[@class='slds-form-element__control'])[2]")
	WebElement ser;
	
	@FindBy(xpath="//input[@name='Size_in_sqfts__c']")
	WebElement sizeinSq;
	
	@FindBy(xpath="(//div[@class='slds-form-element__control'])[3]")
	WebElement enqS;
	
	@FindBy(xpath="(//div[@class='slds-form-element__control'])[4]")
	WebElement enqSS;
	
	@FindBy(xpath="(//lightning-formatted-text[@slot='primaryField'])[2]")
	WebElement VerfiyRecord;
	
	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement EnqSearch;
	
	@FindBy(xpath="//button[@aria-label='Size Range']")
	WebElement EditRange;
	
	@FindBy(xpath="//button[@name='SaveEdit']")
	WebElement editSave;
	
	@FindBy(xpath="//lightning-button-menu[@class='menu-button-item slds-dropdown_actions slds-dropdown-trigger slds-dropdown-trigger_click']")
	WebElement dropdown;
	
	@FindBy(xpath="//button[@name='Edit']")
	WebElement editButton;
	
	@FindBy(xpath="//a//span[contains(text(),'Edit')]")
	WebElement editText;
	
	@FindBy(xpath="//button[normalize-space()='New']")
	WebElement INew;
	
	@FindBy(xpath="//input[@name='Name']")
	WebElement Iname;
	
	@FindBy(xpath="//input[@name='Interested_Location_Range__c']")
	WebElement Irange;
	
	@FindBy(xpath="(//button/span[contains(text(),'New')])[3]")
	WebElement StatusClick;
	
	@FindBy(xpath="//span/span[@title='Closed']")
	WebElement closedClick;
	
	@FindBy(xpath="//button[@aria-label='Reason for Closed']")
	WebElement reasonClosed;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement Submit;
	
	@FindBy(xpath="//records-entity-label[contains(text(),'Opportunities')]")
	WebElement OppText;
	
	private String lastName;
	
	public void Screen1Enq(String Phone, String mail) throws Exception {
		sleep(2000);
		mobile.sendKeys(Phone);
		Mail.sendKeys(mail);
		sleep(1000);
		Next.click();
		}
	public void screen2A3(String lname,String Itype) throws Exception {
		 this.lastName = lname; 
		sleep(3000);
		Name.sendKeys(lname);
		save.click();
		sleep(1000);
		type.click();
		Select sel = new Select(type);
		sel.selectByVisibleText(Itype);
		sleep(3000);
		Next.click();
	}
	
	public void screen4(String bud,String nop,String service, String size, String Enq, String EnqSource) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(budget));
		budget.sendKeys(bud);
		sleep(3000);
	    
		NOP.click();
	    sleep(3000);
	    WebElement nopOption = driver.findElement(By.xpath("//span[contains(text(),'" + nop + "')]"));
	    nopOption.click();
	    System.out.println("nop selected");
	    
	    ser.click();
	    sleep(2000);
	    WebElement serOption = driver.findElement(By.xpath("//span[contains(text(),'" + service + "')]"));
	    serOption.click();
	   
	    sizeinSq.sendKeys(size);
	   
	    enqS.click();
	    sleep(2000);
	   
	    WebElement EnqOption = wait.until(ExpectedConditions
	    	    .visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item//span[normalize-space()='" + Enq + "']")));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", EnqOption);
	    sleep(2000);
	    
	    enqSS.click();
	    sleep(2000);
	    WebElement EnqSSoption = driver.findElement(By.xpath("//span[contains(text(),'" + EnqSource + "')]"));
	    EnqSSoption.click();
	    
	    Next.click();
	 }
	
	public void verifyRecText() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Text1 = wait.until(ExpectedConditions
			    .visibilityOfElementLocated(By.xpath("//h1//lightning-formatted-text[contains(normalize-space(text()), '" + lastName + "')]")));

		String Text2 = Text1.getText();
		assertEquals("Record is not created", Text2, lastName);
		}
	
	public void enqSearchoption(String name) throws Exception {
	EnqSearch.click();
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement EnameSearch = wait1.until(ExpectedConditions.elementToBeClickable(EnqSearch));
	EnameSearch.sendKeys(name + Keys.ENTER);
	FluentWait wait = new FluentWait(driver);
	wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).withMessage(name);
	sleep(2000);
	WebElement NameClick = driver.findElement(By.xpath("//span[contains(text(),'" + name +"')]"));
	NameClick.click();
	sleep(2000);
	}
	
	public void editEnquiry(String range1) throws Exception {
		sleep(10000);
		editButton.click();
//		editText.click();
		sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",EditRange);
		System.out.println("Scroll to the view");
		sleep(3000);
		js.executeScript("arguments[0].click()",EditRange);
		WebElement Rangeedit = driver.findElement(By.xpath("//span/span[contains(text(),'"+ range1 +"')]"));
		sleep(3000);
		Rangeedit.click();
		editSave.click();
		
	}
	
	public void intrestedLocation(String InName, String InRange) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
             WebElement scrollableColumn = driver.findElement(By.xpath("(//flexipage-record-home-scrollable-column)[2]"));
		    wait.until(ExpectedConditions.visibilityOf(scrollableColumn));
		    js.executeScript("arguments[0].scrollTop += 400;", scrollableColumn);
		    sleep(5000);
		    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", INew);
		    wait.until(ExpectedConditions.elementToBeClickable(INew));
		    sleep(2000);
		    js.executeScript("arguments[0].click();", INew);
		    System.out.println("Clicked New button");
		    wait.until(ExpectedConditions.visibilityOf(Iname));
		    Iname.sendKeys(InName);
		    sleep(2000);
		    Irange.sendKeys(InRange);
		    sleep(2000);
		    wait.until(ExpectedConditions.elementToBeClickable(editSave));
		    editSave.click();
		    sleep(5000);
		    System.out.println("Save button clicked");
	}
	
	public void convertToqualified(String Qualified1) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		editButton.click();
		sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(editText));
//		editText.click();
		wait.until(ExpectedConditions.elementToBeClickable(StatusClick));
		StatusClick.click();
		wait.until(ExpectedConditions.elementToBeClickable(closedClick));
		closedClick.click();
		wait.until(ExpectedConditions.elementToBeClickable(reasonClosed));
		reasonClosed.click();
		WebElement RC = driver.findElement(By.xpath("//span[@title='"+Qualified1+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(RC));
		RC.click();
		wait.until(ExpectedConditions.elementToBeClickable(editSave));
		editSave.click();
		wait.until(ExpectedConditions.elementToBeClickable(Submit));
		Submit.click();
		}
	
	public void VerifyOpportunityNavigate(String EnqName) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(OppText));
		String Actual = OppText.getText();
		WebElement AcText = driver.findElement(By.xpath("//div//span//slot//lightning-formatted-text[contains(text(),'"+ EnqName +"')]"));
		String Actual2Text = AcText.getText();
		String Expected1 = "Opportunities";
		String Expected2 = EnqName;
		Assert.assertEquals( Actual,Expected1, "Mismatch in Opportunity text");
		Assert.assertEquals(Actual2Text, Expected2,"Mismatch in name field");
		System.out.println("Actual: " + Actual + 
                " | Expected1: " + Expected1 + 
                " | Actual2Text: " + Actual2Text + 
                " | Expected2: " + Expected2);

		
		
	}
	
	
}
