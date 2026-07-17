import Card from "../../components/ui/Card";

const progress = [4, 6, 8, 5, 9, 7, 10];

export default function WeeklyProgressCard() {

    return (
        <Card className="h-72">

            <h3 className="text-white font-semibold text-lg mb-8">
                Weekly Progress
            </h3>

            <div className="flex items-end justify-between h-44">

                {progress.map((value, index) => (

                    <div
                        key={index}
                        className="flex flex-col items-center gap-3"
                    >

                        <div
                            className="bg-indigo-500 rounded-t-lg w-8"
                            style={{
                                height: `${value * 14}px`,
                            }}
                        />

                        <span className="text-xs text-slate-400">

                            {["M","T","W","T","F","S","S"][index]}

                        </span>

                    </div>

                ))}

            </div>

        </Card>
    );
}