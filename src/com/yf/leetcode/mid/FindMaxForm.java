package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            String cur = strs[i];
            char[] curArray = cur.toCharArray();
            int zeroNums = 0;
            int oneNums = 0;
            for (char c : curArray) {
                if (c == '0') {
                    zeroNums++;
                } else {
                    oneNums++;
                }
            }
            // 为了防止覆盖，所以从后向前，如果是3维的dp数组的话就可以从前向后了
            for (int j = m; j >= zeroNums; j--) {
                for (int k = n; k >= oneNums; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNums][k - oneNums] + 1);
                }
            }

        }
        return dp[m][n];
    }
}
