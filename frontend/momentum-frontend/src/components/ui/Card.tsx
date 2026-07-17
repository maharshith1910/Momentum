import type { ReactNode } from "react";

type CardProps = {
    children: ReactNode;
    className?: string;
};

export default function Card({
                                 children,
                                 className = "",
                             }: CardProps) {
    return (
        <div
            className={`
                bg-slate-800
                border
                border-slate-700
                rounded-2xl
                shadow-md
                p-6
                ${className}
            `}
        >
            {children}
        </div>
    );
}