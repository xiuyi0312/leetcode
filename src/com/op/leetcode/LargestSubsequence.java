package com.op.leetcode;

public class LargestSubsequence {
    public static void main(String[] args) {
        LargestSubsequence largestSubsequence = new LargestSubsequence();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(largestSubsequence.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int sum = nums[0];
        int maxValue = sum;
        for (int i = 1; i < nums.length; i++) {
            // sum[i] means the sub sequence ends with nums[i]
            sum = Math.max(sum + nums[i], nums[i]);
            maxValue = Math.max(sum, maxValue);
        }
        return maxValue;
    }
}
