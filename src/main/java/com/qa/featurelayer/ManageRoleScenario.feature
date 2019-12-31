#Author: your.email@your.domain.com
#Keywords Summary :

@tag
Feature: Load Manage Role Page
  Run all Manage Role Page scenario

  
  @GISLoadManageRolePage
  Scenario: Load Manage Role page and view role admin.
    Given User is on Manage Role page
    When User click on administration menu and manage role sub menu
    Then Manage Role screen is laoded
#   And GISLogin Close browser
