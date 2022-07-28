package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class NumSquares {
    public static int numSquares(int n) {
        int[] nums = new int[10001];
        int i = 1;
        for (; i <= n; i++) {
            int tmp = i * i;
            if (tmp > n) {
                break;
            }
            nums[i] = tmp;
        }
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        // 因为每个值都可以用平方和表示，并且是从前向后遍历的，
        // 所以前面的每个值都不会是初始的最大值
        for (int j = 1; j < i; j++) {
            for (int k = nums[j]; k <= n; k++) {
                dp[k] = Math.min(dp[k], dp[k - nums[j]] + 1);
            }
        }
        return dp[n];
    }

    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        // 因为每个值都可以用平方和表示，并且是从前向后遍历的，
        // 所以前面的每个值都不会是初始的最大值
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
