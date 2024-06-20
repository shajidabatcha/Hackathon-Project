Feature: 91Wheels
 
  Scenario: Navigate to Upcoming Bikes and Display Honda Bikes
    Given Hover on Bikes DropDown
    When Click on Upcoming Bikes
    And Select Honda Bikes from Select Brand DropDown and click LoadMore
    Then print the Honda Bikes price under fourLakhs
    
  Scenario: Used Cars in CHENNAI
  	Given Hover on usedCars DropDown
  	When Click usedCars in CHENNAI
  	And Click Read more Button
  	Then Print the information of Popular used cars
  
  Scenario: Invalid LoginPage
  	Given Click the userLogin button
  	When click on signIn button
  	And Enter the Email credentials
  	Then Print the error message