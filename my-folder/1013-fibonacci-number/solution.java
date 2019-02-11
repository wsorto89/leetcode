class Solution {
    public int fib(int N) {
        int[] fibValues = new int[N + 1];
        Arrays.fill(fibValues, -1);
        if (N > 1) {
            fibValues[0] = 0;
            fibValues[1] = 1;
        }
        
        return fibHelper(fibValues, N);
    }
    
    int fibHelper(int[] fibValues, int N) {
        if (N < 2) {
            return N;
        }
        if (fibValues[N] != -1) {
            return fibValues[N];
        } else {
            fibValues[N] = fibHelper(fibValues, N - 1) + fibHelper(fibValues, N - 2);
            return fibValues[N];
        }
    }
}
