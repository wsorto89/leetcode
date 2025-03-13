function generateParenthesis(n: number): string[] {
    const results: string[] = [];
    function solve(cur: string, open: number, close: number): void {
        if (open === n && close === n) {
            results.push(cur)
            return;
        }

        if (open < n) {
            solve(`${cur}(`, open + 1, close)
        }

        if (close < open) {
            solve(`${cur})`, open, close + 1)
        }
    }
    solve("", 0, 0)

    return results;
};
