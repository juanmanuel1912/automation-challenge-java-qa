@happypath
Feature: Login Feature

  Scenario: Successful login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the home page

  @unhappypath
  Feature: Login Feature

  Scenario: Unsuccessful login due to invalid credentials
    Given I am on the login page
    When I enter invalid credentials
    Then I should see an error message
