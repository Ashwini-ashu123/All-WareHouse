package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		sleep(3000);
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
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		Assert.assertEquals(lastName, Text2, "Record is not created");
		
		
	}
}
