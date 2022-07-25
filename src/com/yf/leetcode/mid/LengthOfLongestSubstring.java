package com.yf.leetcode.mid;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yanfei
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();
        char[] array = s.toCharArray();
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i] + "")) {
                if (len < set.size()) {
                    len = set.size();
                }
                set.clear();
            }
            set.add(array[i] + "");
        }
        if (set.size() > len) {
            len = set.size();
        }
        return len;
    }

    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int len = 0;
        int last = 0;
        for (int i = 0; i < array.length; i++) {
            Integer index = map.get(array[i]);
            if (index != null) {
                last = index + 1;
            }
            if ((i - last + 1) > len) {
                len = i - last + 1;
            }
            map.put(array[i], i);
        }
        if (array.length - last > len) {
            len = array.length - last;
        }
        return len;
    }

    // 正确的
    public static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int len = 0;
        int last = 0;
        for (int i = 0; i < array.length; i++) {
            Integer index = map.get(array[i]);
            if (index != null && index >= last) {
                last = index + 1;
            }
            if ((i - last + 1) > len) {
                len = i - last + 1;
            }
            map.put(array[i], i);
        }
        if (array.length - last > len) {
            len = array.length - last;
        }
        return len;
    }

    // 第一次没有考虑set从中间开始没有再被清零的时候
    // 第二次没有考虑清零的时候前面的前缀可能还是可以用的
    // 然后就是长度的问题，还有就是字符串开始时的记录变换
    public static void main(String[] args) {
        int len = lengthOfLongestSubstring2("dvdf");
        System.out.println(len);
    }
}
