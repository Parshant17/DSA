class Solution {
    

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        
        // Initialize each row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Reverse direction if we hit the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1));  // Output: PAHNAPLSIIGYIR

        // Test case 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2));  // Output: PINALSIGYAHRPI

        // Test case 3
        String s3 = "A";
        int numRows3 = 1;
        System.out.println(convert(s3, numRows3));  // Output: A
    }


    
}