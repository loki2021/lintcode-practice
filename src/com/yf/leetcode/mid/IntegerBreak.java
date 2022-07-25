package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int tmp = dp[j] * (i - j);
                if (tmp > dp[i]) {
                    dp[i] = tmp;
                }
            }
        }
        return dp[n];
    }

    public static int integerBreak1(int n) {

        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak1(10));
    }
}
