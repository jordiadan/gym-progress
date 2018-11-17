package com.gymprogress.controllers;

import com.gymprogress.domain.Exercise;
import com.gymprogress.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void createExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    public Exercise getExercise(Long exerciseId) {
        return exerciseRepository.findById(exerciseId).orElse(null);
    }
}
