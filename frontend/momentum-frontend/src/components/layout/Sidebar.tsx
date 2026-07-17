import { NavLink } from "react-router-dom";

const links = [
    { name: "Dashboard", path: "/dashboard" },
    { name: "Habits", path: "/habits" },
    { name: "Analytics", path: "/analytics" },
    { name: "Heatmap", path: "/heatmap" },
    { name: "Achievements", path: "/achievements" },
    { name: "Reminders", path: "/reminders" },
    { name: "Profile", path: "/profile" },
    { name: "Settings", path: "/settings" },
];

export default function Sidebar() {
    return (
        <aside className="w-72 bg-slate-800 border-r border-slate-700 p-6">

            <h1 className="text-3xl font-bold text-white mb-8">
                Momentum
            </h1>

            <nav className="space-y-3">

                {links.map((link) => (
                    <NavLink
                        key={link.path}
                        to={link.path}
                        className={({ isActive }) =>
                            `block rounded-lg px-4 py-3 transition ${
                                isActive
                                    ? "bg-indigo-600 text-white"
                                    : "text-slate-300 hover:bg-slate-700 hover:text-white"
                            }`
                        }
                    >
                        {link.name}
                    </NavLink>
                ))}

            </nav>

        </aside>
    );
}