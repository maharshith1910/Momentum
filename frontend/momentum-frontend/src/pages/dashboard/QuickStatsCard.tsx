import Card from "../../components/ui/Card";

export default function QuickStatsCard() {

    return (

        <Card className="h-72">

            <h3 className="text-white font-semibold text-lg mb-6">
                Quick Stats
            </h3>

            <div className="space-y-5">

                <div className="flex justify-between">

                    <span className="text-slate-400">
                        Total Habits
                    </span>

                    <span className="text-white font-bold">
                        14
                    </span>

                </div>

                <div className="flex justify-between">

                    <span className="text-slate-400">
                        Completed Today
                    </span>

                    <span className="text-green-400 font-bold">
                        2
                    </span>

                </div>

                <div className="flex justify-between">

                    <span className="text-slate-400">
                        Longest Streak
                    </span>

                    <span className="text-orange-400 font-bold">
                        28 Days
                    </span>

                </div>

                <div className="flex justify-between">

                    <span className="text-slate-400">
                        Success Rate
                    </span>

                    <span className="text-indigo-400 font-bold">
                        84%
                    </span>

                </div>

            </div>

        </Card>

    );

}