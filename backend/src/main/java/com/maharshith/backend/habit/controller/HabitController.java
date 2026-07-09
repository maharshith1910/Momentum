package com.maharshith.backend.habit.controller;

import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.dto.CreateHabitRequest;
import com.maharshith.backend.habit.dto.HabitResponse;
import com.maharshith.backend.habit.dto.UpdateHabitRequest;
import com.maharshith.backend.habit.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public HabitResponse createHabit(
            @Valid @RequestBody CreateHabitRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return habitService.createHabit(request, user);
    }

    @GetMapping
    public List<HabitResponse> getAllHabits(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return habitService.getAllHabits(user);
    }

    @GetMapping("/{id}")
    public HabitResponse getHabitById(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return habitService.getHabitById(id, user);
    }

    @PutMapping("/{id}")
    public HabitResponse updateHabit(
            @PathVariable Long id,
            @Valid @RequestBody UpdateHabitRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return habitService.updateHabit(id, request, user);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        habitService.deleteHabit(id, user);
    }
}