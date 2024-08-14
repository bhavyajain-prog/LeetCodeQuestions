// You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

// Constraints:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].

import java.util.Arrays;

public class Q45 {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
    }

    int helper(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length - 1) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[ind]; i++) {
            int next = ind + i;
            if (next < nums.length) {
                int steps = helper(nums, next, dp);
                if (steps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, steps + 1);
                }
            }
        }
        dp[ind] = minJumps;
        return minJumps;
    }
}
