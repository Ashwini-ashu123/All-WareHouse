package StepDefnFile;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import AllPages.loginCred;
import io.cucumber.java.en.*;

public class Steps {
	
	WebDriver driver;
	
	loginCred lc;
	
	public Steps() {
		  driver = new FirefoxDriver();
		  lc = new loginCred(driver);
		}
	
	
	@Given("User navigate to salesforce URL")
	public void user_navigate_to_salesforce_url() {
	    lc.saleforceURL();
	}

	@Then("Add the {string} and the {string}")
	public void add_the_and_the(String uname, String pass) {
		lc.UserNameAndPassword(uname, pass);
	    
	}

	@Then("Click on the Login button")
	public void click_on_the_login_button() throws Exception {
	  lc.loginButton();
	}

	@Then("Verify that user land on the {string} page")
	public void verify_that_user_land_on_the_page(String title) throws Exception {
		lc.verifyText(title);
	    
	}
	
	@Then("click on the Enquiries tab and verify the user navigate to Enquiry page")
	public void click_on_the_Enquiries_tab_and_verify_the_user_navigate_to_Enquiry_page() throws Exception {
	    lc.EnqClick();
	}
	
	@Then("click on the New tab and create the new Enquiry with details")
	public void click_on_the_new_tab_and_create_the_new_enquiry_with_details() throws Exception {
	    lc.NewClick();
	}
	
	@Then("Fill the {string} {string} and {string} {string}  {string}  {string} {string} {string} {string} {string}")
	public void fill_the_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
	  
	}



	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
