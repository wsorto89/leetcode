function twoSum(nums: number[], target: number): number[] {
    /*
    O(n^2)
    for (let i = 0; i < nums.length; i++) {
        const x = target - nums[i];
        const xIndex = nums.lastIndexOf(x);
        if (xIndex > -1 && xIndex !== i) {
            return [i, xIndex];
        }
    }
    */

    const map = new Map<number, number>();
    for (let i = 0; i < nums.length; i++) {
        const x = target - nums[i];
        if (map.has(x)) {
            return [map.get(x), i]
        }
        map.set(nums[i], i);
    }
};
