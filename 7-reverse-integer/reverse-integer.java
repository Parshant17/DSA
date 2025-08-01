public class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying and adding
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // underflow
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
