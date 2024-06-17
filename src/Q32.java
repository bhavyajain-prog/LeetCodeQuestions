// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
// substring
// .

// Example 1:

// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:

// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:

// Input: s = ""
// Output: 0
public class Q32 {
    public int longestValidParenthesis(String s) {
        int returnValue = 0;
        int left = 0;
        int open = 0;
        int close = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '(') {
                open++;
            } else if (s.charAt(right) == ')') {
                close++;
            } else
                break;
        }
        return returnValue;
    }
}