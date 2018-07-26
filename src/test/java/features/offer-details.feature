@offerdetails
Feature: OFFER DETAILS FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: [TC-01]: Type = Trade Allowance - Status = Submitted
    Given I login to application
    And I open "/DCM_UI/offer-search" "Search" screen
    When I input to "offerId" text-box with data "<OfferID>"
    And I click on "btn-search" button
    And I right click on a record which contains "<OfferID>" value
    And I select "Offer Details" option
    Then I verify "OFFER DETAILS" screen is open correctly
    And I verify "offer-search-input" is shown correctly with selected Item "<OfferID>"

    Examples: 
      | OfferID |
      | 1001091 |