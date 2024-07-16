# // You are given a string s and an array of strings words. All the strings of words are of the same length.

# // A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

# // For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
# // Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

# // Example 1:
# // Input: s = "barfoothefoobarman", words = ["foo","bar"]
# // Output: [0,9]
# // Explanation:
# // The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
# // The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

# // Example 2:
# // Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
# // Output: []
# // Explanation:
# // There is no concatenated substring.

# // Example 3:
# // Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
# // Output: [6,9,12]
# // Explanation:
# // The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
# // The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
# // The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
class Solution(object):
    def findSubstring(s,words):
        result = []
        if not s or len(s) == 0: return result

        wordLength = len(words[0])
        totalLength = wordLength * len(words)
        if len(s) < totalLength: return result

        dict = {}
        for word in words:
            if word in dict.keys():
                dict[word] += 1
            else:
                dict[word] = 1
        for i in range(len(s) - totalLength+1):
            temp = dict.copy()
            for j in range(len(words)):
                word = s[i+j*wordLength:i+(j+1)*wordLength]
                if word in dict.keys():
                    temp[word]-=1
                    if temp[word] == 0:
                        del temp[word]
                else:
                    break
            if not temp:
                result.append(i)
        return result