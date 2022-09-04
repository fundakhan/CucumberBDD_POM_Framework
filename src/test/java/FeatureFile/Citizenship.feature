Feature: Citizenship Functionality

  Background:
    Given User is on login page
    When user enter admin credentials
    Then user should login successfully

  Scenario: Create Citizenship

    When User create Citizenship with "Turkey" name and "TR" shortname
    Then Success message should be displayed

    Scenario: Edit Citizenship

      When User edit "Turkey" citizenship to "ToFFee"
      Then Success message should be displayed

      Scenario: Delete Citizenship
        When User delete "ToFFee" citizenship
        Then Success message should be displayed
