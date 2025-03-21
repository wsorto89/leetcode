function numberToWords(num: number): string {
    const TEN = 10;
    const HUNDRED = 100;
    const THOUSAND = 1000;
    const MILLION = 1000000;
    const BILLION = 1000000000;
    const belowTenDic = {
        0: 'Zero',
        1: 'One',
        2: 'Two',
        3: 'Three',
        4: 'Four',
        5: 'Five',
        6: 'Six',
        7: 'Seven',
        8: 'Eight',
        9: 'Nine',
    }

    const belowTwentyDic = {
        10: 'Ten',
        11: 'Eleven',
        12: 'Twelve',
        13: 'Thirteen',
        14: 'Fourteen',
        15: 'Fifteen',
        16: 'Sixteen',
        17: 'Seventeen',
        18: 'Eighteen',
        19: 'Nineteen',
    }

    const belowHundred = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    const belowTen = (num : number) => {
        return belowTenDic[num];
    }

    const belowTwenty = (num: number) => {
        return belowTwentyDic[num];
    }

    // const recurse = (divisor: number, label: string) => {
    //     const floor = Math.floor(num / divisor);
    //     const remainder = num % divisor;
    //     return `${convertToWords(floor)} ${label}${remainder > 0 ? ` ${convertToWords(remainder)}` : ''}`;
    // }

    const convertToWords = (num: number): string => {
        if (num < TEN) {
            return belowTen(num);
        }
        if (num < 20) {
            return belowTwenty(num);
        }
        if (num < HUNDRED) {
            const floor = Math.floor(num / TEN);
            const remainder = num % TEN;
            return `${belowHundred[floor]}${remainder > 0 ? ` ${convertToWords(remainder)}` : ""}`;
        }
        if (num < THOUSAND) {
            const floor = Math.floor(num / HUNDRED);
            const remainder = num % HUNDRED;
            return `${convertToWords(floor)} Hundred${remainder > 0 ? ` ${convertToWords(remainder)}` : ''}`;
        }
        if (num < MILLION) {
            const floor = Math.floor(num / THOUSAND);
            const remainder = num % THOUSAND;
            return `${convertToWords(floor)} Thousand${remainder > 0 ? ` ${convertToWords(remainder)}` : ''}`;
        }
        if (num < BILLION) {
            const floor = Math.floor(num / MILLION);
            const remainder = num % MILLION;
            return `${convertToWords(floor)} Million${remainder > 0 ? ` ${convertToWords(remainder)}` : ''}`;
        }
        const floor = Math.floor(num / BILLION);
        const remainder = num % BILLION;
        return `${convertToWords(floor)} Billion${remainder > 0 ? ` ${convertToWords(remainder)}` : ''}`;
    }
    return convertToWords(num);
};
