@CreateLocationGroup
Feature: CREATE LOCATION GROUP FUNCTION
  As an automation test
  I want to create a Location Group
  So that I can verify add new function work well

  Scenario Outline: 
    Given I login to application
    And I open "/DCM_UI/create-location-group" "Create" screen
    When I click on "addBasket" button
    And I input to "basketName" text-box with data "<Group Name>"
    And I input to "abb" text-box with data "<Abbreviation>"
    And I input to "description" text-box with data "<Description>"
    And I input to "publicCmt" text-area with data "<Public Comments>"
    And I input to "privateCmt" text-area with data "<Description>"
    And I select "<Store ID>" with data "<Store ID>"
    And I click on "arrow-move-right" button
    And I click on "saveBasket" button

    Examples: 
      | Group Name    | Abbreviation | Description          | Public Comments    | Private Comments    | Store ID |
      | Add new Group | new group    | test add new locatin | add public comment | add private comment |    00001 |
