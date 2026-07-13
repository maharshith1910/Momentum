package com.maharshith.backend.notification.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class UpdateReminderRequest {

    @NotNull
    private LocalTime reminderTime;

    private boolean enabled;

    public UpdateReminderRequest() {
    }

    public UpdateReminderRequest(LocalTime reminderTime, boolean enabled) {
        this.reminderTime = reminderTime;
        this.enabled = enabled;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}