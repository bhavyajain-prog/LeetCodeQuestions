// You are given a string s and an array of strings words. All the strings of words are of the same length.

// A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
// Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

// Example 1:
// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation:
// The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
// The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

// Example 2:
// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
// Output: []
// Explanation:
// There is no concatenated substring.

// Example 3:
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// Output: [6,9,12]
// Explanation:
// The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
// The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
// The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

import java.util.List;
import java.util.ArrayList;

public class Q30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) {
            return result;
        }
        int[] map = new int[256];
        for (String word : words) {
            map[word.charAt(0)]++;
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            while (right + wordLen <= s.length()) {
                char c = s.charAt(right);
                right += wordLen;
                if (map[c]-- > 0) {
                    count++;
                }
                while (map[c] < 0) {
                    char d = s.charAt(left);
                    map[d]++;
                    if (map[d] > 0) {
                        count--;
                    }
                    left += wordLen;
                }
                if (count == words.length) {
                    result.add(left);
                }
            }
            map = new int[256];
            for (String word : words) {
                map[word.charAt(0)]++;
            }
        }
        return result;
    }
}
