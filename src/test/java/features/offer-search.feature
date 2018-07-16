  @offersearch
Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well
  

  Scenario Outline:
  Given I login to application
  And I open "/DCM_UI/offer-search" "Search" screen
  When I input to "offerName" text-box with data "<OfferDesc>"
  And I click on "btn-search" button
  And I get data of column "1"
  
  Examples:
  |OfferDesc|
  |HEB_2018 G|
  
  