Feature: Account Functionality
  Background:
    Given the user is on login page
    When the user enter valid user id and password
    And click on login button

  @accountCreationMultiple
  Scenario: New accounts creation
    When user click on new account link
    And user enter accountname as "<acname>"  and phone as "<phoneno>" and click on save button
      | acname | phoneno |
      | Sahani   | 1234567910 |
      | Mahajan  | 2345678910 |
      | Upadhyay | 3456789120 |
Then Accounts created successfully



  @accountCreationMultiple
  Scenario: New accounts creation
    When user click on new account link
    And user enter accountname as "<acname>"  and phone as "<phoneno>" and click on save button
      | acname | phoneno |
      | Sahani   | 1234567910 |
      | Mahajan  | 2345678910 |
      | Upadhyay | 3456789120 |
    Then Accounts created successfully
