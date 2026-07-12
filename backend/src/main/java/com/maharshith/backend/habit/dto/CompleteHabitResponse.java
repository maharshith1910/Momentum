package com.maharshith.backend.habit.dto;

import java.time.LocalDate;

public class CompleteHabitResponse {

    private Long id;
    private String name;
    private boolean completed;

    private Integer streak;
    private Integer longestStreak;

    private LocalDate lastCompletedDate;

    private String message;

    public CompleteHabitResponse() {
    }

    public CompleteHabitResponse(
            Long id,
            String name,
            boolean completed,
            Integer streak,
            Integer longestStreak,
            LocalDate lastCompletedDate,
            String message
    ) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.streak = streak;
        this.longestStreak = longestStreak;
        this.lastCompletedDate = lastCompletedDate;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public Integer getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(Integer longestStreak) {
        this.longestStreak = longestStreak;
    }

    public LocalDate getLastCompletedDate() {
        return lastCompletedDate;
    }

    public void setLastCompletedDate(LocalDate lastCompletedDate) {
        this.lastCompletedDate = lastCompletedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}