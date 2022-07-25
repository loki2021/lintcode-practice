package com.yf.leetcode.esay;

/**
 * @author yanfei
 */
public class minCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int curCost = cost[i];
            dp[i] = dp[i - 1] > dp[i - 2] ? dp[i - 2] + curCost : dp[i - 1] + curCost;
        }
        return dp[len - 1] > dp[len - 2] ? dp[len - 2] : dp[len - 1];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
