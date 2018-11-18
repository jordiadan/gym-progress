package com.gymprogress.steps.plan;

import com.gymprogress.controllers.TrainingPlanController;
import com.gymprogress.domain.TrainingPlan;
import com.gymprogress.domain.User;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@CucumberOptions(glue = {"classpath:features/plan.feature"})
public class TrainingPlanSteps {

    @Autowired
    private TrainingPlanController trainingPlanController;

    private User user;
    private TrainingPlan trainingPlan;

    @Given("^user with id (\\d+)$")
    public void userWithId(Long id) {
        user = new User(id);
    }

    @And("^training plan with name (\\w+) and id (\\d+)$")
    public void trainingPlanWithNameTestAndId(String trainingPlanName, Long trainingPlanId) {
        Long userId = user.getId();
        trainingPlan = new TrainingPlan(trainingPlanId, userId, trainingPlanName);
    }

    @When("^create training plan test for user$")
    public void createTrainingPlanTestForUser() {
        trainingPlanController.createTrainingPlan(trainingPlan);
    }

    @Then("^training plan with id (\\d+) is stored$")
    public void trainingPlanWithIdIsStored(Long trainingPlanId) {
        TrainingPlan storedTrainingPlan = trainingPlanController.getTrainingPlan(trainingPlanId);
        assertEquals(trainingPlan, storedTrainingPlan);
    }
}
