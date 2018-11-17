# Created by jordiadan at 17/11/2018
Feature: Create exercise
  # User wants to create new exercise and save it to the database

  Scenario: Create exercise successfully
    Given user with id 1
    And exercise with name test and id 1

    When create exercise test for user

    Then exercise with id 1 is stored
