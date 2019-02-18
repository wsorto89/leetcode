class Solution {
    public int climbStairs(int n) {
        int[] results = new int[n + 1];
        return climbStairsHelper(n, results);
    }
    
    private int climbStairsHelper(int n, int[] results) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else if(results[n] != 0) {
            return results[n];
        } else {
            int result = climbStairsHelper(n - 1, results) + climbStairsHelper(n - 2, results);
            results[n] = result;
            return result;
        }
    }
}
