Feature: Search Feature point two

  Scenario:Search for the Word
    Given the user is on the yahoo search page
    When the user Enters the search keyword in
    And  the user clicks on the Search page in
  	And the user validate the Signing button in
  	
 Scenario: Get the signin page title
    Given the user is on the yahoo search page
    When the user Enters the search keyword in
    And  the user clicks on the Search page in
  	Then the user clicks on the Signing button in
  	Then the user validates the Title of the page in
  	

