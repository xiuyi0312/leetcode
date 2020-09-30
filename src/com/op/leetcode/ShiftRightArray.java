package com.op.leetcode;

public class ShiftRightArray {
    public static void main(String[] args) {
        ShiftRightArray shiftRightArray = new ShiftRightArray();
        int[] nums = {
                1, 2, 3, 4, 5, 6, 7
        };
        shiftRightArray.rotate(nums, 2);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(shiftRightArray.reverseBits(0b11111111111111111111111111111101));//00000010100101000001111010011100));
        System.out.println(shiftRightArray.hammingWeight(0b00000000000000000000000000001011));
        System.out.println(shiftRightArray.hammingWeight(0b00000000000000000000000000001011));
        System.out.println(shiftRightArray.hammingWeight(0b00000000000000000000000010000000));
        System.out.println(shiftRightArray.hammingWeight(0b11111111111111111111111111111101));
    }

    public int reverseBits(int n) {
        boolean leftZero = (n & 0x80000000) == 0;
        boolean rightZero = (n & 0x01) == 0;
        n = n & 0x7ffffffe;
        String s = Integer.toBinaryString(n);
        //00000010100101000001111010011100
        //      10100101000001111010011100
        int extraZeroCount = 32 - s.length();
        for (int i = 0; i < extraZeroCount; i++) {
            s = '0' + s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }
        int m = Integer.parseInt(sb.toString(), 2);
        if(!leftZero) {
            m = m | 0x00000001;
        }
        if(!rightZero) {
            m = m | 0x80000000;
        }
        return m;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = n >= 0 ? 0 : 1;
        if (count == 1) {
            n &= 0x7fffffff;
        }
        while (n > 0) {
            if ((n & 0x00000001) > 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        for (int i = 0; i < (nums.length - k) / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - k - 1 - i];
            nums[nums.length - k - 1 - i] = t;
        }

        for (int i = 0; i < k / 2; i++) {
            int t = nums[i + nums.length - k];
            nums[i + nums.length - k] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }
    }
}
