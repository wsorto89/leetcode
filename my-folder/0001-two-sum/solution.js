/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const result = [];
    const complements = new Map();
    for(let i = 0; i < nums.length; i++) {
        if(complements.has(nums[i])) {
            result.push(complements.get(nums[i]));
            result.push(i);
            break;
        }
        complements.set(target - nums[i], i);
    }
    
    return result;
};
