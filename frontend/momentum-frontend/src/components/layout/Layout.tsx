import type { ReactNode } from "react";

interface LayoutProps {
    children: ReactNode;
}

export default function Layout({ children }: LayoutProps) {
    return (
        <div className="min-h-screen flex bg-slate-900 text-white">

            {/* Sidebar */}
            <aside className="w-64 bg-slate-800 p-6">
                <h1 className="text-3xl font-bold mb-10">
                    Momentum
                </h1>

                <nav className="space-y-4">
                    <div>Dashboard</div>
                    <div>Habits</div>
                    <div>Analytics</div>
                    <div>Heatmap</div>
                    <div>Achievements</div>
                    <div>Reminders</div>
                    <div>Profile</div>
                    <div>Settings</div>
                </nav>
            </aside>

            {/* Main */}
            <main className="flex-1 p-8">
                {children}
            </main>

        </div>
    );
}