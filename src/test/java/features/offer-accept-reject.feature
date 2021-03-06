@offerAcceptReject
Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: get infor of Trade Allowance, Cost change deal
    Given I login to application
    And I open "/DCM_UI/offer-acceptant" "Accept/Reject" screen
    When I input to "offerId" text-box with data "<OfferID>"
    And I click on "searchIcon" button

    Examples: 
      | OfferID |
      | 1001091 |
