Feature: OFFER DETAILS FUNCTION
  As an automation test
  I want to search and view offer information
  So that I can verify search function work well
  @costMaintain
  Scenario Outline: [TC-01]: ADD NEW WITH ITEM TYPE IS CLINK/ DSD/ ITEM
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

  Scenario Outline: [TC-02]: SEARCH WITH ITEM TYPE = COST LINK (just work on chrome)
    Given I login to application
    And I open "/DCM_UI/cost-maintenance" "Maintain" screen
    When I click on "item_type_selection_div" drop-down text-box
    And I select "CLINK" in drop-down list

    Examples: 
      | ItemType | CostLink | VendorNumber | VendorType | LocationType      | Location | CostType | Cost | StartDate  |
      | CLINK    |        6 |         9158 | WHS        | STORE - HEB STORE |    00006 | LIST     |  1.5 | 07/25/2018 |


  Scenario Outline: [TC-03]: SEARCH WITH ITEM TYPE = COST LINK (just work on chrome, ie)
    Given I login to application
    And I open "/DCM_UI/cost-maintenance" "Maintain" screen
    When I click on "item_type_selection_div" drop-down text-box
    And I select a value from smart search list with data "<ItemType>"
    And I input to "costLink" text-box with data "<CostLink>"
    And I press TAB key on "costLink" text-box
    Then I click on "searchIcon" button

    Examples: 
      | ItemType | CostLink | VendorNumber | VendorType | LocationType      | Location | CostType | Cost | StartDate  |
      | CLINK    |        6 |         9158 | WHS        | STORE - HEB STORE |    00006 | LIST     |  1.5 | 07/25/2018 |
