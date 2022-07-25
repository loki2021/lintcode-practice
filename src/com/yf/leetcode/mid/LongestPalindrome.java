package com.yf.leetcode.mid;

/**
 * @author yanfei
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aaaa"));
    }

    /**
     * 错误
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        int[][] mtri = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || j == 0) {
                    mtri[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    mtri[i][j] = mtri[i - 1][j - 1] + 1;
                }
                if (mtri[i][j] > maxLen) {
                    maxLen = mtri[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 利用二维数组记录上次判断的结果
     * 每次内循环都会判断一次原字符串i位置的字符是否相等
     * 如果相等则根据记录设置该字符的记录值
     */
    public static String longestPalindrome0(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] mtri = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        mtri[i][j] = 1;
                    } else {
                        mtri[i][j] = mtri[i - 1][j - 1] + 1;
                    }
                    if (mtri[i][j] > maxLen) {
                        // j是反转的字符串的末尾
                        int beforeRev = length - 1 - j;
                        if (beforeRev + mtri[i][j] - 1 == i) {
                            maxLen = mtri[i][j];
                            maxEnd = i;
                        }
                    }
                }

            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 对上面的方法进行优化
     * 因为每次都会当前i位置的字符是否和反转后所有的字符相等
     * 但是每次i增加1之后，只需要判断前面一次遍历的结果
     * 所以只需要一个一维数组来记录就可以了
     * 但是更新的时候需要用到j-1的值，所以j需要从下标大的一边开始遍历
     * 另外，因为只用一个数组记录，所以需要每次重置原来的记录，如果相等就是更新
     * 如果不相等就是置0
     */
    public static String longestPalindrome1(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] rec = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        rec[j] = 1;
                    } else {
                        rec[j] = rec[j - 1] + 1;
                    }
                    if (rec[j] > maxLen) {
                        // j是反转的字符串的末尾
                        int beforeRev = length - 1 - j;
                        if (beforeRev + rec[j] - 1 == i) {
                            maxLen = rec[j];
                            maxEnd = i;
                        }
                    }
                } else {
                    rec[j] = 0;
                }

            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static String longestPalindrome2(String s) {
        int len = s.length();
        char[] strArr = s.toCharArray();
        int maxlen = 1;
        int begin = 0;
        boolean dp[][] = new boolean[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (strArr[i] == strArr[j]) {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if (dp[i][j] && i - j + 1 > maxlen) {
                    maxlen = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

}
