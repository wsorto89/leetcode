function threeSum(nums: number[]): number[][] {
    const results: number[][] = [];
    
    nums.sort((a, b) => a - b)

    for (let i = 0; i < nums.length; i++) {
        // no need to look at duplicates
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        const target = -nums[i];
        let leftIndex = i + 1;
        let rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            const currentSum = nums[leftIndex] + nums[rightIndex];
            if (currentSum === target) {
                results.push([nums[i], nums[leftIndex], nums[rightIndex]]);
                while (leftIndex < rightIndex && nums[leftIndex] === nums[leftIndex + 1]) {
                    leftIndex++;
                }
                while (leftIndex < rightIndex && nums[rightIndex] === nums[rightIndex - 1]) {
                    rightIndex--;
                }
                leftIndex++;
                rightIndex--;
            }
            else if (currentSum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
    }
    return results;
};
