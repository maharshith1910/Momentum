package com.maharshith.backend.notification.repository;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.notification.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    List<Reminder> findByUser(User user);

    Optional<Reminder> findByHabit(Habit habit);

    Optional<Reminder> findByIdAndUser(Long id, User user);

    List<Reminder> findByEnabledTrue();
}