package com.maharshith.backend.analytics.service;

import com.maharshith.backend.analytics.dto.AnalyticsResponse;
import com.maharshith.backend.analytics.dto.MonthlyAnalyticsResponse;
import com.maharshith.backend.analytics.dto.WeeklyAnalyticsResponse;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.entity.HabitCompletion;
import com.maharshith.backend.habit.repository.HabitCompletionRepository;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;

    public AnalyticsServiceImpl(
            HabitRepository habitRepository,
            HabitCompletionRepository habitCompletionRepository
    ) {
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
    }

    @Override
    public AnalyticsResponse getAnalytics(User user) {

        List<Habit> habits = habitRepository.findByUser(user);
        List<HabitCompletion> completions = habitCompletionRepository.findByUser(user);

        long totalCompletions = completions.size();

        int currentStreak = habits.stream()
                .mapToInt(Habit::getStreak)
                .max()
                .orElse(0);

        int longestStreak = habits.stream()
                .mapToInt(Habit::getLongestStreak)
                .max()
                .orElse(0);

        double successRate = 0;

        if (!habits.isEmpty()) {

            long completedToday = habits.stream()
                    .filter(Habit::isCompleted)
                    .count();

            successRate = (completedToday * 100.0) / habits.size();
        }

        return new AnalyticsResponse(
                totalCompletions,
                currentStreak,
                longestStreak,
                successRate,
                getWeeklyAnalytics(user),
                getMonthlyAnalytics(user)
        );
    }

    @Override
    public List<WeeklyAnalyticsResponse> getWeeklyAnalytics(User user) {

        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(6);

        List<HabitCompletion> completions =
                habitCompletionRepository.findByUserAndCompletedDateBetween(
                        user,
                        start,
                        today
                );

        List<WeeklyAnalyticsResponse> response = new ArrayList<>();

        for (LocalDate date = start; !date.isAfter(today); date = date.plusDays(1)) {

            final LocalDate currentDate = date;

            long count = completions.stream()
                    .filter(c -> c.getCompletedDate().equals(currentDate))
                    .count();

            response.add(
                    new WeeklyAnalyticsResponse(
                            currentDate,
                            count
                    )
            );
        }

        return response;
    }

    @Override
    public List<MonthlyAnalyticsResponse> getMonthlyAnalytics(User user) {

        List<HabitCompletion> completions =
                habitCompletionRepository.findByUser(user);

        List<MonthlyAnalyticsResponse> response = new ArrayList<>();

        YearMonth currentMonth = YearMonth.now();

        for (int i = 5; i >= 0; i--) {

            final YearMonth month = currentMonth.minusMonths(i);
            long count = completions.stream()
                    .filter(c ->
                            YearMonth.from(c.getCompletedDate())
                                    .equals(month)
                    )
                    .count();

            response.add(
                    new MonthlyAnalyticsResponse(
                            month.getMonth()
                                    .getDisplayName(
                                            TextStyle.SHORT,
                                            Locale.ENGLISH
                                    ),
                            count
                    )
            );
        }

        return response;
    }
}