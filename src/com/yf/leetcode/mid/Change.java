package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class Change {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        int len = coins.length;
        dp[0] = 1;
        // 0相当于刚好凑够也就是凑j的时候某个coins刚好等于j的情况
        for (int i = 0; i < len; i++) {
            // 因为从头开始遍历，所以可以重复放置
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(5, coins));
    }

}
