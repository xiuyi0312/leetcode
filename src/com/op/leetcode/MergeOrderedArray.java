package com.op.leetcode;

import java.util.Arrays;

public class MergeOrderedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {};
        MergeOrderedArray mergeOrderedArray = new MergeOrderedArray();
        mergeOrderedArray.merge(a, 3, b, 0);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, p3 = 0;
        int[] c = new int[m + n];
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                c[p3++] = nums1[p1++];
            } else {
                c[p3++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            c[p3++] = nums1[p1++];
        }
        while (p2 < n) {
            c[p3++] = nums2[p2++];
        }
        if (m + n >= 0) {
            System.arraycopy(c, 0, nums1, 0, m + n);
        }
    }
}
