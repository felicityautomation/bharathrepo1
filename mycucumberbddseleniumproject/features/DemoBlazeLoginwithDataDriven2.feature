#Author: Bharath
#Feature: List of scenarios related to Login Module
Feature: Login feature of DemoBlaze Application

  Scenario Outline: Test valid login functionality
    Given user opened the browser
    When user navigated to DemoBlaze Application URL
    And clicks on Login link
    And user enters user name and password by referring to the excel file "testdata/login.xlsx" and sheet "LoginDataSheet"
    And click on Login button
    Then the home page is displayed

    Examples: 
      | username    | password |
      | bharathedu1 |   123456 |
      | bharathedu2 | welcome1 |
