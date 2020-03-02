Feature: Hotel Booking functionality in adactin application 

Scenario: User validate the login function using valid username and password 
	Given User launch the adactin application 
	When User enter the username 
	And User enter the password 
	And user click on the login button 
	Then User validate the name of the user in homepage 
	
Scenario: Search Hotel booking room 
	When User select the location 
	And User select the best hotel 
	And User Select the room types 
	And User Select the number of room booking 
	And User select the check in date 
	And User select the check out date 
	And User select the adults per room 
	And User select the children per room 
	Then User click on the search button 
	
Scenario: Select the Hotel 

	When User can click the select button 
	Then User can click the continue button 
	
Scenario: Book A Hotel 
	When User is given the firstname 
	And User is given the lastname 
	And User is fill the billing address 
	And User is fill the credit card details 
	And User select the credit card type 
	And User need to fill the credit card Expiry date 
	And User is give the cvv number
	Then User click on the book now option
	
	Scenario: Booking Confirmation
	
	Then Booking Itinerary
	
	
