package com.maharshith.backend.achievement.controller;

import com.maharshith.backend.achievement.dto.AchievementResponse;
import com.maharshith.backend.achievement.dto.UserLevelResponse;
import com.maharshith.backend.achievement.service.AchievementService;
import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public List<AchievementResponse> getAchievements(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        User user = userDetails.getUser();
        return achievementService.getAllAchievements(user);
    }

    @PostMapping("/check")
    public String checkAchievements(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        User user = userDetails.getUser();
        achievementService.checkAchievements(user);
        return "Achievements checked successfully!";
    }

    @GetMapping("/level")
    public UserLevelResponse getLevel(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        User user = userDetails.getUser();
        return achievementService.getLevel(user);
    }
}