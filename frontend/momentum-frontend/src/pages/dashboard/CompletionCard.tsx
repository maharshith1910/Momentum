import Card from "../../components/ui/Card";

export default function CompletionCard() {

    const percentage = 50;

    return (
        <Card className="h-56 flex flex-col justify-center items-center">

            <h3 className="text-white font-semibold text-lg">
                Completion
            </h3>

            <h1 className="text-6xl font-black text-indigo-400 mt-5">
                {percentage}%
            </h1>

            <p className="text-slate-400 mt-2">
                2 of 4 habits completed
            </p>

        </Card>
    );
}