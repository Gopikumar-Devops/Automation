Feature: Get profile details of author

  Scenario: User calls web service to get profile details of an author
	Given profile of an author with id one exists in the system
	When a user retrieves the profile by id
	Then the status code should be 200
	And response contains the following details
	 | title	 | json-server  |
	 | author	 | typicode		|
 
