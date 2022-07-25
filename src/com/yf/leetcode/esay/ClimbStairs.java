package com.yf.leetcode.esay;

/**
 * @author yanfei
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs1(int n) {
        int pre = 1;
        int cur = 1;
        int next = 1;
        for (int i = 2; i <= n; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(4));
    }
}
