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

  @BrowseDeal&Cost
  Scenario Outline: [TC-02]-Search on Cost tab
    Given I login to application
    And I open "/DCM_UI/browse-deals-and-costs1" "Browse Deals and Costs" screen
    When I click on "costs" tab
    And I input to "autocomplete-vendor" text-box with data "<InputVendor>"
    And I select a Vendor from smart search list with data "<InputVendor>" and "<VendorType>"
    And I click on "btn-search" button
    Then I get data of column "4" on all pages

    Examples: 
      | InputVendor | VendorType |
      |       26489 | WHS        |
