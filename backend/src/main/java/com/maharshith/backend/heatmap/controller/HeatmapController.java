package com.maharshith.backend.heatmap.controller;

import com.maharshith.backend.auth.security.CustomUserDetails;
import com.maharshith.backend.entity.User;
import com.maharshith.backend.heatmap.dto.HeatmapResponse;
import com.maharshith.backend.heatmap.service.HeatmapService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heatmap")
public class HeatmapController {

    private final HeatmapService heatmapService;

    public HeatmapController(HeatmapService heatmapService) {
        this.heatmapService = heatmapService;
    }

    @GetMapping
    public HeatmapResponse getHeatmap(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        User user = userDetails.getUser();

        return heatmapService.getHeatmap(user);
    }
}