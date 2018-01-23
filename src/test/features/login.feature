Feature: Login feature for www.automationpractice.com site
  As a user
  I want to see login page
  So that I can login successfully

  #happy path scenario
  @login1 @smoke
  Scenario: Registered user able to login successfully with valid credentials
    Given I am on Signin page
    When I enters username as "mineshautomation@gmail.com" and password as "automation@123"
    And I select Signin button
    Then I should login successfully
    And I should see welcome message as "Welcome to your account"


 #un-happy path scenario
# @login2 @smoke
 #Scenario Outline: i cannot login successfully with in-valid credentials
  # Given I am on  Signin page
   #When I enters username as "<username>" and password as "<password>"
   #And I select Sign in button
   #Then I should not login successfully
   #And I should see message as "<Message>"
   #Examples:
    # | username                    | password         | Message                           |
     #|                             |                  | Please enter username and password|
     #|                             | fdfddjjj         | Please enter username             |
     #| minesh@malinator.com        |                  | Please enter password             |
