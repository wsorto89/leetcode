/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let lowIndex = 0;
    let highIndex = nums.length - 1;
    while (lowIndex <= highIndex) {
        const midIndex = Math.floor((lowIndex + highIndex) / 2);
        if (target === nums[midIndex]) {
            return midIndex;
        } else if (target < nums[midIndex]) {
            highIndex = midIndex - 1;
        } else {
            lowIndex = midIndex + 1;
        }
    }
    return -1;
};
