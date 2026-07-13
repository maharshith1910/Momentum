package com.maharshith.backend.analytics.service;

import com.maharshith.backend.analytics.dto.AnalyticsResponse;
import com.maharshith.backend.analytics.dto.MonthlyAnalyticsResponse;
import com.maharshith.backend.analytics.dto.WeeklyAnalyticsResponse;
import com.maharshith.backend.entity.User;

import java.util.List;

public interface AnalyticsService {

    AnalyticsResponse getAnalytics(User user);

    List<WeeklyAnalyticsResponse> getWeeklyAnalytics(User user);

    List<MonthlyAnalyticsResponse> getMonthlyAnalytics(User user);

}