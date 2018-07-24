@OfferCreate
Feature: OFFER CREATE FUNCTION
  As an automation test
  I want to create an offer
  So that I can verify create function work well

  Scenario Outline: [TC01] - CREATE OFFER WITH VENDOR TYPE
    Given I login to application
    And I open "/DCM_UI/offer-create" "Create" screen
    When I input to "vendorId" text-box with data "<InputVendor>"
    And  I select a value from smart search list with "<InputVendor>" and "<VendorType>"
    And I input to "descriptionId" text-box with data "<Description>"
    And I click on "assignedToUserId" drop-down list
    And I select "<AssignToUserType>" with data "<AssignToUserType>"
    And I input to "assignedToIdVendor" text-box with data "<AssignToUserValue>"
    And I select a value from smart search list with data "<AssignToUserValue>"
    And I click on "nextOffer" icon
    Then I verify offer is created successfully

    Examples: 
      | InputVendor | VendorType | Description   | AssignToUserType | AssignToUserValue |
      |       17349 | DSD        | Add new Offer | Vendor           | v903586           |
