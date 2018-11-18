package com.gymprogress.steps.exercise;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/exercise.feature" })
public class ExerciseIntegrationTest {
}
