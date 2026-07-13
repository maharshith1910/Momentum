package com.maharshith.backend.notification.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.notification.dto.CreateReminderRequest;
import com.maharshith.backend.notification.dto.ReminderResponse;
import com.maharshith.backend.notification.dto.UpdateReminderRequest;

import java.util.List;

public interface ReminderService {

    ReminderResponse createReminder(
            CreateReminderRequest request,
            User user
    );

    List<ReminderResponse> getReminders(User user);

    ReminderResponse updateReminder(
            Long id,
            UpdateReminderRequest request,
            User user
    );

    void deleteReminder(
            Long id,
            User user
    );
}