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
        if (target > sum || (sum + target) % 2 != 0) {
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

    public static int findTargetSumWays2(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        if (t > s || (s - t) % 2 != 0) {
            return 0;
        }
        int m = (s - t) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) {
                    f[i][j] += f[i - 1][j - x];
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        System.out.println(findTargetSumWays2(nums, -200));
    }

}
