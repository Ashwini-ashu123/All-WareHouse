package AllPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;
public class task {
	
	WebDriver driver;
	calendar cal;
	
	
	public task(WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		cal = new calendar(driver);
	}
	
	@FindBy(xpath="//button[@title='New Task']")
	WebElement task;
	
	@FindBy(xpath="(//lightning-base-combobox//input)[1]")
	WebElement subject;
	
	@FindBy(xpath="//input[@aria-label='Date']")
	WebElement date;
	
	@FindBy(xpath="//input[@aria-label='Time']")
	WebElement time;
	
	@FindBy(xpath="(//button//span[contains(text(),'Save')])[3]")
	WebElement save;
	
	@FindBy(xpath="(//span[text()='Calendar'])[1]")
	WebElement calendar;
	
	@FindBy(xpath="//span[contains(text(),'Jansi fellow up call - automation')]")
	WebElement taskSch;
	
	
	public void createTask(String Name) throws Exception {
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		 js.executeScript("arguments[0].scrollIntoView({block: 'center'});", task);
		 js.executeScript("arguments[0].click();", task);
		 sleep(5000);
		 subject.sendKeys(Name+ " fellow up call - automation");
		 date.clear();
		 date.sendKeys("15/12/2025");
		 time.clear();
		 time.sendKeys("10:00 pm");
		 save.click();
		 sleep(10000);
	}
	
	public void verifyTask(String Name) {
		String taskName = Name+ " fellow up call - automation" ;
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(40));
		String ActualName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+taskName+"']"))).getText();
		System.out.println(taskName + " " + ActualName);
		Assert.assertEquals(taskName, ActualName);

	}
	
	public void verifyInCalendar() throws Exception {
		calendar.click();
		sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", taskSch);
		js.executeScript("arguments[0].click();", taskSch);
		sleep(10000);
	}

}
