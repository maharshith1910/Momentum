import Card from "../../components/ui/Card";
import { Circle, CheckCircle2 } from "lucide-react";

const habits = [
    { name: "Morning Workout", done: true },
    { name: "Read 30 Minutes", done: true },
    { name: "Drink 3L Water", done: false },
    { name: "Meditation", done: false },
];

export default function TodayHabitsCard() {
    return (
        <Card className="h-56">

            <h3 className="text-white font-semibold text-lg mb-5">
                Today's Habits
            </h3>

            <div className="space-y-4">

                {habits.map((habit) => (

                    <div
                        key={habit.name}
                        className="flex items-center justify-between"
                    >

                        <span className="text-slate-300">
                            {habit.name}
                        </span>

                        {habit.done ? (
                            <CheckCircle2
                                className="text-green-500"
                                size={22}
                            />
                        ) : (
                            <Circle
                                className="text-slate-500"
                                size={22}
                            />
                        )}

                    </div>

                ))}

            </div>

        </Card>
    );
}