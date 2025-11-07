package APIpack;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restAssuredSelf {
	
    public static void main(String[] args) {
        String instanceUrl = "https://cct-ca-dev-ed.develop.my.salesforce.com";
        String accessToken = "00D5h000009Au2j!ARMAQDNRRGJ5VTuyNf.M2ToZtRv0gVqiw8clWtrCdoyRl_iZmEdDYtbg3siIbh_3y5PtP7KEO_y7oJENW2l_fsPTt_bY7jxD"; // your token
        String recordID = "a07J200000CrFLIIA3";
       
          JSONObject body = new JSONObject();
        body.put("Name", "SFTest");
        body.put("Date_Of_Birth__c", "2005-03-25");
        body.put("Contact_Numbers__c", "9876544104");
        body.put("Email__c", "dummyjfd@23.com");

       
        
        
        
        
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .post(instanceUrl + "/services/data/v63.0/sobjects/Athelete__c/");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());
        
        
        Response response1 = RestAssured.given()
        		 .header("Authorization", "Bearer " + accessToken)
                 .header("Content-Type", "application/json")
                 .get(instanceUrl + "/services/data/v63.0/sobjects/Athelete__c/");
        System.out.println(response1.prettyPrint());
        
        body.put("Date_Of_Birth__c", "2004-09-23");
        body.put("Name", "Meghan");
        
        
        Response response2 = RestAssured.given()
        		.header("Authorization", "Bearer " + accessToken)
        		.header("Content-Type", "application/json")
        		.body(body.toString())
        		.patch(instanceUrl + "/services/data/v63.0/sobjects/Athelete__c/"+recordID);
        			
        System.out.println("Update Status Code: " + response2.getStatusCode());		
        
        
        
        
        
        		
    }
}
