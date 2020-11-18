package com.op.leetcode;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
//        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] input = {2, 2};
        System.out.println(longestIncreasingSequence.lengthOfLIS(input));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int[] length = new int[nums.length];
        Arrays.fill(length, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = length[i];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    m = Math.max(m, length[j] + 1);
                }
            }
            length[i] = m;
            max = Math.max(max, m);
        }
        return max;
    }
}
