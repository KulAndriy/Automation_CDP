Scenario: Verify that user is logged in with valid credentials

Given that American Airlines site "https://www.aadvantageeshopping.com/index.php?p=h" is opened
When user click on login button and user enter account number "7W05VC2" and user enter password "Pa55word"
Then user is logged in and user go to the main page.


Scenario: Verify that user is not logged in with invalid credentials

Given that American Airlines site "https://www.aadvantageeshopping.com/index.php?p=h" is opened
When user click on login button and user enter account number "7W05VC2" and user enter password "InvalidTest"
Then user is not logged in and user get error message.
