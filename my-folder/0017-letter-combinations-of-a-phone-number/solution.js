/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    const phoneMap = createPhoneMap();
    let result = [];
    if(digits.length > 0) {
        backTrack("", digits, result, phoneMap);
    }
    
    return result;
};

const backTrack = (currentCombo, remainingDigits, result, phoneMap) => {
    if(remainingDigits.length === 0) {
        result.push(currentCombo);
        return result;
    }
    const digit = remainingDigits.substr(0, 1);
    const letters = phoneMap.get(digit);
    for(let letter of letters) {
        backTrack(currentCombo + letter, remainingDigits.substr(1), result, phoneMap);
    }
    return result;
}

const createPhoneMap = () => {
    const numToLetter = new Map();
    numToLetter.set("2", ["a", "b", "c"]);
    numToLetter.set("3", ["d", "e", "f"]);
    numToLetter.set("4", ["g", "h", "i"]);
    numToLetter.set("5", ["j", "k", "l"]);
    numToLetter.set("6", ["m", "n", "o"]);
    numToLetter.set("7", ["p", "q", "r", "s"]);
    numToLetter.set("8", ["t", "u", "v"]);
    numToLetter.set("9", ["w", "x", "y", "z"]);
    
    return numToLetter;
}
