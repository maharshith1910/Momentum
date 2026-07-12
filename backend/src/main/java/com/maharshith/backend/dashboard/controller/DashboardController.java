package com.maharshith.backend.dashboard.controller;

import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.dashboard.dto.DashboardResponse;
import com.maharshith.backend.dashboard.service.DashboardService;
import com.maharshith.backend.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboard(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return dashboardService.getDashboard(user);
    }
}