package com.maharshith.backend.analytics.dto;

public class HabitInsightResponse {

    private String bestHabit;
    private String worstHabit;
    private String mostConsistentHabit;
    private double averagePerDay;
    private String motivationalQuote;

    public HabitInsightResponse(
            String bestHabit,
            String worstHabit,
            String mostConsistentHabit,
            double averagePerDay,
            String motivationalQuote
    ) {
        this.bestHabit = bestHabit;
        this.worstHabit = worstHabit;
        this.mostConsistentHabit = mostConsistentHabit;
        this.averagePerDay = averagePerDay;
        this.motivationalQuote = motivationalQuote;
    }

    public String getBestHabit() {
        return bestHabit;
    }

    public void setBestHabit(String bestHabit) {
        this.bestHabit = bestHabit;
    }

    public String getWorstHabit() {
        return worstHabit;
    }

    public void setWorstHabit(String worstHabit) {
        this.worstHabit = worstHabit;
    }

    public String getMostConsistentHabit() {
        return mostConsistentHabit;
    }

    public void setMostConsistentHabit(String mostConsistentHabit) {
        this.mostConsistentHabit = mostConsistentHabit;
    }

    public double getAveragePerDay() {
        return averagePerDay;
    }

    public void setAveragePerDay(double averagePerDay) {
        this.averagePerDay = averagePerDay;
    }

    public String getMotivationalQuote() {
        return motivationalQuote;
    }

    public void setMotivationalQuote(String motivationalQuote) {
        this.motivationalQuote = motivationalQuote;
    }
}