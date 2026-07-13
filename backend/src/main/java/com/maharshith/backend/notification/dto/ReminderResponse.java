package com.maharshith.backend.notification.dto;

import java.time.LocalTime;

public class ReminderResponse {

    private Long id;
    private Long habitId;
    private String habitName;
    private LocalTime reminderTime;
    private boolean enabled;

    public ReminderResponse() {
    }

    public ReminderResponse(
            Long id,
            Long habitId,
            String habitName,
            LocalTime reminderTime,
            boolean enabled
    ) {
        this.id = id;
        this.habitId = habitId;
        this.habitName = habitName;
        this.reminderTime = reminderTime;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public Long getHabitId() {
        return habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}