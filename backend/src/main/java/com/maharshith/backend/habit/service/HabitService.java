package com.maharshith.backend.habit.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.dto.CreateHabitRequest;
import com.maharshith.backend.habit.dto.HabitResponse;
import com.maharshith.backend.habit.dto.UpdateHabitRequest;

import java.util.List;


public interface HabitService{

    HabitResponse createHabit(CreateHabitRequest request, User user);
    List<HabitResponse> getAllHabits(User user);
    HabitResponse getHabitById(Long id, User user);
    HabitResponse updateHabit(Long id, UpdateHabitRequest request, User user);

    void deleteHabit(Long id, User user);

}