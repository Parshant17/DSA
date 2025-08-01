class Solution {
    public String convertToTitle(int columnNumber) {
           StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // adjust to 0-based index
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);
            sb.append(ch);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    
    }
}