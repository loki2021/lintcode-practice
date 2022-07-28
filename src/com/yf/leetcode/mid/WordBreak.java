package com.yf.leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanfei
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int wLen = wordDict.size();
        for (int j = 1; j <= len; j++) {
            for (int i = 0; i < wLen; i++) {
                int curlen = wordDict.get(i).length();
                if (j < curlen || dp[j] == true) {
                    continue;
                }
                dp[j] = dp[j - curlen] && s.substring(j - curlen, j).equals(wordDict.get(i));
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
    }
}
