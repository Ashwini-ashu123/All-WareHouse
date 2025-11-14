package AllPages;

import java.time.Duration;
import static java.lang.Thread.sleep;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="(//runtime_platform_actions-actions-ribbon//button)[4]")
	WebElement dropdown;
	
	@FindBy(xpath="//span[contains(text(),'Negotiation Checklist')]")
	WebElement selectNego;
	
	@FindBy(xpath="//select[@name='Select_a_Unit_Bundle']")
	WebElement selectBundle;
	
	@FindBy(xpath="//input[@name='Save_Negotiation_Document_As']")
	WebElement docuName;
	
	@FindBy(xpath="//h2[contains(text(),'Negotiation Checklist')]")
	WebElement NegoText;
	
	@FindBy(xpath="//input[@name='1st App']")
	WebElement place;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement Save;
	
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
		wait.until(ExpectedConditions.visibilityOf(docuName)).sendKeys("Negotiation test pdf");
		wait.until(ExpectedConditions.elementToBeClickable(sv.getNext())).click();
		}
	
	public void nego_form() throws Exception {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
		sleep(5000);
		String actulText = wait.until(ExpectedConditions.visibilityOf(NegoText)).getText();
		String ExpText = "Negotiation Checklist";
		Assert.assertEquals(actulText, ExpText,"the user is not in the nego form");
		wait.until(ExpectedConditions.elementToBeClickable(place)).click();
		place.sendKeys("Kodambakkam");
		sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(Save)).click();
		sleep(5000);
		}
	
	public void verifyNego() throws Exception {
		driver.navigate().refresh();
		sleep(4000);
		String ProposalName = "Negotiation test pdf.pdf";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement fileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+ProposalName+"')]")));
		js.executeScript("arguments[0].scrollIntoView()",fileName);
		String propName = fileName.getText();
		Assert.assertEquals(ProposalName,propName,"nego pdf is not generated");
		System.out.println(ProposalName + " , " + propName);
	}

}
