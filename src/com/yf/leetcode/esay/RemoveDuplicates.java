package com.yf.leetcode.esay;

import java.util.concurrent.ConcurrentHashMap;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = lo;
        while (hi < nums.length - 1) {
            if (nums[lo] != nums[++hi]) {
                nums[++lo] = nums[hi];
            }
        }
        return ++lo;
    }
}
