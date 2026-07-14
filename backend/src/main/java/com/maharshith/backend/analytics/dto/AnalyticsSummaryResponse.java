package com.maharshith.backend.analytics.dto;

public class AnalyticsSummaryResponse {

    private long totalCompletions;
    private int currentStreak;
    private int longestStreak;
    private double successRate;

    private String bestHabit;
    private String worstHabit;
    private String mostConsistentHabit;

    private double averagePerDay;

    private String motivationalQuote;

    public AnalyticsSummaryResponse(
            long totalCompletions,
            int currentStreak,
            int longestStreak,
            double successRate,
            String bestHabit,
            String worstHabit,
            String mostConsistentHabit,
            double averagePerDay,
            String motivationalQuote
    ) {
        this.totalCompletions = totalCompletions;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.successRate = successRate;
        this.bestHabit = bestHabit;
        this.worstHabit = worstHabit;
        this.mostConsistentHabit = mostConsistentHabit;
        this.averagePerDay = averagePerDay;
        this.motivationalQuote = motivationalQuote;
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

    public String getBestHabit() {
        return bestHabit;
    }

    public String getWorstHabit() {
        return worstHabit;
    }

    public String getMostConsistentHabit() {
        return mostConsistentHabit;
    }

    public double getAveragePerDay() {
        return averagePerDay;
    }

    public String getMotivationalQuote() {
        return motivationalQuote;
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

    public void setBestHabit(String bestHabit) {
        this.bestHabit = bestHabit;
    }

    public void setWorstHabit(String worstHabit) {
        this.worstHabit = worstHabit;
    }

    public void setMostConsistentHabit(String mostConsistentHabit) {
        this.mostConsistentHabit = mostConsistentHabit;
    }

    public void setAveragePerDay(double averagePerDay) {
        this.averagePerDay = averagePerDay;
    }

    public void setMotivationalQuote(String motivationalQuote) {
        this.motivationalQuote = motivationalQuote;
    }
}