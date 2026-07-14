package com.maharshith.backend.achievement.service;

import com.maharshith.backend.achievement.dto.AchievementResponse;
import com.maharshith.backend.achievement.dto.UserLevelResponse;
import com.maharshith.backend.entity.User;

import java.util.List;

public interface AchievementService {

    List<AchievementResponse> getAllAchievements(User user);
    UserLevelResponse getLevel(User user);
    void checkAchievements(User user);
}