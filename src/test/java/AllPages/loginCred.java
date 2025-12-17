package AllPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;



public class loginCred {
	
	WebDriver driver;
	
	
	public loginCred(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	    PageFactory.initElements(driver,this);
		}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement Login;
	
	@FindBy(xpath="//h1//span[@class='slds-truncate']")
	WebElement title;
	
	@FindBy(xpath="//span[text()='App Launcher']/ancestor::button")
	WebElement dot;
	
	@FindBy(xpath="//p[text()='All Warehouses']")
	WebElement AWHTab;
	
	@FindBy(xpath="(//span[text()='Enquiries'])[1]")                
	WebElement Enq;
	
	@FindBy(xpath="//div[@title='New']")
	WebElement New;
	
	@FindBy(xpath="(//span[@class='photoContainer forceSocialPhoto'])[1]")
	WebElement profile;
	
	@FindBy(xpath="//*[contains(text(),'Log Out')]")
	WebElement logout;
	
	
	public void  saleforceURL() {
		driver.get("https://test.salesforce.com/");
	}
	
	public void UserNameAndPassword(String Username,String Password) {
		username.sendKeys(Username);
		password.sendKeys(Password);
		}
	
	public void loginButton() throws Exception {
		Login.click();
		Thread.sleep(5000);
		}
	
	public void verifyText(String Atitle) throws Exception {
		String Heading = title.getText();
		Thread.sleep(3000);
		String ActualHeads = Atitle;
		assertEquals(Heading, ActualHeads, "We are not landed on the correct page");
		Thread.sleep(2000);
	}
	
	public void EnqClick() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		dot.click();
		wait.until(ExpectedConditions.elementToBeClickable(AWHTab)).click();
		Thread.sleep(3000);
		Enq.click();
		String EText = Enq.getText();
		System.out.println("Enq is clicked");
		Thread.sleep(2000);
	}
	
	public void NewClick() throws Exception {
		New.click();
		Thread.sleep(5000);
		
	}
	
	public void Logout() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
		
	}

	
		
}
	
	


