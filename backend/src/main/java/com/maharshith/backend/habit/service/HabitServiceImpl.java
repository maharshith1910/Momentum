package com.maharshith.backend.habit.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.dto.CreateHabitRequest;
import com.maharshith.backend.habit.dto.HabitResponse;
import com.maharshith.backend.habit.dto.UpdateHabitRequest;
import com.maharshith.backend.habit.entity.Habit;
import com.maharshith.backend.habit.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public HabitResponse createHabit(CreateHabitRequest request, User user) {

        Habit habit = new Habit(
                request.getName(),
                request.getDescription(),
                user
        );

        Habit savedHabit = habitRepository.save(habit);

        return mapToResponse(savedHabit);
    }

    @Override
    public List<HabitResponse> getAllHabits(User user) {

        return habitRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public HabitResponse getHabitById(Long id, User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        return mapToResponse(habit);
    }

    @Override
    public HabitResponse updateHabit(Long id,
                                     UpdateHabitRequest request,
                                     User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setCompleted(request.isCompleted());

        Habit updatedHabit = habitRepository.save(habit);

        return mapToResponse(updatedHabit);
    }

    @Override
    public void deleteHabit(Long id, User user) {

        Habit habit = habitRepository.findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found"));

        habitRepository.delete(habit);
    }

    private HabitResponse mapToResponse(Habit habit) {

        return new HabitResponse(
                habit.getId(),
                habit.getName(),
                habit.getDescription(),
                habit.isCompleted()
        );
    }
}