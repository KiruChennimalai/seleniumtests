Feature: Resume Library recruiter login

  Scenario: Recruiter should be successfully signed in after filling the form correctly
    Given  User is on RL recruiter login page
    When   User fills in the email address and password
    And    The fields are all validated
    Then   Login is successful, user signed in and taken to the recruiter home page
