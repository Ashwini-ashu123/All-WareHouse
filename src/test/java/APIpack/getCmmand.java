package APIpack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

public class getCmmand {
	
	public void getURL() {
		RestAssured.baseURI = "https://allwarehouses--awhuat.sandbox.my.salesforce.com/services/data/v63.0/sobjects/";
	}
	
	public void getObject() {
		Response res = RestAssured.given()
//				.header("Authorization", "Bearer " + accessToken)
				.when().get("/Enquiry__c");
		System.out.println(res.getBody().asPrettyString());
	}
	
	public void validateCode() {
		  ValidatableResponse res = RestAssured.given()
	                .when()
	                .get("Enquiry__c")
	                .then()
	                .statusCode(200);
	}

}
