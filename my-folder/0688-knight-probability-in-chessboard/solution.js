/**
 * @param {number} N
 * @param {number} K
 * @param {number} r
 * @param {number} c
 * @return {number}
 */
var knightProbability = function(N, K, r, c) {
    const map = new Map();
    return helper(N, K, r, c, map);
};

var helper = function(N, K, r, c, map) {
    let prob = 0;
    if(K == 0) {
        return 1;
    }
    else if(K == 1) {
        return findProb(r, c, N);
    }
    if(map.has(`${r}-${c}-${K}`)) {
       return map.get(`${r}-${c}-${K}`);
    }
    let possibleMoves = findPossibleMoves(r, c);
    let validMoves = findValidMoves(possibleMoves, N);
    validMoves.map(move => {
        prob += helper(N, K-1, move.r, move.c, map);
    });
    prob = prob/8;
    map.set(`${r}-${c}-${K}`, prob);
    
    return prob;
}

var findProb = function(r, c, N) {
    let possibleMoves = findPossibleMoves(r, c);
    let validMoves = findValidMoves(possibleMoves, N);
    return validMoves.length/8;
}

var findPossibleMoves = function(r, c) {
    let possibleMoves = [];
    possibleMoves.push({r: r+1, c: c-2});
    possibleMoves.push({r: r+2, c: c-1});
    possibleMoves.push({r: r+2, c: c+1});
    possibleMoves.push({r: r+1, c: c+2});
    possibleMoves.push({r: r-1, c: c+2});
    possibleMoves.push({r: r-2, c: c+1});
    possibleMoves.push({r: r-2, c: c-1});
    possibleMoves.push({r: r-1, c: c-2});
    
    return possibleMoves;
}

var findValidMoves = function(possibleMoves, N) {
    let validMoves = [];
    possibleMoves.map(move => {
        if((move.r > -1 && move.c > -1) && (move.r < N && move.c < N)) {
            validMoves.push({r: move.r, c: move.c});
        }
    })
    
    return validMoves;
}
