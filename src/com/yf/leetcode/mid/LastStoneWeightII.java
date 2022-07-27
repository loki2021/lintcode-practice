package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class LastStoneWeightII {
    public static int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            // 如果去掉=号可能会出现，j容量的时候为空，因为可能只有一个物品能放进j容量的背包
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }
}
