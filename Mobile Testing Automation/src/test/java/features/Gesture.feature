Feature: This feature allows the user to navigate through the app demonstrating multiple gestures

  Background:
    Given App is open
    When User enters the detail
    |Name|Vlad| 
    And User clicks on "ShopButton"
    And User navigates to the "Products" page
    And User adds products to the cart
    |Products|jordan_1|    
    And User clicks on "CartButton"
    And User clicks on "Visit_to_the_website"
    Then User is taken to Google Homepage
	
	Scenario: Testing alerts
	Given The "Google_Homepage" is open
	When User enters the detail
    |Search|https://www.seleniumeasy.com/test/javascript-alert-box-demo.html \n|
    And User clicks on "Selenium_easy_demo"
	And The "Test_Page" is open
	And Web Scroll
	Then Handle Alert Box
	And Web Scroll
	And Handle Confirm Box
	And Web Scroll
	And Handle Prompt Box
	|Name|Carlos|
	
	Scenario: Testing horizontal sliding
	Given The "Google_Homepage" is open
	When User enters the detail
    |Search|https://the-internet.herokuapp.com/horizontal_slider \n|
    And User clicks on "Horizontal_Slider"
	Then The "HorizontalSlider_window" is open
	And Slide "slider" to "3"
	
	Scenario: Testing drag n drop
	Given The "Google_Homepage" is open
	When User enters the detail
    |Search|https://deepakkadarivel.github.io/DnDWithTouch/ \n|
    And User clicks on "Drag_and_Drop"
	Then The "DragnDrop_window" is open
	And Drag "Object_1" and drop to "Drop_Zone"