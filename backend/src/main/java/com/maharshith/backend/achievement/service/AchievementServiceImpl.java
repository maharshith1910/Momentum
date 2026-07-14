package com.maharshith.backend.achievement.service;

import com.maharshith.backend.achievement.dto.AchievementResponse;
import com.maharshith.backend.achievement.dto.UserLevelResponse;
import com.maharshith.backend.achievement.entity.Achievement;
import com.maharshith.backend.achievement.repository.AchievementRepository;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitRepository;
import com.maharshith.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public AchievementServiceImpl(
            AchievementRepository achievementRepository,
            HabitRepository habitRepository,
            UserRepository userRepository
    ) {
        this.achievementRepository = achievementRepository;
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AchievementResponse> getAllAchievements(User user) {

        return achievementRepository.findByUser(user)
                .stream()
                .map(a -> new AchievementResponse(
                        a.getTitle(),
                        a.getDescription(),
                        a.getBadge(),
                        a.getXpReward(),
                        a.getUnlockedAt()
                ))
                .toList();
    }

    @Override
    public void checkAchievements(User user) {

        List<Habit> habits = habitRepository.findByUser(user);

        int maxStreak = habits.stream()
                .mapToInt(Habit::getLongestStreak)
                .max()
                .orElse(0);

        unlockAchievement(
                user,
                "First Step",
                "Completed your first habit.",
                "BRONZE",
                50,
                maxStreak >= 1
        );

        unlockAchievement(
                user,
                "On Fire",
                "Reached a 7-day streak.",
                "SILVER",
                100,
                maxStreak >= 7
        );

        unlockAchievement(
                user,
                "Unstoppable",
                "Reached a 30-day streak.",
                "GOLD",
                300,
                maxStreak >= 30
        );

        unlockAchievement(
                user,
                "Legend",
                "Reached a 100-day streak.",
                "DIAMOND",
                1000,
                maxStreak >= 100
        );
    }

    private void unlockAchievement(
            User user,
            String title,
            String description,
            String badge,
            int xpReward,
            boolean condition
    ) {

        if (!condition) {
            return;
        }

        if (achievementRepository.existsByUserAndTitle(user, title)) {
            return;
        }

        Achievement achievement = new Achievement(
                title,
                description,
                badge,
                xpReward,
                LocalDateTime.now(),
                user
        );

        achievementRepository.save(achievement);

        addXp(user, xpReward);

        userRepository.save(user);
    }

    private void addXp(User user, int xpReward) {

        user.setXp(user.getXp() + xpReward);

        while (user.getXp() >= user.getLevel() * 100) {
            user.setLevel(user.getLevel() + 1);
        }
    }


    @Override
    public UserLevelResponse getLevel(User user) {

        int xp = user.getXp();
        int level = user.getLevel();

        int nextLevelXp = level * 100;

        double progress = (xp * 100.0) / nextLevelXp;

        if (progress > 100) {
            progress = 100;
        }

        return new UserLevelResponse(
                xp,
                level,
                nextLevelXp,
                progress
        );
    }
}