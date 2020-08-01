Feature: This feature allows the user to shop from the app with details from excel

  Background:
    Given App open
    
    Scenario Outline:
    	When User gets data from excel at "<index>" row
    	And ExcelUser selects the value from "dropdown" with "Country"
    	And ExcelUser enters in the "Name" box with "Nameofperson"
    	And ExcelUser selects a "Gender"
    	And User clicks on "ShopButton"
    	And User navigates to the "Products" page
    	And User adds products to the cart
    	|Products|jordan_1|all_star|jordan_9| 
    	And User clicks on "CartButton"
    	Then User navigates to the "Cart" page
    	And User clicks on "Checkbox"
    	And User clicks on "Visit_to_the_website"
    	And User is taken to Google Homepage
    	And ExcelUser enters in the "Search" box with "url"
    	And ExcelUser clicks on "Link"
    	Examples:
    	| index |
    	| 1     |
    	| 2     |
    	