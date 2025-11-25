package StepDefnFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import AllPages.Enquiry;
import AllPages.Negotiation;
import AllPages.OpportunityPage;
import AllPages.Sitevisit;
import AllPages.loginCred;
import hooksClass.hooks;
import io.cucumber.java.en.*;

public class Steps {
	
	WebDriver driver;
	
	loginCred lc;
	Enquiry enq;
	OpportunityPage Opp;
	Sitevisit sv;
	Negotiation neg;
	
	public Steps() {
		  driver = hooks.driver;
		  lc = new loginCred(driver);
		  enq =  new Enquiry(driver);
		  Opp = new OpportunityPage(driver);
		  sv = new Sitevisit(driver);
		  neg = new Negotiation(driver);
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
	public void fill_the_and(String Phone, String mail, String laname, String itype, String Budget, String nop1, String service, String size, String enqs, String enqss) throws Exception {
	    enq.Screen1Enq(Phone, mail);
	    enq.screen2A3(laname, itype);
	    enq.screen4(Budget, nop1, service, size, enqs, enqss);
	}
	
	@And("verify the record is created successfully")
	public void verify_the_record_is_created_successfully() throws Throwable  {
		enq.verifyRecText();
	}
	
	@Then("click on the Search button and search the {string}  and click it")
	public void Search_the_Enquiry(String ename) throws Exception {
		enq.enqSearchoption(ename);
	}
	
	@Then("edit the enquiry details {string} and Save it")
	public void editEnquirydetails(String range) throws Exception {
		enq.editEnquiry(range);
	}
	
	@And("Add the interested location in the Enquiry {string} {string} and change the status to closed - {string}")
	public void addInteresteLocation(String Inname1, String InRange1,String reason) throws Exception {
		enq.intrestedLocation(Inname1, InRange1);
		enq.convertToqualified(reason);
	}
	@And("Verify once done it is navigating the opportunity page with {string}")
	public void verifyNavigateToOpportunity(String Name1) {
		enq.VerifyOpportunityNavigate(Name1);
		
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
	
	@And("User select the unit from search unit tab and add {string} the unit in Options")
	public void unitAdd(String UnitName1) throws Exception {
		Opp.searchUnitAdd(UnitName1);
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
	
	@And("verify the site visit is created successfully with the {string}")
	public void verifySiteVisit(String Name1) {
		sv.verifySiteVisit(Name1);
	}
	
	@And("navigate to the site visit and check the status of in {string} and click on it")
	public void siteVisitClick(String Name1) {
		sv.VerifySVStatus_click(Name1);
	}
	
	@Then("verify the user is in site visit page")
	public void verifyinSiteVisit() throws Exception {
		sv.verify_in_SitevisitPage();
	}
	
	@And("Click on the mark complete and complete the site visit process")
	public void siteVisitProcess() throws Exception {
		sv.siteVisitProcess();
	}
	
	@Then("verify the site visit is marked as complete with the location update and move to {string}")
	public void sitevisitVerify(String Name) {
		sv.verifySiteVisitComplete(Name);
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
	
	


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
