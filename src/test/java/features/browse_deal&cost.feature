@BrowseDeal&Cost
Feature: DEALS SEARCH FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: 
    Given I login to application
    And I open "/DCM_UI/browse-deals-and-costs1" "Browse Deals and Costs" screen
    When I click on "cb-location-type" drop-down list
    And I select "<DealStatus>" with data "<DealStatus>"

    Examples: 
      | DealStatus             | DealType       |
      | LOB - LINE OF BUSINESS | Flat Rate deal |
