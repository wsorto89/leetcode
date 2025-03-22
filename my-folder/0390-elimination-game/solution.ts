function lastRemaining(n: number): number {
    const eliminate = (n: number, startFromLeft: boolean) => {
        if (n === 1) {
            return 1;
        }
        const updatedN = Math.floor(n/2)
        if (startFromLeft) {
            return 2 * eliminate(updatedN, false);
        } else {
            if (n % 2 === 0) {
                return 2 * eliminate(updatedN, true) - 1;
            } else {
                return 2 * eliminate(updatedN, true);
            }
        }
    }

    return eliminate(n, true);
};
