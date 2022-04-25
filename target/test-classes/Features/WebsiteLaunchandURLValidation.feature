Feature: WebsiteLaunchandURLValidation

Background: Common Steps
Given User launch the BBC website
And User validates the Home page

Scenario: Launching Website and Validating Navigation URLS
When User clicks on Each navigation link
Then User Land on the Individual pages


Scenario: User Validates the Current Date
When User Validates the current Day and Date

Scenario: User Verify URl for NEWS Page
When User clicks on NEWS Navigation Link


Scenario: Seraching for Houghton Mifflin Harcourt
When User Search in the Search bar
Then User validates the Search results

