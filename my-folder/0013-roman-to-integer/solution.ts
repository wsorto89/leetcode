function romanToInt(s: string): number {
    let total = 0;
    const subtract = (next: string, subtractable1: string, subtractable2: string) => next === subtractable1 || next === subtractable2 ? -1 : 1;

    for (let i = 0; i < s.length; i++) {
        const cur = s[i];
        const next = s[i + 1] || '';

        switch (cur) {
            case 'M':
                total += 1000;
                break;
            case 'D':
                total += 500;
                break;
            case 'C':
                total += 100 * subtract(next, 'D', 'M');
                break;
            case 'L':
                total += 50;
                break;
            case 'X':
                total += 10 * subtract(next, 'L', 'C');
                break;
            case 'V':
                total += 5;
                break;
            case 'I':
                total += 1 * subtract(next, 'V', 'X');
                break;
        }
    }

    return total;
};
