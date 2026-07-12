package com.maharshith.backend.habit.entity;

import com.maharshith.backend.entity.User;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    @Column(nullable = false)
    private Integer streak = 0;

    @Column(nullable = false)
    private Integer longestStreak = 0;

    private LocalDate lastCompletedDate;

    @Column(nullable = false)
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    // ===== Constructors =====

    public Habit() {
    }

    public Habit(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.completed = false;
        this.createdAt = LocalDate.now();
        this.streak  = 0;
        this.longestStreak = 0;
        this.lastCompletedDate = null;

    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
    }

    // ===== Getters & Setters =====
    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public void setLongestStreak(Integer longestStreak) {
        this.longestStreak = longestStreak;
    }

    public void setLastCompletedDate(LocalDate lastCompletedDate) {
        this.lastCompletedDate = lastCompletedDate;
    }

    public Integer getLongestStreak() {
        return longestStreak;
    }

    public Integer getStreak() {
        return streak;
    }

    public LocalDate getLastCompletedDate() {
        return lastCompletedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}