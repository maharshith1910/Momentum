package com.maharshith.backend.heatmap.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.heatmap.dto.HeatmapDayResponse;
import com.maharshith.backend.heatmap.dto.HeatmapResponse;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.entity.HabitCompletion;
import com.maharshith.backend.habit.repository.HabitCompletionRepository;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeatmapServiceImpl implements HeatmapService {

    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;

    public HeatmapServiceImpl(
            HabitRepository habitRepository,
            HabitCompletionRepository habitCompletionRepository
    ) {
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
    }

    @Override
    public HeatmapResponse getHeatmap(User user) {

        List<HabitCompletion> completions =
                habitCompletionRepository.findByUser(user);

        List<Habit> habits =
                habitRepository.findByUser(user);

        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(364);

        List<HeatmapDayResponse> days = new ArrayList<>();

        for (LocalDate date = start;
             !date.isAfter(today);
             date = date.plusDays(1)) {

            final LocalDate currentDate = date;

            long count = completions.stream()
                    .filter(c -> c.getCompletedDate().equals(currentDate))
                    .count();

            int intensity;

            if (count == 0) {
                intensity = 0;
            } else if (count <= 2) {
                intensity = 1;
            } else if (count <= 4) {
                intensity = 2;
            } else if (count <= 6) {
                intensity = 3;
            } else {
                intensity = 4;
            }

            days.add(
                    new HeatmapDayResponse(
                            currentDate,
                            count,
                            intensity
                    )
            );
        }

        long totalCompletedHabits = completions.size();

        int currentStreak = habits.stream()
                .mapToInt(Habit::getStreak)
                .max()
                .orElse(0);

        int longestStreak = habits.stream()
                .mapToInt(Habit::getLongestStreak)
                .max()
                .orElse(0);

        return new HeatmapResponse(
                days,
                totalCompletedHabits,
                currentStreak,
                longestStreak
        );
    }
}