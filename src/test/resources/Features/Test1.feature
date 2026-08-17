@Login @smoke
Feature: Login Functionality

      Background:
        Given the user is on login page
      @valid
      Scenario: Valid Login_TC01
       When the user enter valid user id and password
       And click on login button
       Then the user can enter on Home page

        @InvalidLogin
      Scenario: Invalid Login_TC02
        When the user enter invalid user id and password
        And click on login button
        Then the user can enter on login page only





