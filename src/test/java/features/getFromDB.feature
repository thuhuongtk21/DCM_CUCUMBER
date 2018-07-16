
@getFromDB
Feature: get from DB

Scenario Outline:
When I get "OWNER_EMAIL_ID" from "<Schema>" "<TableName>" "<ColumnName>" "<Value>"

Examples: 
|Schema|TableName|ColumnName|Value|
|DB2TST6|OFFER|OFFER_ID|1001232|