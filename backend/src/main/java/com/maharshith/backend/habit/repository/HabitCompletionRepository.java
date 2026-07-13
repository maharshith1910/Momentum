package com.maharshith.backend.habit.repository;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion, Long> {

    List<HabitCompletion> findByUser(User user);

    List<HabitCompletion> findByUserOrderByCompletedDateAsc(User user);

    List<HabitCompletion> findByUserAndCompletedDateBetween(
            User user,
            LocalDate start,
            LocalDate end
    );

}