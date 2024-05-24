// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).

// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

// Example 3:
// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".

public class Q10 {
    public static boolean isMatch(String s, String p) {
        if (s == p)
            return true;

        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                continue;
            } else if (p.charAt(j) == '.') {
                i++;
                j++;
                continue;
            } else if (p.charAt(j) == '*') {
                if(j<p.length()-1) {
                    // if(p.charAt(j+1) == s.charAt(i)) {
                    //     i++;
                    //     continue;
                    // } else {
                    //     return false;
                    // }

                    if(p.charAt(j+1) != s.charAt(i)) {
                        i++;
                        continue;
                    } else if(i<s.length() && p.charAt(j+1) == s.charAt(i)) {
                        j+=2;
                        i++;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
        if(i<s.length()) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isMatch("vijay","*y"));
    }
}
