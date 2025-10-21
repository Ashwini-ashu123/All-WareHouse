package StepDefnFile;

import APIpack.getCmmand;
import io.cucumber.java.en.*;

public class APIsteps {
	
	getCmmand gc = new getCmmand();
	
	@Given("the user loads the base URL")
	public void loadURL() {
		gc.getURL();
	}
	
	@When("the user gets the objects")
	public void getsObject() {
		gc.getObject();
		
	}
	
	@Then("user validate the response")
	public void validateResponse() {
		gc.validateCode();
		
	}
}
