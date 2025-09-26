Feature: Login to the all warehouse website with valid creds

@FunctionalTesting
Scenario: Navigate to salesforce URL

Given User navigate to salesforce URL
Then Add the "<Username>" and the "<Password>"
And Click on the Login button
And Verify that user land on the "All Warehouses" page
Examples:
|Username|Password|
|awhris@salesforce.com.uat|RIS@2025|



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
 | Username                  | Password  | PhoneNumber  | mail              | Name    | IntentType | Budget_Range | Nature of Purchase | Service Required | Size  | Enquiry Source | Enquiry Sub Source |
 | awhris@salesforce.com.uat | RIS@2025  | 8830751266   | test18@mail.com     |Zoya  | Tenant     | 5-10L        | Rent               | Shed             | 2500  |Online         | Google          |