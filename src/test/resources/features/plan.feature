# Created by jordiadan at 18/11/2018
Feature: Create training plan
  # User wants to create new training plan and save it to the database

  Scenario: Create training plan successfully
    Given user with id 1
    And training plan with name test and id 2

    When create training plan test for user

    Then training plan with id 2 is stored