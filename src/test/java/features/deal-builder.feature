Feature: DEALBUILDER SEARCH FUNCTION
  As an automation test
  I want to search and verify deal information
  So that I can verify search function work well

  Scenario Outline: [TC-01] Search with Cost change deal type
    Given I login to application
    And I open "/DCM_UI/deal-builder" "Deal Builder" screen
    When I input to "newIdInput" text-box with data "<OfferID>"
    And I click on "changeOffer" button
    And I get all data on all pages in "grid"

    Examples: 
      | OfferID |
      | 1001079 |

  Scenario Outline: [TC-02] Add new Trade Allowance/Flat Rate Deal to a draft offer
    Given I login to application
    And I open "/DCM_UI/deal-builder" "Deal Builder" screen
    When I input to "newIdInput" text-box with data "<OfferID>"
    And I click on "changeOffer" button
    And I click on "newDealMenu" button
    And I click on "TPR" option
    And I click on "Purchase Deal" sub option
    And I click on "PO_TPR_Item" level

    Examples: 
      | OfferID |
      | 1001079 |

  @DealBuilder
  Scenario Outline: [TC-03] Add new Offer and add Trade Allowance/Flat Rate Deal to it
    Given I login to application
    And I open "/DCM_UI/offer-create" "Create" screen
    When I input to "vendorId" text-box with data "<InputVendor>"
    And I select a Vendor from smart search list with data "<InputVendor>" and "<VendorType>"
    And I input to "descriptionId" text-box with data "<Description>"
    And I click on "availableVendors" drop-down list
    And I select "<AssignToUserType>" with data "<AssignToUserType>"
    And I input to "assignedToIdVendor" text-box with data "<AssignToUserValue>"
    And I select a value from smart search list with data "<AssignToUserValue>"
    And I click on "nextOffer" icon
    And I click on "newDealMenu" button
    And I click on "TPR" option
    And I click on "Purchase Deal" sub option
    And I click on "PO_TPR_Item" level

    Examples: 
      | InputVendor | VendorType | Description   | AssignToUserType | AssignToUserValue |
      |       17349 | DSD        | Add new Offer | Vendor           | v903586           |
