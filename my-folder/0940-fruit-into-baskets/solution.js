/**
 * @param {number[]} tree
 * @return {number}
 */
var totalFruit = function(tree) {
    if(tree.length === 0) {
        return 0;
    }
    let maxFruits = 1;
    let start = 0;
    let newStart = 0;
    let currentSum = 0;
    let basket1 = tree[0];
    let basket2 = -1;
    
    for(let i = 1; i < tree.length; i++) {
        if(basket2 === -1 && basket1 !== tree[i]) {
            basket2 = tree[i];
        } else if(tree[i] !== basket1 && tree[i] !== basket2){
            start = newStart;
            basket1 = tree[i-1];
            basket2 = tree[i];
        }
        maxFruits = Math.max(maxFruits, i - start + 1);
        if(tree[i] != tree[i-1]) {
            newStart = i;
        }
    }
    
    return maxFruits;
};

