package com.maharshith.backend.notification.controller;

import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.notification.dto.CreateReminderRequest;
import com.maharshith.backend.notification.dto.ReminderResponse;
import com.maharshith.backend.notification.dto.UpdateReminderRequest;
import com.maharshith.backend.notification.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping
    public ReminderResponse createReminder(
            @Valid @RequestBody CreateReminderRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return reminderService.createReminder(request, user);
    }

    @GetMapping
    public List<ReminderResponse> getReminders(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return reminderService.getReminders(user);
    }

    @PutMapping("/{id}")
    public ReminderResponse updateReminder(
            @PathVariable Long id,
            @Valid @RequestBody UpdateReminderRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return reminderService.updateReminder(id, request, user);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        reminderService.deleteReminder(id, user);
    }
}