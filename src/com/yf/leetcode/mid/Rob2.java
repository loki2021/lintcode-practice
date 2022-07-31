package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class Rob2 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int head = robRange(nums, 0, len - 2);
        int end = robRange(nums, 1, len - 1);
        return head > end ? head : end;
    }

    public static int robRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], nums[start]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
