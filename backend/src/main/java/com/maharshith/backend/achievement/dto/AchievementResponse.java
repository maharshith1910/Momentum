package com.maharshith.backend.achievement.dto;

import java.time.LocalDateTime;

public class AchievementResponse {

    private String title;
    private String description;
    private String badge;
    private int xpReward;
    private LocalDateTime unlockedAt;

    public AchievementResponse(String title,
                               String description,
                               String badge,
                               int xpReward,
                               LocalDateTime unlockedAt) {
        this.title = title;
        this.description = description;
        this.badge = badge;
        this.xpReward = xpReward;
        this.unlockedAt = unlockedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBadge() {
        return badge;
    }

    public int getXpReward() {
        return xpReward;
    }

    public LocalDateTime getUnlockedAt() {
        return unlockedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public void setUnlockedAt(LocalDateTime unlockedAt) {
        this.unlockedAt = unlockedAt;
    }
}