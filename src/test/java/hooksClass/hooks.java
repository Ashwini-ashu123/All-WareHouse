package hooksClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Before in hooks");
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		}
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.println("After in hooks");
	}

}
