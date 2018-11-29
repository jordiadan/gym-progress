package com.gymprogress.repositories;

import com.gymprogress.domain.Exercise;
import com.gymprogress.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
