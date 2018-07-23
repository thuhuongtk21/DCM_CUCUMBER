@offerReview
Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: View offer infor
    Given I login to application
    And I open "/DCM_UI/offer-review" "Review" screen
    When I input to "offerId" text-box with data "<OfferID>"
    And I click on "searchIcon" button

    Examples: 
      | OfferID |
      | 1001091 |
