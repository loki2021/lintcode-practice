package com.yf.leetcode.esay;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return max;
    }

    public static int maxProfitDp(int[] prices) {
        int len = prices.length;
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
