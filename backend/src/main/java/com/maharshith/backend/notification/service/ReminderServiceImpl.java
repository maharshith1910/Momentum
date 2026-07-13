package com.maharshith.backend.notification.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitRepository;
import com.maharshith.backend.notification.dto.CreateReminderRequest;
import com.maharshith.backend.notification.dto.ReminderResponse;
import com.maharshith.backend.notification.dto.UpdateReminderRequest;
import com.maharshith.backend.notification.entity.Reminder;
import com.maharshith.backend.notification.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;
    private final HabitRepository habitRepository;

    public ReminderServiceImpl(
            ReminderRepository reminderRepository,
            HabitRepository habitRepository
    ) {
        this.reminderRepository = reminderRepository;
        this.habitRepository = habitRepository;
    }

    @Override
    public ReminderResponse createReminder(
            CreateReminderRequest request,
            User user
    ) {

        Habit habit = habitRepository.findByIdAndUser(
                request.getHabitId(),
                user
        ).orElseThrow(() ->
                new RuntimeException("Habit not found"));

        if (reminderRepository.findByHabit(habit).isPresent()) {
            throw new RuntimeException("Reminder already exists for this habit.");
        }

        Reminder reminder = new Reminder(
                habit,
                user,
                request.getReminderTime(),
                true
        );

        Reminder savedReminder = reminderRepository.save(reminder);

        return mapToResponse(savedReminder);
    }

    @Override
    public List<ReminderResponse> getReminders(User user) {

        return reminderRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ReminderResponse updateReminder(
            Long id,
            UpdateReminderRequest request,
            User user
    ) {

        Reminder reminder = reminderRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Reminder not found"));

        reminder.setReminderTime(request.getReminderTime());
        reminder.setEnabled(request.isEnabled());

        Reminder updatedReminder = reminderRepository.save(reminder);

        return mapToResponse(updatedReminder);
    }

    @Override
    public void deleteReminder(
            Long id,
            User user
    ) {

        Reminder reminder = reminderRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Reminder not found"));

        reminderRepository.delete(reminder);
    }

    private ReminderResponse mapToResponse(Reminder reminder) {

        return new ReminderResponse(
                reminder.getId(),
                reminder.getHabit().getId(),
                reminder.getHabit().getName(),
                reminder.getReminderTime(),
                reminder.isEnabled()
        );
    }
}