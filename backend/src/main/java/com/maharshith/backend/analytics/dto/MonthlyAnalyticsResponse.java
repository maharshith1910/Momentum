package com.maharshith.backend.analytics.dto;

public class MonthlyAnalyticsResponse {

    private String month;
    private long completedHabits;

    public MonthlyAnalyticsResponse(String month, long completedHabits) {
        this.month = month;
        this.completedHabits = completedHabits;
    }

    public String getMonth() {
        return month;
    }

    public long getCompletedHabits() {
        return completedHabits;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setCompletedHabits(long completedHabits) {
        this.completedHabits = completedHabits;
    }
}