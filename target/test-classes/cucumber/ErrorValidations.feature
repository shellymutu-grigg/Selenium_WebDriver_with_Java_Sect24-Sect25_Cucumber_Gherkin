#Author: shellymutu-grigg
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Error validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Verify that using an incorrect password generates error message
    Given user has landed on the Ecommerce site page
    When user is logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

     Examples: 
      | username  								| password 							| 
      | shellymutugrigg@gmail.com | gazxHSwK$oBbd*c43t4S3 |	
      | shellymutugrigg@gmail.com | gazxHSwK$oBbd*c43t4S4	|	
