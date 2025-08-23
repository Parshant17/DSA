class Solution {
    public String multiply(String num1, String num2) {
        // Handle the case where either number is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // Maximum possible length of product
        
        // Multiply each digit from right to left
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                
                // Multiply the digits and add to the existing value at position i+j+1
                int product = digit1 * digit2;
                int sum = product + result[i + j + 1];
                
                // Update the current position and carry over
                result[i + j + 1] = sum % 10; // Current digit
                result[i + j] += sum / 10;     // Carry to the next position
            }
        }
        
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            // Skip leading zeros
            if (sb.length() == 0 && digit == 0) {
                continue;
            }
            sb.append(digit);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}