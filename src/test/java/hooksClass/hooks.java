package hooksClass;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class hooks {

    public static WebDriver driver;

    @BeforeAll
    public static void setup() throws Exception {

        // -------- Launch Browser --------
        String downloadPath = "C:\\Users\\Aswini\\Downloads";
        String profilePath = "C:\\Users\\Aswini\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\s4hgnjw7.default-release";

        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference(
                "browser.helperApps.neverAsk.saveToDisk",
                "application/pdf,application/octet-stream,application/vnd.ms-excel,text/csv");
        profile.setPreference("pdfjs.disabled", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        // -------- LOGIN ONCE --------
        driver.get("https://test.salesforce.com");

        driver.findElement(By.id("username")).sendKeys("ashwinimca96@gmail.com");

        driver.findElement(By.id("password")).sendKeys("RIS@2026");

        driver.findElement(By.id("Login")).click();

        System.out.println("✅ Logged into Salesforce once");
    }

    @AfterAll
    public static void tearDown() {

        if (driver != null) {
            driver.quit();
            System.out.println("🛑 Browser closed after all scenarios");
        }
    }
}
