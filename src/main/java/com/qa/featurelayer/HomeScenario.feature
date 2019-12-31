#Author: your.email@your.domain.com
#Keywords Summary :
@GISLoadHomePage
Feature: Load Home Page
  Run all Home Page scenario

  @LoadManageRolePage
  Scenario Outline: Load Manage Role page.
    Given Open browser and start application with login page
    And Logged in successfully with valid <username> and <password> and go to home page
    When User click on administration menu and manage role sub menu home page is loaded
    Then Validate manage role page title
    And ManageRole Close browser

    Examples: 
      | username | password |
      | admin    |   123456 |
