class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums.sort()
        i=1
        while nums[i]!=nums[i-1] and i<len(nums):
            i+=1
        if i==len(nums): return True
        else: return False
print(Solution.containsDuplicate([1,2,3,1]))