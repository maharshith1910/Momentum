package com.maharshith.backend.analytics.dto;

import java.time.LocalDate;

public class WeeklyAnalyticsResponse {

    private LocalDate date;
    private long completedHabits;

    public WeeklyAnalyticsResponse(LocalDate date, long completedHabits) {
        this.date = date;
        this.completedHabits = completedHabits;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getCompletedHabits() {
        return completedHabits;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompletedHabits(long completedHabits) {
        this.completedHabits = completedHabits;
    }
}