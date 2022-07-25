package com.yf.leetcode.mid;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, -3};
        System.out.println(threeSum(nums, 1));
    }

    public static int threeSum(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (res == Integer.MAX_VALUE) {
                    res = sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if(target < sum){
                    while (j < k && nums[k] == nums[--k]) {
                    }
                }else if(target > sum){
                    while (j < k && nums[j] == nums[++j]) {
                    }
                }else {
                    return target;
                }
            }
        }
        return res;
    }
}
