package com.gymprogress.controllers;

import com.gymprogress.domain.TrainingPlan;
import com.gymprogress.repositories.TrainingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingPlanController {

    private final TrainingPlanRepository trainingPlanRepository;

    @Autowired
    public TrainingPlanController(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    public void createTrainingPlan(TrainingPlan trainingPlan) {
        trainingPlanRepository.save(trainingPlan);
    }

    public TrainingPlan getTrainingPlan(Long trainingPlanId) {
        List<TrainingPlan> trainingPlanList = trainingPlanRepository.findAll();
        return trainingPlanRepository.findById(trainingPlanId).orElse(null);
    }
}
