package com.maharshith.backend.heatmap.dto;

import java.time.LocalDate;

public class HeatmapDayResponse {

    private LocalDate date;
    private long completedHabits;
    private int intensity;

    public HeatmapDayResponse(
            LocalDate date,
            long completedHabits,
            int intensity
    ) {
        this.date = date;
        this.completedHabits = completedHabits;
        this.intensity = intensity;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getCompletedHabits() {
        return completedHabits;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompletedHabits(long completedHabits) {
        this.completedHabits = completedHabits;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}