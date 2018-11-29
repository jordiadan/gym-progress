package com.gymprogress.controllers;

import com.gymprogress.domain.Workout;
import com.gymprogress.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void createWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public Workout getWorkout(Long workoutId) {
        return workoutRepository.findById(workoutId).orElse(null);
    }
}
