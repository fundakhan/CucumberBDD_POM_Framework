Feature: Fee Functionality

Background:
  Given User is on login page
  When user enter admin credentials
  Then user should login successfully

@Smoke
Scenario Outline: Add Fees
And User create Fee "<name>" and "<code>" and "<intCode>" and "<priority>"
Then Success message should be displayed

Examples:
| name          | code    | intCode     | priority |
| FundaTest1    | fnd45   | paypal55    | 255      |
| FundaTest2    | fnd456  | applePay55  | 155      |
| FundaTest5    | fnd55   | googlePay55 | 655      |

@Smoke
  Scenario Outline: Edit Fees
    And User edit Fee "<existingFeeName>" and change it to "<newFeeName>"
    Then Success message should be displayed

    Examples:
      | existingFeeName  | newFeeName        |
      | FundaTest1       | Toffee Test Fee   |
      | FundaTest2       | Toffee Test2 Fee2 |
      | FundaTest5       | Toffee Test4 Fee4 |
@Smoke
  Scenario Outline: Delete Fees
    And User delete Fee "<FeeName>"
    Then Success message should be displayed

    Examples:
      | FeeName           |
      | Toffee Test Fee   |
      | Toffee Test2 Fee2 |
      | Toffee Test4 Fee4 |