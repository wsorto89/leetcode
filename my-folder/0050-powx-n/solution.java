class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if(n > 0) {
            return myPowHelper(x, n);
        } else {
            return 1/myPowHelper(x, Math.abs(n));
        }
    }
    
    private double myPowHelper(double x, int n) {
        if(n == 1) {
            return x;
        }
        if(n == 0) {
            return 1;
        }
        double accum = myPowHelper(x, n/2);
        if (n % 2 == 0) {
            return accum * accum;
        }
        else {
            return x * accum * accum;
        }
    }
}
