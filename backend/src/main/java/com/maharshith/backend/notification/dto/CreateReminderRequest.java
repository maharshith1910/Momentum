package com.maharshith.backend.notification.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class CreateReminderRequest {

    @NotNull
    private Long habitId;

    @NotNull
    private LocalTime reminderTime;

    public CreateReminderRequest() {
    }

    public CreateReminderRequest(Long habitId, LocalTime reminderTime) {
        this.habitId = habitId;
        this.reminderTime = reminderTime;
    }

    public Long getHabitId() {
        return habitId;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }
}