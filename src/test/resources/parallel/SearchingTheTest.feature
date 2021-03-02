Feature: Search Feature

  Scenario:Search for the Word
    Given the user is on the google search page
    When the user Enters the search keyword
    And  the user clicks on the Search page
  	And the user validate the Signing button
  	
 Scenario: Get the signin page title
    Given the user is on the google search page
    When the user Enters the search keyword
    And  the user clicks on the Search page
  	Then the user clicks on the Signing button
  	Then the user validates the Title of the page
  	

