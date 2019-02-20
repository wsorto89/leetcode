class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1 || K == 1) {
            return 0;
        }
        else {
            return helper(N, K);
        }
    }
    
    //Whenever N goes up by 1,
    //The following row is a copy of the previous row, followed by the complements of the previous row
    private int helper(int N, int K) {
        if(N == 1 || K == 1) {
            return 0;
        }
        else if(N == 2 && K == 2) {
            return 1;
        }
        else {
            //offset tells us if the Kth index has already been calculated
            //otherwise we take the complement
            int offset = (int) Math.pow(2, N-2);
            if(K <= offset) {
                //result is the same
                return helper(N - 1, K);
            }
            else {
                //take the complement of the previous row
                return helper(N - 1, K - offset) ^ 1;
            }
        }
    }
}
