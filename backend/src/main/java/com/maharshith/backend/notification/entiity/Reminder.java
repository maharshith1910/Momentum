package com.maharshith.backend.notification.entity;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.habit.entity.Habit;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalTime reminderTime;

    @Column(nullable = false)
    private boolean enabled = true;

    public Reminder() {
    }

    public Reminder(Habit habit,
                    User user,
                    LocalTime reminderTime,
                    boolean enabled) {
        this.habit = habit;
        this.user = user;
        this.reminderTime = reminderTime;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public Habit getHabit() {
        return habit;
    }

    public User getUser() {
        return user;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}