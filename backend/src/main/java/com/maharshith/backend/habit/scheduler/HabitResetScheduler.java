package com.maharshith.backend.habit.scheduler;

import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HabitResetScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(HabitResetScheduler.class);

    private final HabitRepository habitRepository;

    public HabitResetScheduler(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void resetHabits() {

        List<Habit> habits = habitRepository.findAll();

        for (Habit habit : habits) {
            habit.setCompleted(false);
        }

        habitRepository.saveAll(habits);

        log.info("🌙 Daily habit reset completed. Total habits reset: {}", habits.size());
    }
}