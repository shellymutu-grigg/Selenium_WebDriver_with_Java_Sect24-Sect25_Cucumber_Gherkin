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
Feature: Complete purchase order from Ecommerce site
  I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

Background:
Given user has landed on the Ecommerce site page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given user is logged in with username <username> and password <password>
    When user adds the product <productName> to cart
    	And user checks out <productName> 
    	And user submits the order
    Then <successMessage> is displayed on confirmation page

    Examples: 
      | username  								| password 							| productName 		| successMessage						|
      | shellymutugrigg@gmail.com | gazxHSwK$oBbd*c43t4S 	|	ZARA COAT 3			| THANKYOU FOR THE ORDER. 	|
      | shellymutugrigg@gmail.com | gazxHSwK$oBbd*c43t4S	|	ADIDAS ORIGINAL	| THANKYOU FOR THE ORDER. 	|
