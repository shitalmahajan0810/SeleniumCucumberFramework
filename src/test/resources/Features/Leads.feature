Feature: Leads Functionality


  Background:
    Given the user is on login page
    When the user enter valid user id and password
    And click on login button

  @lead
  Scenario:  Create  Leads TC03
    When user click on new lead link
    And user enter lastname and company and click on save button
    Then lead created successfully

  @createleadalert @lead
  Scenario:  New Lead Alert TC04
    When user click on new lead link
    And user enter lastname only and click on save button
    Then lead alert generated for mandatory fields

  @leadMultiple
  Scenario:  Create  Multiple Leads TC05
    When user click on new lead link
    And user enter lastname as "<lastname>"  and company as "<company>" and click on save button
    | lastname| company|
    |Sahani   | mPhatek |
    |Mahajan  | TCS     |
    | Upadhyay | BNY    |
    Then lead created successfully

  @leadsearchdelete @lead
  Scenario:  Search Lead and delete TC06
    When user click on leads link
    And user enter lastname and company and click on search button
    Then user can delete selected lead successfully

  @leadDD
  Scenario:  Create  Leads TC08
    When user click on new lead link
    And user enter firstname with salutationtype DD
    And user enter lastname and company and click on save button
    Then lead created successfully


  @leadDnD
  Scenario:  Create  Leads TC09
    When user click on My Account link
    And user select Customize Tab
    Then user is able to drag and drop tabs successfully






