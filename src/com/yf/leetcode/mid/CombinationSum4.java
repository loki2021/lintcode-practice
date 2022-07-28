package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < len; i++) {
                if(j>=nums[i]){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }
}
