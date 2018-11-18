package com.gymprogress.steps.exercise;

import com.gymprogress.controllers.ExerciseController;
import com.gymprogress.domain.Exercise;
import com.gymprogress.domain.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ExerciseSteps {

    @Autowired
    private ExerciseController exerciseController;


    private Exercise exercise;
    private User user;

    @Given("^user with id (\\d+)$")
    public void userWithId(Long id) {
        user = new User(id);
    }

    @And("^exercise with name (\\w+) and id (\\d+)$")
    public void exerciseWithNameAndId(String exerciseName, Long exerciseId) {
        Long userId = user.getId();
        exercise = new Exercise(exerciseId, userId, exerciseName);
    }

    @When("^create exercise test for user$")
    public void createExerciseTestForUser() {
        exerciseController.createExercise(exercise);
    }

    @Then("^exercise with id (\\d+) is stored$")
    public void exerciseWithIdIsStored(Long exerciseId) {
        Exercise storedExercise = exerciseController.getExercise(exerciseId);
        assertEquals(exercise, storedExercise);
    }
}
