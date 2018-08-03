@CostLinkMaintenance
Feature: COST LINK MAITENANCE FUNCTION
  As an automation test
  I want to search and verify Cost link information
  So that I can verify search function work well

  Scenario Outline: [TC-01]: Search with Cost Link ID
    Given I login to application
    And I open "/DCM_UI/cost-link-maintenance" "Cost Link Maintenance" screen
    When I input to "costLinkId" text-box with data "<CostLinkID>"
    And I press ENTER key on "costLinkId" text-box

    Examples: 
      | CostLinkID |  | Schema  | TableName       | ColumnName |
      |          6 |  | DB2TST6 | ACTIVE_DEAL_HDR | DEAL_ID    |
