import type { ReactNode } from "react";

import Sidebar from "./Sidebar";
import Topbar from "./Topbar";

type DashboardLayoutProps = {
    children: ReactNode;
};

export default function DashboardLayout({
                                            children,
                                        }: DashboardLayoutProps) {
    return (
        <div className="flex min-h-screen bg-slate-900">

            <Sidebar />

            <div className="flex flex-col flex-1 min-w-0">

                <Topbar />

                <main className="flex-1 overflow-y-auto p-8">
                    {children}
                </main>

            </div>

        </div>
    );
}