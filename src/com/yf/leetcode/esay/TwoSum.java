package com.yf.leetcode.esay;

public class TwoSum {

    public static void main(String args) {

    }

    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];



        return res;
    }








    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

}
