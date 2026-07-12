package com.maharshith.backend.dashboard.dto;

public class DashboardResponse {

    private int totalHabits;
    private int completedHabits;
    private int currentStreak;
    private int longestStreak;
    private double completionPercentage;

    // Constructor

    public DashboardResponse(
            int totalHabits,
            int completedHabits,
            int currentStreak,
            int longestStreak,
            double completionPercentage
    ) {
        this.totalHabits = totalHabits;
        this.completedHabits = completedHabits;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.completionPercentage = completionPercentage;
    }

    // Getters

    public int getTotalHabits() {
        return totalHabits;
    }

    public int getCompletedHabits() {
        return completedHabits;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }

    // Setters

    public void setTotalHabits(int totalHabits) {
        this.totalHabits = totalHabits;
    }

    public void setCompletedHabits(int completedHabits) {
        this.completedHabits = completedHabits;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public void setCompletionPercentage(double completionPercentage) {
        this.completionPercentage = completionPercentage;
    }
}