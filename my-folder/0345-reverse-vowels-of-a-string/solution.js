/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    if(s.length < 2) {
       return s;
    }
    let arr = s.split('');
    let lPtr = 0;
    let rPtr = arr.length - 1;
    const vowelSet = createVowelSet();
    
    while(lPtr < rPtr) {
        let l = arr[lPtr];
        let r = arr[rPtr];
        if(vowelSet.has(l) && vowelSet.has(r)) {
            arr[lPtr] = r;
            arr[rPtr] = l;
            lPtr++;
            rPtr--;
        }
        else {
            if(!vowelSet.has(l)) {
                lPtr++;
            }
            if(!vowelSet.has(r)) {
                rPtr--;
            }
        }
    }
    
    return arr.join('');
};

var createVowelSet = function() {
    const vowelSet = new Set();
    vowelSet.add("a");
    vowelSet.add("e");
    vowelSet.add("i");
    vowelSet.add("o");
    vowelSet.add("u");
    vowelSet.add("A");
    vowelSet.add("E");
    vowelSet.add("I");
    vowelSet.add("O");
    vowelSet.add("U");
    
    return vowelSet;
}
