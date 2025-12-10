Feature: End-to-end flow for All Warehouse Application

Scenario: Complete Sales Lifecycle from Enquiry Creation to Negotiation Stage for salesrep user
    Given User navigate to salesforce URL
    Then Add the "<Username>" and the "<Password>"
    And Click on the Login button

    # --- ENQUIRY CREATION ---
    Then click on the Enquiries tab and verify the user navigate to Enquiry page
    Then click on the New tab and create the new Enquiry with details
    #Then Fill the "<PhoneNumber>" "<mail>" and "<Name>" "<IntentType>"  "<Budget_Range>"  "<Nature of Purchase>" "<Service Required>" "<Size>" "<Enquiry Source>" "<Enquiry Sub Source>"
    #And verify the record is created successfully

    # --- ENQUIRY UPDATE ---
    Then click on the Enquiries tab and verify the user navigate to Enquiry page
    Then click on the Search button and search the "<Name>"  and click it
    Then edit the enquiry details "<Range>" and Save it
    And Add the interested location in the Enquiry "<InterestedName>" "<InterestedRange>" and change the status to closed - "<Reason>"
    And Verify once done it is navigating the opportunity page with "<Name>"

    # --- OPPORTUNITY: ADD UNIT & GENERATE PROPOSAL ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Qualified" stage
    And User select the unit from search unit tab and add "<UnitName>" the unit in Options
    And Click on the generate proposal and send it to customer
    Then verify the proposal is created in Files
    Then verify the record is in "Proposal" stage

    # --- CREATE SITE VISIT ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Proposal" stage
    Then user navigate to the sitevisit and create the sitevisit
    And verify the site visit is created successfully with the "<Name>"
    Then verify the record is in "Site Visit" stage

    # --- COMPLETE SITE VISIT ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    And navigate to the site visit and check the status of in "<Name>" and click on it
    Then verify the user is in site visit page
    And Click on the mark complete and complete the site visit process
    Then verify the site visit is marked as complete with the location update and move to "<Name>"

    # --- NEGOTIATION CHECKLIST ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Site Visit" stage
    And Verify the site visit is completed
    Then navigate to the Negotiation checkList and create it
    And fill the checklist form and click on save
    Then verify the negotition is created in Files
    Then verify the record is in "Negotiation" stage

Examples:
    | Username               | Password | PhoneNumber | mail                | Name        | IntentType | Budget_Range | Nature of Purchase | Service Required | Size | Enquiry Source | Enquiry Sub Source | Range      | InterestedName | InterestedRange | Reason    | UnitName               |
    | ashwinimca96@gmail.com | RIS@2025 | 9984756432  | jansi@jdkfk.com     | Jansi       | Tenant     | 5-10L        | Rent               | Land             | 2500 | Online         | Google             | below 10000 | Egmore         | 15              | Qualified | Vellore ILocation test |
    
    
 Scenario: Go to calendar and verify as the Sales rep dont have access to create task in calendar
    Given User navigate to salesforce URL
    Then Add the "<Username>" and the "<Password>"
    And Click on the Login button
    And navigate to the "Calendar" and verify as the sales rep denied the access
    
 Examples:
   |Username                |Password   |
   |ashwinimca96@gmail.com  |RIS@2025   |
    
Scenario: As as sales rep create the fellow-up task from the enqiiry and verify it is showcase on calendar
   Given User navigate to salesforce URL
   Then Add the "<Username>" and the "<Password>"
   And Click on the Login button
   Then click on the Enquiries tab and verify the user navigate to Enquiry page
   Then click on the Search button and search the "<Name>"  and click it
   Then click on the Task and create the task
 
  Examples:
   |Username                |Password   |Name    |
   |ashwinimca96@gmail.com  |RIS@2025   |Jansi   |

