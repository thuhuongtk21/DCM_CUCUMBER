Feature: DEAL MAINTAIN FUNCTION
  As an automation test
  I want to search and verify offer information
  So that I can verify search function work well

  Scenario Outline: [Tc-01]: Search with Flat Rate Deal
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify expected data at "deal-des-input" textbox with actual data of "DEAL_DES" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify expected data at "comment-input" textarea with actual data of "CMT_TXT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify expected data at "contract-nbr-lbl" label with actual data of "CONTRACT_NBR" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"
    And I verify expected data at "dt-start-date-input" date time textbox with actual data of "DEAL_EFF_DT" from "<Schema>" "<TableName>" "<ColumnName>" "<DealID>"

    Examples: 
      | DealID |  | Schema  | TableName       | ColumnName |
      | 200476 |  | DB2TST6 | ACTIVE_DEAL_HDR | DEAL_ID    |

  Scenario Outline: [TC-02]: Search with Flat Rate Deal
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify expected data at "deal-des-input" textbox with actual data of "DEAL_DES" from "<From>" "<Where>"

    Examples: 
      | DealID |  | Schema  |  | From                      | Where            |
      | 200476 |  | DB2TST6 |  | ${Schema}.ACTIVE_DEAL_HDR | DEAL_ID = 200476 |

  Scenario Outline: [TC-02]: Search with Flat Rate Deal
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify expected data at "vendor-des-lbl" label with actual data of "AP_NBR" from "<From>" "<Where>"

    Examples: 
      | DealID |  | From                    | Where            |
      | 200476 |  | DB2TST6.ACTIVE_DEAL_HDR | DEAL_ID = 200476 |

  @DealMaintain
  Scenario Outline: [TC-03]: Search with Flat Rate Deal
    Given I login to application
    And I open "/DCM_UI/deal-maintenance" "Maintain" screen
    When I input to "deal-search-input" text-box with data "<DealID>"
    And I click on "deal-search-btn" button
    Then I verify expected data at "vendor-des-lbl" label with actual data of "AP_NBR" "AP_TYP_CD" from "<From>" "<Where>"

    Examples: 
      | DealID |  | From                    | Where            |
      | 200476 |  | DB2TST6.ACTIVE_DEAL_HDR | DEAL_ID = 200476 |
