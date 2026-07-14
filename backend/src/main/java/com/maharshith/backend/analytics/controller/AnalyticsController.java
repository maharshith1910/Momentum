package com.maharshith.backend.analytics.controller;

import com.maharshith.backend.analytics.dto.AnalyticsResponse;
import com.maharshith.backend.analytics.dto.MonthlyAnalyticsResponse;
import com.maharshith.backend.analytics.dto.WeeklyAnalyticsResponse;
import com.maharshith.backend.analytics.service.AnalyticsService;
import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maharshith.backend.analytics.dto.AnalyticsSummaryResponse;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping
    public AnalyticsResponse getAnalytics(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return analyticsService.getAnalytics(user);
    }

    @GetMapping("/weekly")
    public List<WeeklyAnalyticsResponse> getWeeklyAnalytics(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return analyticsService.getWeeklyAnalytics(user);
    }

    @GetMapping("/monthly")
    public List<MonthlyAnalyticsResponse> getMonthlyAnalytics(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return analyticsService.getMonthlyAnalytics(user);
    }
    @GetMapping("/summary")
    public AnalyticsSummaryResponse getSummary(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return analyticsService.getSummary(
                userDetails.getUser()
        );
    }
}