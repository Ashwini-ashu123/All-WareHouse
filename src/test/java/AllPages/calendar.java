package AllPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar {
	
	WebDriver driver;
	
	public calendar(WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='fullcalendarjs fc fc-unthemed fc-ltr']//h2")
	WebElement monthName;
	
	public void navigateTab(String TabName) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(40));
		WebElement Tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='" +TabName+"'])[1]")));
		Tab.click();
		String Currentmonth = monthName.getText();
		System.out.println(Currentmonth);
		
		
		
	}

}
