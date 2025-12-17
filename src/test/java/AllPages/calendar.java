package AllPages;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class calendar {
	
	WebDriver driver;
	
	
	public calendar(WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='fullcalendarjs fc fc-unthemed fc-ltr']//h2")
	WebElement monthName;
	
	@FindBy(xpath="//td[contains(@class,'fc-today')]")
	private WebElement todayDate;
	
	@FindBy(xpath="//td[contains(@class,'fc-past')]")
	private WebElement pastdate;
	
	@FindBy(xpath="//div[@class='toastContent slds-notify__content slds-align-middle']")
	WebElement warningMesg;
	
	@FindBy(xpath="//td[contains(@class,'fc-future')]")
	private WebElement futureDate;
	
	@FindBy(xpath="(//*[@class='slds-icon slds-icon_xx-small'])[5]")
	WebElement close;
	
	@FindBy(xpath="//div[@class='toastTitle slds-text-heading--small']")
	WebElement AccessdeniedMesg;
	
	public WebElement getPastDate() {
		return pastdate;
	}
	
	public WebElement getFutureDate() {
		return futureDate;
	}
	
	public WebElement getTodayDate() {
		return todayDate;
	}
	
	public void navigateTab(String TabName) throws Exception {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(40));
		WebElement Tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='" +TabName+"'])[1]")));
		Tab.click();
		sleep(10000);
		String Currentmonth = monthName.getText();
		System.out.println(Currentmonth);
		String today= todayDate.getAttribute("data-date");
		System.out.println(today);
		LocalDate today1 = LocalDate.now();
//		Assert.assertEquals(today,today1,"No date is not matching with current date");
//		pastdate.click();
//		String warnMesg = warningMesg.getText();
//		System.out.println(warnMesg);
//		close.click();
		futureDate.click();
		String AccessMesg = AccessdeniedMesg.getText();
		System.out.println(AccessMesg);
		close.click();
		}

}
