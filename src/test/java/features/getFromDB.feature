Feature: get from DB

  Scenario Outline: 
    When I get "OWNER_EMAIL_ID" from "<Schema>" "<TableName>" "<ColumnName>" "<Value>"

    Examples: 
      | Schema  | TableName | ColumnName | Value   |
      | DB2TST6 | OFFER     | OFFER_ID   | 1001232 |

  Scenario Outline: 
    When I try to get "<List columns2>" from "<Schema>" "<TableName>" "<TableName1>" "<ColumnName>" "<OfferID>"

    Examples: 
      | Schema  | TableName | ColumnName | Value   | TableName1  | List columns                  | List columns1                                             | List columns2              |
      | DB2TST6 | OFFER     | OFFER_ID   | 1001232 | AP_LOCATION | AP_NBR, RMIT_CO_NM, AP_TYP_CD | RMIT_ADR_1, RMIT_CTY, RMIT_ST, RMIT_ZIP5_CD, RMIT_ZIP4_CD | DELGTED_BY_UID, DELGTED_TS |

  Scenario Outline: 
    And I get " " "yyyy-MM-dd HH:mm:ss" with "<List columns 1>" from "<Schema>" "<TableName>" "<TableName1>" "<ColumnName>" "<OfferID>"

    Examples: 
      | Schema  | TableName | ColumnName | Value   | TableName1  | List columns                  | List columns1                                             | List columns2              |
      | DB2TST6 | OFFER     | OFFER_ID   | 1001232 | AP_LOCATION | AP_NBR, RMIT_CO_NM, AP_TYP_CD | RMIT_ADR_1, RMIT_CTY, RMIT_ST, RMIT_ZIP5_CD, RMIT_ZIP4_CD | DELGTED_BY_UID, DELGTED_TS |

  @getFromDB
  Scenario Outline: 
    And item "DEAL_ENTY_ID" from "<Schema>" "<TableName2>" "<ColumnName>" "<DealID>" and verify with "ITM_KEY_TYP_CD" from "<Schema>" "<TableName3>" "<ColumnName3>"

    Examples: 
      | DealID |  | Schema  | TableName       | ColumnName | TableName1  | OnCondition                                             | Column_Vendor                 | Column_DealStatus              | TableName2       | TableName3  | ColumnName3 |
      | 968915 |  | DB2TST6 | ACTIVE_DEAL_HDR | DEAL_ID    | AP_LOCATION | tb.AP_NBR = tb1.AP_NBR and tb.AP_TYP_CD = tb1.AP_TYP_CD | AP_NBR, RMIT_CO_NM, AP_TYP_CD | ACTV_DEAL_STAT_CD, LST_UPDT_TS | ACTIVE_DEAL_TERM | ITEM_MASTER | ITM_ID      |
