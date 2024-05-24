// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"] 

// Constraints:
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17 {
    private static final HashMap<Integer, String> digit = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        digit.put(2, "abc");
        digit.put(3, "def");
        digit.put(4, "ghi");
        digit.put(5, "jkl");
        digit.put(6, "mno");
        digit.put(7, "pqrs");
        digit.put(8, "tuv");
        digit.put(9, "wxyz");

        
    }
}
