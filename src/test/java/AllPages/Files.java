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
import Utility.DownLoadHelper;

import static java.lang.Thread.sleep;
public class Files {
	
	WebDriver driver;
	
	
	public Files(WebDriver driver) {
		this.driver  =  driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='slds-page-header__name-title']")
	WebElement files;
	
	@FindBy(xpath="//button[@title='Upload Documents']")
	WebElement upload;
	
	@FindBy(xpath="//button[@aria-label='Document Type']")
	WebElement docType;
	
	@FindBy(xpath="//lightning-base-combobox-item[@data-value='Proposal Pdf']")
	WebElement pdf;
	
	@FindBy(xpath="//lightning-file-upload//input[@type='file']")
	WebElement file;
	
	@FindBy(xpath="//span[contains(text(),'Done')]")
	WebElement done;
	
	@FindBy(xpath="(//button[@title='Preview'])[1]")
	WebElement preview;
	
	@FindBy(xpath="(//button[@title='Download'])[1]")
	WebElement download;
	
	public void selectFiles() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		sleep(5000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2500);");
		sleep(5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(files));
	    sleep(5000);
	    
	}
	
	public void uploadFiles() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(upload)).click();
	    sleep(5000);
	    wait.until(ExpectedConditions.visibilityOf(docType)).click();
	    wait.until(ExpectedConditions.visibilityOf(pdf)).click();
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].style.display='block';", file);
	    wait.until(ExpectedConditions.visibilityOf(file)).sendKeys("C:\\Users\\Aswini\\Pictures\\download (2).jpg");
	    System.out.println("uploaded");
	    sleep(5000); 
	    done.click();
	    String filename = "download (2)";
	    WebElement file2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+filename+"')]")));
	    String Actualfilename = file2.getText();
	    System.out.println(filename +" " +Actualfilename);
	    Assert.assertEquals(filename, Actualfilename);
	    
	    
	}
	
	public void downloadFiles() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(preview)).click();
		wait.until(ExpectedConditions.visibilityOf(download)).click();
		sleep(10000);
		String downloadPath = "C:\\Users\\Aswini\\Downloads";
		boolean fileDownloaded = DownLoadHelper.isFileDownloaded(downloadPath,"download (2).jpg");

		if (fileDownloaded) {
		    System.out.println("File downloaded successfully");
		} else {
		    System.out.println("File not downloaded");
		}

		
	}

}
