Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: [TC-01]: Search with Offer Description
    Given I login to application
    And I open "/DCM_UI/offer-search" "Search" screen
    When I input to "offerName" text-box with data "<OfferDesc>"
    And I click on "btn-search" button
    And I get data of column "1" on all pages

    Examples: 
      | OfferDesc  |
      | HEB_2018 G |

  Scenario Outline: [TC-02]: Search with Assigned To
    Given I login to application
    And I open "/DCM_UI/offer-search" "Search" screen
    When I input to "submittedTo" text-box with data "<Assigned To>"
    And I select a value from smart search list with data "<Assigned To>"
    And I click on "btn-search" button
    And I get data of column "1" on all pages

    Examples: 
      | Assigned To |
      | p363547     |

  @offersearch
  Scenario Outline: [TC-03]: Search with Offer description, Vendor, Assigned To
    Given I login to application
    And I open "/DCM_UI/offer-search" "Search" screen
    When I input to "offerName" text-box with data "<OfferDesc>"
    And I input to "vendor" text-box with data "<VendorNumber>"
    And I select a Vendor from smart search list with data "<VendorNumber>" and "<VendorType>"
    And I input to "submittedTo" text-box with data "<Assigned To>"
    And I select a value from smart search list with data "<Assigned To>"
    And I click on "btn-search" button
    And I get data of column "1" on all pages

    Examples: 
      | OfferDesc | VendorNumber | VendorType | Assigned To |
      | HEB       |        17349 | DSD        | e127847     |
