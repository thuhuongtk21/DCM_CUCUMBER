
Feature: OFFER SEARCH FUNCTION
  As an automation test
  I want to search and verify offer information
  So that I can verify search function work well
@OfferMaintain

  Scenario Outline: 
    Given I login to application
    And I open "/DCM_UI/offer-maintain" "Maintain" screen
    When I input to "offerId" text-box with data "<OfferID>"
    And I click on Search icon
    Then I verify "ownId" textbox shows correctly with "OWNER_UID" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "notifyEmailId" textbox shows correctly with "OWNER_EMAIL_ID" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "descriptionId" textbox shows correctly with "OFR_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "vendorId" textbox shows correctly in format " - " with "<Column_Vendor>" from "<Schema>" "<TableName>" "<TableName1>" "<OnCondition>" "<ColumnName>" "<OfferID>"
    And I verify "commentId" textarea is showing correctly with "PUBLIC_CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "HEBCommentId" textarea is showing correctly with "PRIV_HEB_CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "offerStatusId" label shows correctly with "OFR_STAT_CD" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "statTsStr" date time label shows correctly with format "@ yyyy-MM-dd HH:mm:ss" of "OFR_CRE8D_TS" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "keyword" textbox shows correctly with "USR_SRCH_TAG_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "countingFile" label shows correctly with "NBR_OF_ATTCHS" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "createdBy" label and date time shows correctly in format " " "yyyy-MM-dd HH:mm:ss" with "<Column_Created By>" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "assignedBy" label and date time shows correctly in format " " "@ yyyy-MM-dd HH:mm:ss" with "<Column_Assigned By>" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "updatedBy" label and date time shows correctly in format " " "yyyy-MM-dd HH:mm:ss" with "<Column_Updated By>" from "<Schema>" "<TableName>" "<ColumnName>" "<OfferID>"
    And I verify "Update Alternate ID if email ID displayed is incorrect." is shown when hover on "alternateIdInfoIcon"
    And I verify "To submit Offer to a Vendor, enter a Vendor user" is shown when hover on "assignToIdInfoIcon"

    Examples: 
      | OfferID |  | Schema  | TableName | ColumnName | TableName1  | OnCondition            | Column_Vendor                 | Column_Assigned By         | Column_Created By          | Column_Updated By         |
      | 1001232 |  | DB2TST6 | OFFER     | OFFER_ID   | AP_LOCATION | tb.AP_NBR = tb1.AP_NBR | AP_NBR, RMIT_CO_NM, AP_TYP_CD | DELGTED_BY_UID, DELGTED_TS | OFR_CRE8_UID, OFR_CRE8D_TS | LST_UPDT_UID, LST_UPDT_TS |
      