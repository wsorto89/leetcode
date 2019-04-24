/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length < 2) {
        return nums;
    }
    
    let index = 1;
    for(let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[i-1]) {
            nums[index] = nums[i];
            index++;
        }
    }
    
    return index;
};
