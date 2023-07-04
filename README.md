# Selenium_WebDriver_with_Java_Sect24_Cucumber_Gherkin
- Project is to be used with Cucumber and TestNG

Keywords in Cucumber:
1. Scenario - item under test 
2. Feature - business requirement
3. Feature File - test suite including all scenarios. Needs to have .feature extension
	Test that immediately follows the Feature keyword and is on the same line is the 
	title of the Feature FIle
4. Scenario Outline
5. Step Definition

GIVEN Preconditions defined for test scenario
WHEN the purpose to describe the user actions
AND additional condition
BUT negative condition
THEN the expected output from the test scenario

Cucumber layout
FEATURE: Credit Card payment
	SCENARIO: Make a minimum payment due payment 
		GIVEN user is on the Pay Credit Card Page
		WHEN user fills out all details and selects the minimum amount option
			AND user clicks on the Pay button
		THEN credit card payment confirmation page is displayed
		
	SCENARIO OUTLINE: Make a minimum payment due payment (execute with variety of data)
		GIVEN user is on the Pay Credit Card Page
		WHEN user fills out all details and selects the minimum amount option
			AND user clicks on the Pay button
		THEN credit card payment confirmation page is displayed
		EXAMPLES:
		| amountToTest | output |
		| 	0	       | fail   |
		| 	10	       | pass   |
	

Need to add a plugin from Eclipse Marketplace 
Help > 	Eclipse Marketplace > Cucumber Eclipse Plugin
Restart Eclipse

Try to get TidyGherkin Chrome plugin working