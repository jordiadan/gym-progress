# Created by Makenai04 at 28/11/2018
Feature: Create workout
  # User wants to create new workout to actual training plan and save it to the database

  Scenario: Create workout successfully
    Given user with id 1
    And training plan with name test and id 1
    And workout with name test and id 3

    When create workout test for user

    Then workout with id 3 is stored