import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "../pages/auth/Login";
import Register from "../pages/auth/Register";

import DashboardLayout from "../components/layout/DashboardLayout";

import Dashboard from "../pages/dashboard/Dashboard";
import Habits from "../pages/habits/Habits";
import Analytics from "../pages/analytics/Analytics";
import Heatmap from "../pages/heatmap/Heatmap";
import Profile from "../pages/profile/Profile";
import Reminders from "../pages/reminders/Reminders";
import Achievements from "../pages/achievements/Achievements";
import Settings from "../pages/settings/Settings";

export default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>

                {/* Public Routes */}
                <Route path="/" element={<Login />} />
                <Route path="/register" element={<Register />} />

                {/* Protected Routes */}
                <Route
                    path="/dashboard"
                    element={
                        <DashboardLayout>
                            <Dashboard />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/habits"
                    element={
                        <DashboardLayout>
                            <Habits />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/analytics"
                    element={
                        <DashboardLayout>
                            <Analytics />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/heatmap"
                    element={
                        <DashboardLayout>
                            <Heatmap />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/profile"
                    element={
                        <DashboardLayout>
                            <Profile />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/reminders"
                    element={
                        <DashboardLayout>
                            <Reminders />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/achievements"
                    element={
                        <DashboardLayout>
                            <Achievements />
                        </DashboardLayout>
                    }
                />

                <Route
                    path="/settings"
                    element={
                        <DashboardLayout>
                            <Settings />
                        </DashboardLayout>
                    }
                />

            </Routes>
        </BrowserRouter>
    );
}