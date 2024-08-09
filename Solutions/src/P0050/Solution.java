package P0050;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2.00000, -2147483648));
    }

    public double calculatePow(double x, long n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n < 0) return 1.0 / calculatePow(x,-n);

        double result = calculatePow(x, n/2);
        result = result * result;

        if (n%2 == 1) result = result *x;
        return result;

    }
    public double myPow(double x, int n) {
        return calculatePow(x,(long)n);
    }
}
