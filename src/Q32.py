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