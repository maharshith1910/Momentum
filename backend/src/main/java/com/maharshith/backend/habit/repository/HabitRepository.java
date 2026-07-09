package com.maharshith.backend.habit.repository;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUser(User user);

    Optional<Habit> findByIdAndUser(Long id, User user);
}