package AllPages;

import java.time.Duration;
import static java.lang.Thread.sleep;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Negotiation {
	WebDriver driver;
	Sitevisit sv;
	
	public Negotiation(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
		sv = new Sitevisit(driver);
	}
	
	@FindBy(xpath="(//lightning-button-menu//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last'])[2]")
	WebElement dropdown;
	
	@FindBy(xpath="//span[contains(text(),'Negotiation Checklist')]")
	WebElement selectNego;
	
	@FindBy(xpath="//select[@name='Select_a_Unit_Bundle']")
	WebElement selectBundle;
	
	public void checkSiteVisit() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(sv.getArticle()));
		String article = sv.getArticle().getText();
		Assert.assertTrue(article.contains("Completed"),"No the site visit is not completed");
	}
	
	public void Click_Nego() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		sleep(5000);
		WebElement drop = wait.until(ExpectedConditions.visibilityOf(dropdown));
		drop.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectNego)).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectBundle)).click();
		Select sel = new Select(selectBundle);
		sel.selectByIndex(1);  
		sleep(5000);
		
		
	}

}
