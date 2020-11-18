package com.op.leetcode;

import java.util.Arrays;

public class SingleNumber1 {
    public static void main(String[] args) {
        int[] nums = {-2, -2, -2, -3, -3, -3, 1, 1, 1, -4};
//        100
//        001
//        001
//        001
//        010
//        010
//        010
        SingleNumber1 singleNumber1 = new SingleNumber1();
        System.out.println(singleNumber1.singleNumber2(nums));
    }

    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }

    public int singleNumber2(int[] nums) {
        int[] result = new int[32];
        int sum = 0;
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                result[j] += ((num & (1 << j)) >> (j)) & 0x01;
            }
            System.out.println(Arrays.toString(result));
        }

        System.out.println(Arrays.toString(result));
        for (int i = 0; i < 32; i++) {
            result[i] %= 3;
            if (result[i] == 1) {
                sum += (1 << i);
            }
        }
        return sum;
    }
}
