Feature: Login to the all warehouse website with valid creds


Scenario: Navigate to salesforce URL

Given User navigate to salesforce URL
Then Add the "<Username>" and the "<Password>"
And Click on the Login button
And Verify that user land on the "All Warehouses" page
Examples:
|Username|Password|
|awhris@salesforce.com.uat|1RIS@2025|


Scenario: User navigate to the Enquires tab

Given User navigate to salesforce URL
Then Add the "<Username>" and the "<Password>"
And Click on the Login button
#And Verify that user land on the "All Warehouses" page
Then click on the Enquiries tab and verify the user navigate to Enquiry page
Then click on the New tab and create the new Enquiry with details
Then Fill the "<PhoneNumber>" "<mail>" and "<Name>" "<IntentType>"  "<Budget_Range>"  "<Nature of Purchase>" "<Service Required>" "<Size>" "<Enquiry Source>" "<Enquiry Sub Source>"
And verify the record is created successfully
Examples:
 | Username                  | Password  | PhoneNumber  | mail                 | Name    | IntentType | Budget_Range | Nature of Purchase | Service Required | Size  | Enquiry Source | Enquiry Sub Source |
 | ashwinimca96@gmail.com    | RIS@2025  | 8400674656   | sdfjdiej@mail.com    |Vignesh     | Tenant     | 5-10L        | Rent               | Land             | 2500  |Online         | Google          |
 
 
Scenario: Navigate to Enquiry record and fill the other details
 Given User navigate to salesforce URL
 Then Add the "<Username>" and the "<Password>"
 And Click on the Login button
 Then click on the Enquiries tab and verify the user navigate to Enquiry page
 Then click on the Search button and search the "<Name>"  and click it
 Then edit the enquiry details "<Range>" and Save it
 And Add the interested location in the Enquiry "<Interested Name>" "<Interested Range>" and change the status to closed - "<Reason>"
 And Verify once done it is navigating the opportunity page with "<Name>"
 Examples:
  |Username                |Password |Name     |Range      | Interested Name |Interested Range|Reason|
  |ashwinimca96@gmail.com  |RIS@2025 |Vignesh  |below 10000| Parrays1      |15             |Qualified|
 

 Scenario:Add the enquiry details using the API
 Given the user loads the base URL
 When the user gets the objects
 Then user validate the response
 
 