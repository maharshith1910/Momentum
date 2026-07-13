package com.maharshith.backend.habit.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.dto.*;

import java.util.List;


public interface HabitService{

    HabitResponse createHabit(CreateHabitRequest request, User user);
    List<HabitResponse> getAllHabits(User user);
    HabitResponse getHabitById(Long id, User user);
    HabitResponse updateHabit(Long id, UpdateHabitRequest request, User user);
    List<HabitCompletionResponse> getCompletionHistory(User user);
    void deleteHabit(Long id, User user);
    CompleteHabitResponse completeHabit(Long id, User user);
}