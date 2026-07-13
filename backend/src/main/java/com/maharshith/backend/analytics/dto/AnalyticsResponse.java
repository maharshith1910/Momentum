package com.maharshith.backend.analytics.dto;

import java.util.List;

public class AnalyticsResponse {

    private long totalCompletions;
    private int currentStreak;
    private int longestStreak;
    private double successRate;

    private List<WeeklyAnalyticsResponse> weeklyAnalytics;
    private List<MonthlyAnalyticsResponse> monthlyAnalytics;

    public AnalyticsResponse(
            long totalCompletions,
            int currentStreak,
            int longestStreak,
            double successRate,
            List<WeeklyAnalyticsResponse> weeklyAnalytics,
            List<MonthlyAnalyticsResponse> monthlyAnalytics
    ) {
        this.totalCompletions = totalCompletions;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.successRate = successRate;
        this.weeklyAnalytics = weeklyAnalytics;
        this.monthlyAnalytics = monthlyAnalytics;
    }

    public long getTotalCompletions() {
        return totalCompletions;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public List<WeeklyAnalyticsResponse> getWeeklyAnalytics() {
        return weeklyAnalytics;
    }

    public List<MonthlyAnalyticsResponse> getMonthlyAnalytics() {
        return monthlyAnalytics;
    }

    public void setTotalCompletions(long totalCompletions) {
        this.totalCompletions = totalCompletions;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public void setWeeklyAnalytics(List<WeeklyAnalyticsResponse> weeklyAnalytics) {
        this.weeklyAnalytics = weeklyAnalytics;
    }

    public void setMonthlyAnalytics(List<MonthlyAnalyticsResponse> monthlyAnalytics) {
        this.monthlyAnalytics = monthlyAnalytics;
    }
}