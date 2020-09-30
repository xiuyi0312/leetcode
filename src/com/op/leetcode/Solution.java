package com.op.leetcode;

class Solution {


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public int trailingZeroes(int n) {
        int count5 = 0;
        while (n > 0) {
            count5 += n / 5;
            n /= 5;
        }
        return count5;
    }

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String[] strs = s.split("\\s+");
        if (strs.length <= 0) {
            return 0;
        }
        return strs[strs.length - 1].length();
    }

    public int reverse(int x) {
        String a = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        if (a.startsWith("-")) {
            stringBuilder.append("-");
            a = a.substring(1);
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            stringBuilder.append(a.charAt(i));
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public void rotate(int[][] matrix) {
        // TODO: 2020/7/26
        // step1 : obviously you can imagine a horizontal line in the middle of the matrix
        for(int i = 0; i< matrix.length/2;i++) {
            for(int j = 0; j< matrix[0].length;j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i -1][j];
                matrix[matrix.length - i -1][j] = t;
            }
        }
        // step2 : imagine a diagonal line from left-top to right-bottom, swap the elements from each side;
        for (int i = 0; i< matrix.length;i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public int divide(int dividend, int divisor) {
        // fixme: 2020/7/26
        int count = 0;
        int temp = 0;
        boolean positive = divisor > 0;
        boolean positive2 = dividend > 0;
        if (!positive) {
            divisor = -divisor;
        }
        if (!positive2) {
            dividend = -dividend;
        }
        System.out.println("d1 = " + dividend + " d2 = " + divisor);
        while (temp < dividend) {
            count++;
            temp += divisor;
        }
        if (temp > dividend) {
            count--;
        }
        return positive && positive2 ? count : -count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        int[] num = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(s.twoSum(num, 18)));



//        System.out.println(s.trailingZeroes(2));



//        System.out.println(s.lengthOfLastWord("hello word"));



//        System.out.println(s.reverse(-283848939));



//        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));



//        int[][] a = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//        };
//        s.rotate(a);



        // FIXME: 2020/9/29 not yet
//        System.out.println(s.divide(-2147483648, -1));
    }


}
