@LocationGroupMaintain
Feature: LOCATION GROUP MAINTAIN FUNCTION - Admin role
  As an automation test
  I want to search and verify location information
  So that I can verify search function work well

  Scenario Outline: 
    Given I login to application
    And I open "/DCM_UI/location-group-maintain" "Maintain" screen
    When I input to "basketId" text-box with data "<BasketID>"
    And I press ENTER key on "basketId" text-box
    Then I verify "basketName" textbox is showing correctly with "BSKT_NM" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "ownerId" textbox is showing correctly with "OWNER_ID" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "abb" textbox is showing correctly with "BSKT_ABB" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "description" textbox is showing correctly with "BSKT_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "publicCmt" textarea is showing correctly with "PUBLIC_CMT" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "privateCmt" textarea is showing correctly with "PRIVATE_CMT" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "countElement" label is showing correctly with "BSKT_MEM_CNT" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"
    And I verify "" drop-down is showing correctly with "BSKT_MEM_CNT" from "<Schema>" "<TableName>" "<ColumnName>" "<BasketID>"

    Examples: 
      | BasketID |  | Schema  | TableName | ColumnName | TableName1   | On condition                           | Column_Domain                 | Column_Type        | Column_Created By          | Column_Updated By         |
      |     1876 |  | DB2TST6 | BASKET    | BSKT_ID    | ALERT_DOMAIN | tb.ALRT_DOMAIN_CD = tb1.ALRT_DOMAIN_CD | ALRT_DOMAIN_CD, ALRT_DOMAIN_DES | BSKT_TYP_CD, BSKT_TYP_DES | OFR_CRE8_UID, OFR_CRE8D_TS | LST_UPDT_UID, LST_UPDT_TS |
