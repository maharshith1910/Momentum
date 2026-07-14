package com.maharshith.backend.heatmap.service;

import com.maharshith.backend.entity.User;
import com.maharshith.backend.heatmap.dto.HeatmapResponse;

public interface HeatmapService {

    HeatmapResponse getHeatmap(User user);

}