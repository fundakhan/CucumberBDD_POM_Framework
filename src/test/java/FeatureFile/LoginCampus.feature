Feature:  Login Campus Functionality

  @Regression
  Scenario: Login Admin Account

    Given User is on login page
    When user enter admin credentials
    Then user should login successfully