# Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
# Each number in candidates may only be used once in the combination.
# Note: The solution set must not contain duplicate combinations.

# Example 1:
# Input: candidates = [10,1,2,7,6,1,5], target = 8
# Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

# Example 2:
# Input: candidates = [2,5,2,1,2], target = 5
# Output: [[1,2,2],[5]]
class Solution(object):
    def helper(self, res, path, candidates, target, index):
        if target == 0:
            res.append(list(path))
            return
        if target < 0:
            return
        
        for i in range(index, len(candidates)):
            if i > index and candidates[i] == candidates[i - 1]:
                continue
            path.append(candidates[i])
            self.helper(res, path, candidates, target - candidates[i], i + 1)
            path.pop()
    
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        res = []
        self.helper(res, [], candidates, target, 0)
        return res