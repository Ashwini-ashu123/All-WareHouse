package hooksClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utility.ExcelReader;

public class hooks {

    public static WebDriver driver;
    private static int currentRow = 1; // Row 0 = Header

    @Before
    public void setup() throws Exception {

        // Load Excel data for this scenario
        ExcelReader.loadRowData(currentRow);

        String downloadPath = "C:\\Users\\Aswini\\Downloads";
        String profilePath = "C:\\Users\\Aswini\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\s4hgnjw7.default-release";

        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/pdf,application/octet-stream,application/vnd.ms-excel,text/csv");
        profile.setPreference("pdfjs.disabled", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        System.out.println("🔥 Firefox launched for row: " + currentRow);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        try {
            if (scenario.isFailed() && driver != null) {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = System.getProperty("user.dir")
                        + "/screenshots/"
                        + scenario.getName().replaceAll(" ", "_")
                        + "_" + timestamp + ".png";
                FileUtils.copyFile(source, new File(screenshotPath));
                System.out.println("📸 Screenshot saved at: " + screenshotPath);
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
            currentRow++; // ✅ move to next Excel row only after scenario ends
            System.out.println("✅ Scenario completed. Moving to Excel row: " + currentRow);
        }
    }
}
