Feature: End-to-end flow for All Warehouse Application for Sales rep

@Regression
Scenario Outline: Complete Sales Lifecycle from Enquiry Creation to Negotiation Stage for salesrep user
    Given User navigate to salesforce URL
    Then Add the username and the password
    And Click on the Login button

    # --- ENQUIRY CREATION ---
    Then click on the Enquiries tab and verify the user navigate to Enquiry page
    Then click on the New tab and create the new Enquiry with details
    Then Fill the details for the enquiry
    And verify the record is created successfully

    # --- ENQUIRY UPDATE ---
    Then click on the Enquiries tab and verify the user navigate to Enquiry page
    Then click on the Search button and search the Name and click it
    Then edit the enquiry details for Range and Save it
    And Add the interested location in the Enquiry  and change the status to closed 
    And Verify once done it is navigating the opportunity page with Name

    # --- OPPORTUNITY: ADD UNIT & GENERATE PROPOSAL ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Qualified" stage
    And User select the unit from search unit tab and add the unit in Options
    And Click on the generate proposal and send it to customer
    Then verify the proposal is created in Files
    Then verify the record is in "Proposal" stage

    # --- CREATE SITE VISIT ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Proposal" stage
    Then user navigate to the sitevisit and create the sitevisit
    And verify the site visit is created successfully with the Name
    Then verify the record is in "Site Visit" stage

    # --- COMPLETE SITE VISIT ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    And navigate to the site visit and check the status of the SV  and click on it
    Then verify the user is in site visit page
    And Click on the mark complete and complete the site visit process
    Then verify the site visit is marked as complete with the location update and move to Name

    # --- NEGOTIATION CHECKLIST ---
    #Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
    #And click on the search button and search the "<Name>" and click it
    Then verify the record is in "Site Visit" stage
    And Verify the site visit is completed
    Then navigate to the Negotiation checkList and create it
    And fill the checklist form and click on save
    Then verify the negotition is created in Files
    Then verify the record is in "Negotiation" stage
    And Logout from the application

Examples:
  | Run |
  | 1   |
  | 2   |
    
 @Calendar   
 Scenario: Go to calendar and verify as the Sales rep dont have access to create task in calendar
    Given User navigate to salesforce URL
    Then Add the "<Username>" and the "<Password>"
    And Click on the Login button
    And navigate to the "Calendar" and verify as the sales rep denied the access
    
 Examples:
   |Username                |Password   |
   |ashwinimca96@gmail.com  |RIS@2025   |
 
@Calendar 
Scenario: As as sales rep create the fellow-up task from the enqiury and verify it is showcase on calendar
   Given User navigate to salesforce URL
   Then Add the "<Username>" and the "<Password>"
   And Click on the Login button
   Then click on the Enquiries tab and verify the user navigate to Enquiry page
   Then click on the Search button and search the "<Name>"  and click it
   #Then click on the Task and create the task with "<Name>"
   #And Verify the fellow - up task is created with "<Name>" 
   Then navigate to calendar and verify the fellow -up task is shown
    
   Examples:
   |Username                |Password   |Name    |
   |ashwinimca96@gmail.com  |RIS@2025   |Jansi   |
   
@FilesUpload
Scenario: As sales rep upload the files from the opportunity
   Given User navigate to salesforce URL
   Then Add the "<Username>" and the "<Password>"
   And Click on the Login button
   Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
   And click on the search button and search the "<Name>" and click it
   And navigate to the files section 
   Then upload the file and verify the it shows in the file section
   
   
   Examples:
   |Username                |Password   |Name    |
   |ashwinimca96@gmail.com  |RIS@2025   |Jansi   |
   
@FilesDownload 
Scenario: As sales rep download the files from the opportunity
   Given User navigate to salesforce URL
   Then Add the "<Username>" and the "<Password>"
   And Click on the Login button
   Then navigate to the Opportunity tab and verify the user navigate to the Opportunity page
   And click on the search button and search the "<Name>" and click it
   And navigate to the files section 
   Then click on the view and download the file

  Examples:
   |Username                |Password   |Name    |
   |ashwinimca96@gmail.com  |RIS@2025   |Jansi   |
   
   