package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class FindTargetSunWays {
    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums[i]);
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        // j-num[i]=0就算一种方法
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            //dp[j - nums[i]]代表加上nums[i]的方法，
            // dp[j]原来的值代表不加nums[i]的方法
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }

}
