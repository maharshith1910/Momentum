import PageTitle from "../../components/common/PageTitle";
import StreakCard from "./StreakCard.tsx";
import TodayHabitsCard from "./TodayHabitsCard.tsx";
import WeeklyProgressCard from "./WeeklyProgressCard.tsx";
import QuickStatsCard from "./QuickStatsCard.tsx";
import CompletionCard from "./CompletionCard.tsx";

export default function Dashboard() {
    return (
        <>
            <PageTitle
                title="Dashboard"
                subtitle="Track your progress every day."
            />

            <div className="grid grid-cols-3 gap-6">

                <StreakCard />

                <TodayHabitsCard />

                <CompletionCard />

                <WeeklyProgressCard />

                <QuickStatsCard />

            </div>
        </>
    );
}