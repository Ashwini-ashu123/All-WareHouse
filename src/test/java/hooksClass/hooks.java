package hooksClass;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Before in hooks");
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		driver.quit();
		System.out.println("After in hooks");
		
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName = scenario.getName().replaceAll(" ", "_");
            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png");
            FileUtils.copyFile(src, dest);
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Failure Screenshot");
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
		}
	}

}
