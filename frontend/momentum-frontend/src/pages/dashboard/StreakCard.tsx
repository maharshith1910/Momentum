import Card from "../../components/ui/Card";
import { Flame } from "lucide-react";

export default function StreakCard() {
    const currentStreak = 12;
    const bestStreak = 28;

    return (
        <Card className="h-40 flex flex-col justify-between">

            <div className="flex items-center justify-between">

                <h3 className="text-white font-semibold text-lg">
                    Current Streak
                </h3>

                🔥

            </div>

            <div>

                <h1 className="text-5xl font-black text-white leading-none">
                    {currentStreak}
                </h1>

                <p className="text-slate-400 mt-1">
                    Days
                </p>

            </div>

            <div className="flex justify-between text-sm">

                <span className="text-green-400">
                    +3 from last week
                </span>

                <span className="text-slate-400">
                    Best : {bestStreak}
                </span>

            </div>

        </Card>
    );
}