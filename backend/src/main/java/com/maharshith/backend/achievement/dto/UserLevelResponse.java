package com.maharshith.backend.achievement.dto;

public class UserLevelResponse {

    private int xp;
    private int level;
    private int nextLevelXp;
    private double progress;

    public UserLevelResponse(
            int xp,
            int level,
            int nextLevelXp,
            double progress
    ) {
        this.xp = xp;
        this.level = level;
        this.nextLevelXp = nextLevelXp;
        this.progress = progress;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getNextLevelXp() {
        return nextLevelXp;
    }

    public double getProgress() {
        return progress;
    }
}