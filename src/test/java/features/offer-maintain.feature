@OfferMaintain
Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and verify offer information
  So that I can verify search function work well

  Scenario Outline: 
    Given I login to application
    And I open "/DCM_UI/offer-maintain" "Maintain" screen
    When I input to "offerId" text-box with data "<OfferID>"
    And I click on Search icon
    Then I verify expected data at "ownId" textbox with actual data of "OWNER_UID" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify expected data at "notifyEmailId" textbox with actual data of "OWNER_EMAIL_ID" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify expected data at "descriptionId" textbox with actual data of "OFR_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
     And I verify expected data at "commentId" textarea with actual data of "PUBLIC_CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
     And I verify expected data at "HEBCommentId" textarea with actual data of "PRIV_HEB_CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"

    Examples: 
      | OfferID |  | Schema  | TableName | ColumnName |
      | 1001232 |  | DB2TST6 | OFFER     | OFFER_ID   |
