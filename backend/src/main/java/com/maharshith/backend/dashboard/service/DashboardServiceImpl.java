package com.maharshith.backend.dashboard.service;

import com.maharshith.backend.dashboard.dto.DashboardResponse;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final HabitRepository habitRepository;

    public DashboardServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public DashboardResponse getDashboard(User user) {

        List<Habit> habits = habitRepository.findByUser(user);

        int totalHabits = habits.size();

        int completedHabits = (int) habits.stream()
                .filter(Habit::isCompleted)
                .count();

        int currentStreak = habits.stream()
                .mapToInt(Habit::getStreak)
                .max()
                .orElse(0);

        int longestStreak = habits.stream()
                .mapToInt(Habit::getLongestStreak)
                .max()
                .orElse(0);

        double completionPercentage = 0;

        if (totalHabits > 0) {
            completionPercentage =
                    (completedHabits * 100.0) / totalHabits;
        }

        return new DashboardResponse(
                totalHabits,
                completedHabits,
                currentStreak,
                longestStreak,
                completionPercentage
        );
    }
}