Feature: DEAL MAINTAIN FUNCTION
  As an automation test
  I want to search and verify offer information
  So that I can verify search function work well

  Scenario Outline: [TC-01]: Search with Flat Rate Deal
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify "deal-des-input" textbox shows correctly with "DEAL_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "comment-input" textarea is showing correctly with "CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "contract-nbr-lbl" label shows correctly with "CONTRACT_NBR" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "dt-start-date-input" date time textbox shows correctly with "DEAL_EFF_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"

    Examples: 
      | DealID |  | Schema  | TableName       | ColumnName |
      | 200476 |  | DB2TST6 | ACTIVE_DEAL_HDR | DEAL_ID    |

  @DealMaintain
  Scenario Outline: [TC-02]: Search with Trade Allowance Deal - Open Status
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify "deal-des-input" textbox shows correctly with "DEAL_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "comment-input" textarea is showing correctly with "CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "contract-nbr-lbl" label shows correctly with "CONTRACT_NBR" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "dt-start-date-input" date time textbox shows correctly with format "/yyyy-mm-dd" of "DEAL_EFF_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "dt-end-date-input" date time textbox shows correctly with format "/yyyy-mm-dd" of "DEAL_EXPR_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "org-start-date-label" date time label shows correctly with format "/yyyy-mm-dd" of "DEAL_ORIG_EFF_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "org-end-date-label" date time label shows correctly with format "/yyyy-mm-dd" of "DEAL_ORIG_EXPR_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I click on "LOCGP 000001518 - 00017276-07-A-03" hyperlink
    And I verify "c-vendor-des-lbl" label shows correctly in format " " with "<Column_Vendor>" from "<Schema>" "<TableName>" "<TableName1>" "<OnCondition>" "<ColumnName>" "<DealID>"
    And I verify "c-deal-status-lbl" label and date time shows correctly in format " " "@ yyyy-MM-dd HH:mm:ss" with "<Column_DealStatus>" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "bar-vendor-des" label shows correctly with "DEAL_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "bar-deal-type" label shows correctly with "DEAL_TYP_CD" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "bar-deal-lvl" label shows correctly with "DEAL_LVL_CD" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "bar-start-dt" date time label shows correctly with format "/yyyy-mm-dd" of "DEAL_EFF_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify "bar-end-dt" date time label shows correctly with format "/yyyy-mm-dd" of "DEAL_EXPR_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify all "item-type-input" on UI with "DEAL_ENTY_ID" from "<Schema>" "<TableName2>" "<ColumnName>" "<DealID>" and verify with "ITM_KEY_TYP_CD" from "<Schema>" "<TableName3>" "<ColumnName3>"
    And I verify all "item-desc-input" on UI with "DEAL_ENTY_ID" from "<Schema>" "<TableName2>" "<ColumnName>" "<DealID>" and verify with "ITEM_DES" from "<Schema>" "<TableName3>" "<ColumnName3>"
    And I verify all "item-pack-input" on UI with "DEAL_ENTY_ID" from "<Schema>" "<TableName2>" "<ColumnName>" "<DealID>" and verify with "HEB_ITM_PK" from "<Schema>" "<TableName3>" "<ColumnName3>"

    Examples: 
      | DealID |  | Schema  | TableName       | ColumnName | TableName1  | OnCondition                                             | Column_Vendor                 | Column_DealStatus              | TableName2       | TableName3  | ColumnName3 |
      | 968915 |  | DB2TST6 | ACTIVE_DEAL_HDR | DEAL_ID    | AP_LOCATION | tb.AP_NBR = tb1.AP_NBR and tb.AP_TYP_CD = tb1.AP_TYP_CD | AP_NBR, RMIT_CO_NM, AP_TYP_CD | ACTV_DEAL_STAT_CD, LST_UPDT_TS | ACTIVE_DEAL_TERM | ITEM_MASTER | ITM_ID      |
