@getListVendor
Feature: OFFER CREATE FUNCTION
  As an automation test
  I want to create an offer
  So that I can verify create function work well

  Scenario Outline: [TC01] - CREATE OFFER WITH VENDOR TYPE
    Given I login to application
    And I open "/DCM_UI/offer-search" "Search" screen    
    And I click on "vendor" drop-down icon
    Then I get all vendors list

    Examples: 
      | InputVendor | VendorType | Description   | AssignToUserType | AssignToUserValue |
      |       17349 | DSD        | Add new Offer | Vendor           | v903586           |
