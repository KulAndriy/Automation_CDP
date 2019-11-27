Feature: As a American Airlines user I want to be a logged in on site with correct credentials.
  Scenario Outline: Verify that user is logged in with valid credentials
      Given that American Airlines site is opened
      When user click on login button and user enter account number "<account number>" and user enter password "<password>"
      Then user is logged in and user go to the main page.

    Examples:
        | account number | password |
        |  7W05VC2       | Pa55word |

  Scenario Outline: Verify that user is not logged in with invalid credentials
        Given that American Airlines site is opened
        When user click on login button and user enter account number "<account number>" and user enter password "<password>"
        Then user is not logged in and user get error message.

      Examples:
          | account number | password |
          |  7W05VC2       | InvalidTest |
