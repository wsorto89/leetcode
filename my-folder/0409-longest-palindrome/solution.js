/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
    if (s.length <= 1) {
        return s.length;
    }
    const charLengthMap = new Map();
    [...s].forEach(c => {
        const cLength = charLengthMap.get(c);
        if (cLength) {
            charLengthMap.set(c, cLength + 1)
        } else {
            charLengthMap.set(c, 1)
        }
    });
    let maxPLength = 0;
    let usingOdd = false;
    charLengthMap.forEach((value, key) => {
        if (value % 2 === 0) {
            maxPLength += value;
        } else {
            usingOdd = true;
            maxPLength += value - 1;
        }
    })
    return maxPLength + (usingOdd ? 1 : 0);
};
