package AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

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
	
	public void Screen1Enq(String Phone, String mail) throws Exception {
		sleep(2000);
		mobile.sendKeys(Phone);
		Mail.sendKeys(mail);
		sleep(1000);
		Next.click();
		}
	public void screen2A3(String lname,String Itype) throws Exception {
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
	
	
	
	
}
