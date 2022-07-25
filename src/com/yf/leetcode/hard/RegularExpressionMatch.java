package com.yf.leetcode.hard;

public class RegularExpressionMatch {

    public static boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        char pre = p.charAt(0);
        int j = 0;
        int i = 0;
        for (; i < p.length() && j < s.length(); i++) {
            switch (p.charAt(i)) {
                case '.':
                    if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                        return true;
                    }
                    j++;
                    break;
                case '*':
                    if (pre == '*' || s.charAt(j) != pre) {
                        continue;
                    }
                    while (j < s.length() && s.charAt(j++) == pre) {
                    }
                    break;
                default:
                    pre = p.charAt(i);
                    if (p.charAt(i) == s.charAt(j)) {
                        j++;
                    }
            }

        }
        if (i != p.length() || j != s.length()) {
            return false;
        }
        return true;
    }

    public static boolean isMatch1(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        int pLength = p.length();
        int[] arr = new int[pLength];
        char pre = p.charAt(0);
        int j = 0;
        int i = 0;
        for (; i < pLength; i++) {
            boolean equal = false;
            switch (p.charAt(i)) {
                case '.':
                    if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                        while (i < pLength - 1 && p.charAt(i + 1) == '*') {
                            arr[i] = arr[i - 1] + 1;
                            i++;

                        }
                    }
                    equal = true;
                    break;
                case '*':
                    if (pre == '*' || s.charAt(j) != pre) {
                        continue;
                    }
                    arr[i] = arr[i - 1];
                    while (j < s.length() && s.charAt(j) == pre) {
                        arr[i]++;
                        j++;
                    }
                    break;
                default:
                    pre = p.charAt(i);
                    if (j < s.length() && p.charAt(i) == s.charAt(j)) {
                        equal = true;
                        j++;
                    } else {
                        if (i != 0 && arr[i - 1] != 0) {
                            return false;
                        }
                    }
            }
            if (equal) {
                if (i == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = arr[i - 1] + 1;
                }
            }
            if (arr[i] == s.length()) {
                return true;
            }
        }
        if (arr[pLength - 1] != s.length()) {
            return false;
        }
        return true;
    }

    /**
     * 用二维数组记录s第i个字符和p第j个字符是否相等
     */
    public static boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        String ss = " " + s;
        String pp = " " + p;
        char[] sArr = ss.toCharArray();
        char[] pArr = pp.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - 1 && pArr[j + 1] == '*') {
                    continue;
                }
                if ((i - 1 >= 0) && (sArr[i] == pArr[j] || pArr[j] == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pArr[j] == '*') {
                    if (pArr[j - 1] != sArr[i] && pArr[j - 1] != '.') {
                        dp[i][j] = j >= 2 && dp[i][j - 2];
                    } else {
                        dp[i][j] = (i >= 1 && dp[i - 1][j]) && (sArr[i] == pArr[j - 1] || pArr[j - 1] == '.');
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();
        String ss = " " + s;
        String pp = " " + p;
        char[] sArr = ss.toCharArray();
        char[] pArr = pp.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - 1 && pArr[j + 1] == '*') {
                    continue;
                }
                if ((i - 1 >= 0) && (sArr[i] == pArr[j] || pArr[j] == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pArr[j] == '*') {
                    dp[i][j] = (j >= 2 && dp[i][j - 2]) || (i >= 1 && dp[i - 1][j]) && (sArr[i] == pArr[j - 1] || pArr[j - 1] == '.');
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch3("ab", ".*"));
    }
}
