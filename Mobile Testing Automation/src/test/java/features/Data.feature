Feature: This feature allows the user to shop from the app using Datatables

  Background:
    Given App is open
    
    Scenario Outline:
    	When User selects the value from "dropdown" with "<Country>"
    	And User enters in the "Name" box with "<Nameofperson>"
    	And User selects a "<Gender>"
    	And User clicks on "ShopButton"
    	And User navigates to the "Products" page
    	And User adds products to the cart
    	|Products|jordan_1|all_star|jordan_9| 
    	And User clicks on "CartButton"
    	Then User navigates to the "Cart" page
    	And User clicks on "Checkbox"
    	And User clicks on "Visit_to_the_website"
    	And User is taken to Google Homepage
    	And User enters in the "Search" box with "<url>"
    	And User clicks on "<Link>"
    	Examples:
    	| Country    | Nameofperson    | Gender | url                    |Link     |
    	| Australia  | Jennifer        | Female | www.flipkart.com \n    |Flipkart |
		| India      | Alex            | Male   | www.amazon.in    \n    |Amazon   |
