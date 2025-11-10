package hooksClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Before in hooks");
		if (driver == null) {
            
            String profilePath = "C:\\Users\\Aswini\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\s4hgnjw7.default-release";
            FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();

            System.out.println("Firefox launched with pre-authenticated profile.");
        }
		
	}
    
	@After
	public void tearDown(Scenario scenario) throws IOException {
		 try {
	            if (scenario.isFailed()) {
	             
	                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String screenshotPath = System.getProperty("user.dir") 
	                        + "/screenshots/" 
	                        + scenario.getName().replaceAll(" ", "_") 
	                        + "_" + timestamp + ".png";
                    FileUtils.copyFile(source, new File(screenshotPath));
                    System.out.println("📸 Screenshot saved at: " + screenshotPath);
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        } finally {
	            if (driver != null) {
	                driver.quit();
	            }
	            System.out.println("After hook executed - Browser closed");
	        }
	    }
		
		
		
	}

