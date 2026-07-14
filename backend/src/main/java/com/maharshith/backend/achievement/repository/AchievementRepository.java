package com.maharshith.backend.achievement.repository;

import com.maharshith.backend.achievement.entity.Achievement;
import com.maharshith.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findByUser(User user);

    Optional<Achievement> findByUserAndTitle(User user, String title);

    boolean existsByUserAndTitle(User user, String title);
}