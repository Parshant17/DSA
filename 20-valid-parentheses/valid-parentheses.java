import java.util.Stack;

class Solution {
    private boolean compareOpeningAndClosing(char openingBracket, char closingBracket) {
        return (openingBracket == '(' && closingBracket == ')') ||
               (openingBracket == '{' && closingBracket == '}') ||
               (openingBracket == '[' && closingBracket == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char singleBracket : s.toCharArray()) {
            if (singleBracket == '(' || singleBracket == '{' || singleBracket == '[') {
                stack.push(singleBracket);
            } else {
                // If stack is empty or brackets don't match, return false
                if (stack.isEmpty() || !compareOpeningAndClosing(stack.peek(), singleBracket)) {
                    return false;
                }
                stack.pop(); // matched, so remove from stack
            }
        }

        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }
}
