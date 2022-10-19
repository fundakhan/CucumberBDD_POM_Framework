Feature: Countries Functionality

  @Regression
  Scenario: Create Country
    Given User is on login page
    When user enter admin credentials
    Then user should login successfully
    When User create Country
    Then Success message should be displayed

@Regression
    Scenario: Edit Country
      Given User is on login page
      When user enter admin credentials
      Then user should login successfully
      When User edit Country
      Then Success message should be displayed

@Regression
      Scenario: Delete Country
        Given User is on login page
        When user enter admin credentials
        Then user should login successfully
        When User delete country
        Then Success message should be displayed


