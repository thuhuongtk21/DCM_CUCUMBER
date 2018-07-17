@DealBuilder
Feature: DEALBUILDER SEARCH FUNCTION
  As an automation test
  I want to search and verify deal information
  So that I can verify search function work well

  Scenario Outline: [TC-01] Search with Cost change deal type
    Given I login to application
    And I open "/DCM_UI/deal-builder" "Deal Builder" screen
    When I input to "newIdInput" text-box with data "<OfferID>"
    And I click on "changeOffer" button
    And I get data of column "2"
    And I get data of column "3"
    And I get data of column "4"
    And I get data of column "5"
    And I get data of column "6"
    And I get data of column "7"
    And I get data of column "8"
    And I get data of column "9"
    And I get data of column "10"
    And I get data of column "11"
    And I get data of column "12"
    Examples: 
      | OfferID |  
      | 1001079 | 
