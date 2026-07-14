package com.maharshith.backend.achievement.entity;

import com.maharshith.backend.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String badge;

    private int xpReward;

    private LocalDateTime unlockedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Achievement() {
    }

    public Achievement(String title,
                       String description,
                       String badge,
                       int xpReward,
                       LocalDateTime unlockedAt,
                       User user) {
        this.title = title;
        this.description = description;
        this.badge = badge;
        this.xpReward = xpReward;
        this.unlockedAt = unlockedAt;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(User user) {
        this.user = user;
    }
}