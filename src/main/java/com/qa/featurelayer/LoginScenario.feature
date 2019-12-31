#Author: your.email@your.domain.com
@LoginToGIS
Feature: Title of your feature
  I want to use this template for my feature file

  @LoginToGIS22
  Scenario Outline: GISLogin with given username & pwd using scenario outline.
    Given GISLogin Open browser and start application
    And GISLogin Go to login page
    When GISLogin User enter valid <username> and <password>
    And GISLogin click on login button
    Then GISLogin Verify post login process
    And GISLogin Close browser
    
    Examples: 
      | username | password |
      | admin    |   123456 |
