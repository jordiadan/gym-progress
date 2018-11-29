package com.gymprogress.steps.workout;

import com.gymprogress.controllers.TrainingPlanController;
import com.gymprogress.controllers.WorkoutController;
import com.gymprogress.domain.Exercise;
import com.gymprogress.domain.TrainingPlan;
import com.gymprogress.domain.User;
import com.gymprogress.domain.Workout;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@CucumberOptions(glue = {"classpath:features/workout.feature"})
public class WorkoutSteps {

    @Autowired
    private WorkoutController workoutController;

    private User user;
    private TrainingPlan trainingPlan;
    private Workout workout;

    @Given("^user with id (\\d+)$")
    public void userWithId(Long id) {
        user = new User(id);
    }

    @And("^training plan with name (\\w+) and id (\\d+)$")
    public void trainingPlanWithNameAndId(String trainingPlanName, Long trainingPlanId) {
        Long userId = user.getId();
        trainingPlan = new TrainingPlan(trainingPlanId, userId, trainingPlanName);
    }

    @And("^workout with name (\\w+) and id (\\d+)$")
    public void workoutWithNameAndId(String workoutName, Long workoutId) {
        Long userId = user.getId();
        workout = new Workout(workoutId, userId, workoutName);
    }

    @When("^create workout test for user$")
    public void createWorkoutTestForUser() {
        workoutController.createWorkout(workout);
    }

    @Then("^workout with id (\\d+) is stored$")
    public void workoutWithIdIsStored(Long workoutId) {
        Workout storedWorkout = workoutController.getWorkout(workoutId);
        assertEquals(workout, storedWorkout);
    }
}
