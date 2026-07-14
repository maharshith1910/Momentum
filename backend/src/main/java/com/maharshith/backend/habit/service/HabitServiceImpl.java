package com.maharshith.backend.habit.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.dto.CompleteHabitResponse;
import com.maharshith.backend.habit.dto.CreateHabitRequest;
import com.maharshith.backend.habit.dto.HabitResponse;
import com.maharshith.backend.habit.dto.UpdateHabitRequest;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitCompletionRepository;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.springframework.stereotype.Service;
import com.maharshith.backend.habit.dto.HabitCompletionResponse;
import com.maharshith.backend.habit.entity.HabitCompletion;
import java.time.LocalDate;
import java.util.List;
import com.maharshith.backend.achievement.service.AchievementService;
@Service
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;
    private final AchievementService achievementService;

    public HabitServiceImpl(
            HabitRepository habitRepository,
            HabitCompletionRepository habitCompletionRepository,
            AchievementService achievementService
    ) {
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
        this.achievementService = achievementService;
    }

    @Override
    public HabitResponse createHabit(CreateHabitRequest request, User user) {

        Habit habit = new Habit(
                request.getName(),
                request.getDescription(),
                user
        );

        Habit savedHabit = habitRepository.save(habit);

        return mapToResponse(savedHabit);
    }

    @Override
    public List<HabitResponse> getAllHabits(User user) {

        return habitRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public HabitResponse getHabitById(Long id, User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        return mapToResponse(habit);
    }

    @Override
    public HabitResponse updateHabit(Long id,
                                     UpdateHabitRequest request,
                                     User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setCompleted(request.isCompleted());

        Habit updatedHabit = habitRepository.save(habit);

        return mapToResponse(updatedHabit);
    }

    @Override
    public void deleteHabit(Long id, User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        habitRepository.delete(habit);
    }

    @Override
    public CompleteHabitResponse completeHabit(Long id, User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        LocalDate today = LocalDate.now();

        // First completion
        if (habit.getLastCompletedDate() == null) {

            habit.setCompleted(true);
            habit.setStreak(1);
            habit.setLongestStreak(1);
            habit.setLastCompletedDate(today);

            habitRepository.save(habit);

            HabitCompletion completion =
                    new HabitCompletion(habit, user, today);

            habitCompletionRepository.save(completion);

            achievementService.checkAchievements(user);

            return new CompleteHabitResponse(
                    habit.getId(),
                    habit.getName(),
                    habit.isCompleted(),
                    habit.getStreak(),
                    habit.getLongestStreak(),
                    habit.getLastCompletedDate(),
                    "Habit completed! 🔥"
            );
        }

        // Already completed today
        if (habit.getLastCompletedDate().equals(today)) {

            return new CompleteHabitResponse(
                    habit.getId(),
                    habit.getName(),
                    habit.isCompleted(),
                    habit.getStreak(),
                    habit.getLongestStreak(),
                    habit.getLastCompletedDate(),
                    "Habit already completed today!"
            );
        }

        // Continue streak
        if (habit.getLastCompletedDate().equals(today.minusDays(1))) {

            habit.setCompleted(true);
            habit.setStreak(habit.getStreak() + 1);

            if (habit.getStreak() > habit.getLongestStreak()) {
                habit.setLongestStreak(habit.getStreak());
            }

            habit.setLastCompletedDate(today);

            habitRepository.save(habit);

            HabitCompletion completion =
                    new HabitCompletion(habit, user, today);

            habitCompletionRepository.save(completion);

            achievementService.checkAchievements(user);

            return new CompleteHabitResponse(
                    habit.getId(),
                    habit.getName(),
                    habit.isCompleted(),
                    habit.getStreak(),
                    habit.getLongestStreak(),
                    habit.getLastCompletedDate(),
                    "Streak increased! 🔥"
            );
        }

        // Restart streak
        habit.setCompleted(true);
        habit.setStreak(1);
        habit.setLastCompletedDate(today);

        habitRepository.save(habit);

        HabitCompletion completion =
                new HabitCompletion(habit, user, today);

        habitCompletionRepository.save(completion);

        achievementService.checkAchievements(user);

        return new CompleteHabitResponse(
                habit.getId(),
                habit.getName(),
                habit.isCompleted(),
                habit.getStreak(),
                habit.getLongestStreak(),
                habit.getLastCompletedDate(),
                "Streak restarted! Keep going! 💪"
        );
    }
    @Override
    public List<HabitCompletionResponse> getCompletionHistory(User user) {

        return habitCompletionRepository
                .findByUserOrderByCompletedDateAsc(user)
                .stream()
                .map(completion -> new HabitCompletionResponse(
                        completion.getHabit().getId(),
                        completion.getHabit().getName(),
                        completion.getCompletedDate()
                ))
                .toList();
    }
    private HabitResponse mapToResponse(Habit habit) {

        return new HabitResponse(
                habit.getId(),
                habit.getName(),
                habit.getDescription(),
                habit.isCompleted(),
                habit.getStreak(),
                habit.getLongestStreak(),
                habit.getLastCompletedDate()
        );
    }
}