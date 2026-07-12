package com.maharshith.backend.dashboard.service;

import com.maharshith.backend.dashboard.dto.DashboardResponse;
import com.maharshith.backend.entity.User;

public interface DashboardService {

    DashboardResponse getDashboard(User user);

}