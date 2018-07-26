Feature: COST MAINTAIN FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well

  Scenario Outline: [TC-01]: ADD NEW WITH ITEM TYPE IS CLINK/ DSD/ ITEM --> Error
    Given I login to application
    And I open "/DCM_UI/cost-maintenance" "Maintain" screen
    When I click on "add" button
    And I click on "item_type_selection_div" drop-down text-box
    And I select "<ItemType>" in drop-down list
    And I input to "costLink" text-box with data "<CostLink>"
    And I press TAB key on "costLink" text-box
    And I input to "vendor" text-box with data "<VendorNumber>"
    And I select a value from smart search list with "<VendorNumber>" and "<VendorType>"
    And I click on "location_type_selection_div" drop-down text-box
    And I select a value from smart search list with data "<LocationType>"
    And I click on "location_selection_div" drop-down text-box
    And I select a value from smart search list with data "<Location>"
    And I click on "cost_type_selection_div" drop-down text-box
    And I select a value from smart search list with data "<CostType>"
    And I input to "cost_num" text-box with data "<Cost>"
    And I input to "date_start_input" text-box with data "<Cost>"
    And I click on "save" button

    Examples: 
      | ItemType | CostLink | VendorNumber | VendorType | LocationType      | Location | CostType | Cost | StartDate  |
      | CLINK    |        6 |         9158 | WHS        | STORE - HEB STORE |    00006 | LIST     |  1.5 | 07/25/2018 |

  Scenario Outline: [TC-02]: SEARCH WITH ITEM TYPE = COST LINK (just work on chrome, ie) --> Just correct with item has one SEQ_NBR
    Given I login to application
    And I open "/DCM_UI/cost-maintenance" "Maintain" screen
    When I click on "item_type_selection_div" drop-down text-box
    And I select a value from smart search list with data "<ItemType>"
    And I input to "costLink" text-box with data "<CostLink>"
    And I press TAB key on "costLink" text-box
    And I click on "searchIcon" button
    Then I verify expected data at "vendor" textbox with actual data "VEND_LOC_NBR" from "<Database>"
    And I verify expected data at "costId" textbox with actual data "SEQ_NBR" from "<Database>"

    Examples: 
      | ItemType | CostLink | Database                                                                            |
      | CLINK    |    18519 | db2tst6.CST_PAST_PRES_FUTR where ITM_PROD_ID = 18519  and ITM_PROD_KEY_CD = 'CLINK' |

  @costMaintain
  Scenario Outline: [TC-03]: SEARCH WITH ITEM TYPE = COST LINK (just work on chrome, ie) --> Just correct with item has one SEQ_NBR
    Given I login to application
    And I open "/DCM_UI/cost-maintenance" "Maintain" screen
    When I click on "item_type_selection_div" drop-down text-box
    And I select a value from smart search list with data "<ItemType>"
    And I input to "costLink" text-box with data "<CostLink>"
    And I press TAB key on "costLink" text-box
    And I click on "searchIcon" button
    Then I verify expected data at "vendor" textbox with actual data of "VEND_LOC_NBR" from "<Schema>" "<TableName>" "<ColumnName>" "<CostLink>"
    And I verify expected data at "costId" textbox with actual data of "SEQ_NBR" from "<Schema>" "<TableName>" "<ColumnName>" "<CostLink>"

    Examples: 
      | ItemType | CostLink | Schema  | TableName          | ColumnName  |
      | CLINK    |    18519 | DB2TST6 | CST_PAST_PRES_FUTR | ITM_PROD_ID |
