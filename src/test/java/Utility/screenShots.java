package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShots {
	 public static String takeScreenshot(WebDriver driver, String screenshotName) {
	        String dateName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + dateName + ".png";
	        File finalDestination = new File(destination);

	        try {
	            FileUtils.copyFile(source, finalDestination);
	            System.out.println("Screenshot saved: " + destination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return destination;
	    }
	}


