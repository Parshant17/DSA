class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow, and work with positive numbers
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int result = 0;

        // Subtract divisor from dividend using bit manipulation
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            long multiple = 1;
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            lDividend -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
