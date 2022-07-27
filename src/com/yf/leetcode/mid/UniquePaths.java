package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // d[i]现在的值就是之前的dp[j-1]
        // 那么dp[i][j] = dp[i-1] + dp[i];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i] += dp[i - 1];
            }

        }
        return dp[n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        int cnt = m - 1;
        long total = (long) m + n - 2;
        long numerator = 1L;
        long denominator = (long) m-1;
        while (cnt-- > 0) {
            numerator *= total--;
            while (denominator !=0 && numerator % denominator == 0) {
                numerator /= denominator;
                denominator--;
            }
        }
        return (int) numerator;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(20, 20));
    }
}
