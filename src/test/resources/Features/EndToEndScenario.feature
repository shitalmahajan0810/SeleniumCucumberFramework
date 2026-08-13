
Feature: End To End Lead Creation Edition Deletion Functionality

 Background:
    Given the user is on login page
    When the user enter valid user id and password
    And click on login button

  @endtoendscenario
  Scenario: End To End Lead Test TC07
    When user click on new lead link
    And user enter lastname and company and click on save button
    Then lead created successfully

    When user click on leads link
    And user enter lastname and company and click on search button
    Then user can edit selected lead successfully
    And user enter lastname and company and click on search button
    And user can delete selected lead successfully