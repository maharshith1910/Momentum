package com.maharshith.backend.notification.scheduler;

import com.maharshith.backend.notification.entity.Reminder;
import com.maharshith.backend.notification.repository.ReminderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class ReminderScheduler {

    private final ReminderRepository reminderRepository;

    public ReminderScheduler(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void checkReminders() {

        LocalTime now = LocalTime.now().withSecond(0).withNano(0);

        List<Reminder> reminders = reminderRepository.findByEnabledTrue();

        for (Reminder reminder : reminders) {

            if (reminder.getReminderTime().equals(now)) {

                System.out.println("=======================================");
                System.out.println("🔔 REMINDER");
                System.out.println("User : " + reminder.getUser().getUsername());
                System.out.println("Habit: " + reminder.getHabit().getName());
                System.out.println("Time : " + reminder.getReminderTime());
                System.out.println("=======================================");
            }
        }
    }
}