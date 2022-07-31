package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class Rob {
    public static int rob(int[] nums) {
        int len = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        return sum1 > sum2 ? sum1 : sum2;
    }

    public static int rob1(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            for (int j = i; j > 1; j--) {
                dp[i] = Math.max(dp[i], dp[i - j] + nums[i]);
            }
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    public static int rob2(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob1(nums));
    }
}
