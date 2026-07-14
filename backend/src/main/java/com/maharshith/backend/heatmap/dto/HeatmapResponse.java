package com.maharshith.backend.heatmap.dto;

import java.util.List;

public class HeatmapResponse {

    private List<HeatmapDayResponse> days;
    private long totalCompletedHabits;
    private int currentStreak;
    private int longestStreak;

    public HeatmapResponse(
            List<HeatmapDayResponse> days,
            long totalCompletedHabits,
            int currentStreak,
            int longestStreak
    ) {
        this.days = days;
        this.totalCompletedHabits = totalCompletedHabits;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
    }

    public List<HeatmapDayResponse> getDays() {
        return days;
    }

    public long getTotalCompletedHabits() {
        return totalCompletedHabits;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setDays(List<HeatmapDayResponse> days) {
        this.days = days;
    }

    public void setTotalCompletedHabits(long totalCompletedHabits) {
        this.totalCompletedHabits = totalCompletedHabits;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }
}