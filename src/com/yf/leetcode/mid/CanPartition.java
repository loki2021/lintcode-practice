package com.yf.leetcode.mid;

public class CanPartition {

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public static boolean canPartition1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
