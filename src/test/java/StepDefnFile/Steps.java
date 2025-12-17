package StepDefnFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import AllPages.Enquiry;
import AllPages.Files;
import AllPages.Negotiation;
import AllPages.OpportunityPage;
import AllPages.Sitevisit;
import AllPages.calendar;
import AllPages.loginCred;
import AllPages.task;
import hooksClass.hooks;
import io.cucumber.java.en.*;
import Utility.TestDataContext;

public class Steps {
	
	WebDriver driver;
	
	loginCred lc;
	Enquiry enq;
	OpportunityPage Opp;
	Sitevisit sv;
	Negotiation neg;
	calendar cal;
	task tsk;
	Files fil;
	
	public Steps() {
		  driver = hooks.driver;
		  lc = new loginCred(driver);
		  enq =  new Enquiry(driver);
		  Opp = new OpportunityPage(driver);
		  sv = new Sitevisit(driver);
		  neg = new Negotiation(driver);
		  cal = new calendar(driver);
		  tsk = new task(driver);
		  fil = new Files(driver);
		}
	
	
	@Given("User navigate to salesforce URL")
	public void user_navigate_to_salesforce_url() {
	    lc.saleforceURL();
	}

	@Then("Add the username and the password")
	public void add_the_and_the() {
		lc.UserNameAndPassword(TestDataContext.get("Username"),TestDataContext.get("Password"));
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
	
	@Then("Fill the details for the enquiry")
	public void fill_the_and() throws Exception {
	    enq.Screen1Enq(TestDataContext.get("PhoneNumber"), TestDataContext.get("mail"));
	    enq.screen2A3(TestDataContext.get("Name"), TestDataContext.get("IntentType"));
	    enq.screen4(TestDataContext.get("Budget_Range"),TestDataContext.get("NatureOfPurchase"),TestDataContext.get("ServiceRequired"),TestDataContext.get("Size"),TestDataContext.get("EnquirySource"),TestDataContext.get("EnquirySubSource"));
	}
	
	@And("verify the record is created successfully")
	public void verify_the_record_is_created_successfully() throws Throwable  {
		enq.verifyRecText();
	}
	
	@Then("click on the Search button and search the Name and click it")
	public void Search_the_Enquiry() throws Exception {
		enq.enqSearchoption(TestDataContext.get("Name"));
	}
	

	
	@Then("edit the enquiry details for Range and Save it")
	public void editEnquirydetails() throws Exception {
		enq.editEnquiry(TestDataContext.get("Range"));
	}
	
	@And("Add the interested location in the Enquiry  and change the status to closed")
	public void addInteresteLocation() throws Exception {
		enq.intrestedLocation(TestDataContext.get("InterestedName"), TestDataContext.get("InterestedRange"));
		enq.convertToqualified(TestDataContext.get("Reason"));
	}
	
	@And("Verify once done it is navigating the opportunity page with Name")
	public void verifyNavigateToOpportunity() {
		enq.VerifyOpportunityNavigate(TestDataContext.get("Name"));
		
	}
	
	@Then("navigate to the Opportunity tab and verify the user navigate to the Opportunity page")
	public void oppTab() throws Exception {
		Opp.SelectOpp();
		
	}
	
	@And("click on the search button and search the {string} and click it")
	public void searchOpp(String Oppname) throws Exception {
		Opp.searchField(Oppname);
		
	}
	
	@Then("verify the record is in {string} stage")
	public void verifyStage(String stage) throws Exception {
		Opp.VerifyStage(stage);
	}
	
	@And("User select the unit from search unit tab and add the unit in Options")
	public void unitAdd() throws Exception {
		Opp.searchUnitAdd(TestDataContext.get("UnitName"));
	}
	
	@And("Click on the generate proposal and send it to customer")
	public void generateProp() throws Exception {
		Opp.generatePropsal();
	}
	
	@Then("verify the proposal is created in Files")
	public void proposalVerify() throws Exception {
		Opp.verifyPropGenerate();
	}
	
	@Then ("user navigate to the sitevisit and create the sitevisit")
	public void sitevisit_Schedule() throws Exception {
		sv.schSiteVisit();
	}
	
	@And("verify the site visit is created successfully with the Name")
	public void verifySiteVisit() {
		sv.verifySiteVisit(TestDataContext.get("Name"));
	}
	
	@And("navigate to the site visit and check the status of the SV  and click on it")
	public void siteVisitClick() {
		sv.VerifySVStatus_click(TestDataContext.get("Name"));
	}
	
	@Then("verify the user is in site visit page")
	public void verifyinSiteVisit() throws Exception {
		sv.verify_in_SitevisitPage();
	}
	
	@And("Click on the mark complete and complete the site visit process")
	public void siteVisitProcess() throws Exception {
		sv.siteVisitProcess();
	}
	
	@Then("verify the site visit is marked as complete with the location update and move to Name")
	public void sitevisitVerify() throws Exception {
		sv.verifySiteVisitComplete(TestDataContext.get("Name"));
	}
	
	@And("Verify the site visit is completed")
	public void verifyCompletedSV() {
		neg.checkSiteVisit();
	}
	
	@Then("navigate to the Negotiation checkList and create it")
	public void CreateNego() throws Exception {
		neg.Click_Nego();

	}
	
	@And("fill the checklist form and click on save")
	public void getForm() throws Exception {
		neg.nego_form();
	}
	
	@Then("verify the negotition is created in Files")
	public void verifyFiles() throws Exception {
		neg.verifyNego();
	}
	
	@And("navigate to the {string} and verify as the sales rep denied the access")
	public void calendarTab(String calendar) throws Exception {
		cal.navigateTab(calendar);
	}
	
	@Then("click on the Task and create the task with {string}")
	public void taskCreate(String Name) throws Exception {
		tsk.createTask(Name);
	}
	
	@And("Verify the fellow - up task is created with {string}")
	public void verifyTask(String Name) {
		tsk.verifyTask(Name);
	}
	
	@Then("navigate to calendar and verify the fellow -up task is shown")
	public void verifyInCalendar() throws Exception {
		tsk.verifyInCalendar();
	}
	
	@And("navigate to the files section")
	public void files() throws Exception {
		fil.selectFiles();
		
	}
	
	@Then("upload the file and verify the it shows in the file section")
	public void uploadFiles() throws Exception {
		fil.uploadFiles();
	}
	
	@Then("click on the view and download the file")
	public void downloadFiles() throws Exception {
		fil.downloadFiles();
	}
	
	@And("Logout from the application")
	public void logout() {
		
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
