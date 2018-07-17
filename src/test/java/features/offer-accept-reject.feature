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

    Examples: 
      | OfferID |
      |  176981 |
