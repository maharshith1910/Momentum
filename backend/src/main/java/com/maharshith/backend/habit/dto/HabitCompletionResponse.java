package com.maharshith.backend.habit.dto;

import java.time.LocalDate;

public class HabitCompletionResponse {

    private Long habitId;
    private String habitName;
    private LocalDate completedDate;

    public HabitCompletionResponse(
            Long habitId,
            String habitName,
            LocalDate completedDate
    ) {
        this.habitId = habitId;
        this.habitName = habitName;
        this.completedDate = completedDate;
    }

    public Long getHabitId() {
        return habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }
}