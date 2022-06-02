package com.yf.leetcode.esay;

import java.util.*;

public class HappyNum202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---请输入整数---");
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (isHappy(n))
                System.out.println("---true----");
            else
                System.out.println("-----false---");

            System.out.println("-----请输入下一个整数----");
        }

    }

    public static boolean isHappy(int n) {
        ArrayList<Integer> history = new ArrayList<>();
        while (n != 1) {
            ArrayList<Integer> list = new ArrayList<>();
            while (n != 0) {
                list.add(n % 10);
                n = n / 10;
            }
            n = add(list);
            // 如果无限循环那么必将是计算过的
            if (history.contains(n)) {
                return false;
            }
            history.add(n);
        }
        if (n == 1)
            return true;
        return false;
    }

    public static int add(List<Integer> parm) {
        int sum = 0;
        for (Integer n : parm) {
            sum += n * n;
        }
        return sum;
    }

    // 换成set也没有变快
    public static boolean isHappy0(int n) {
        HashSet<Integer> history = new HashSet<>();
        while (n != 1) {
            ArrayList<Integer> list = new ArrayList<>();
            int tmp = n;
            while (n != 0) {
                list.add(n % 10);
                n = n / 10;
            }
            n = add(list);
            // 如果无限循环那么必将是计算过的
            if (history.contains(n)) {
                return false;
            }
            history.add(n);
        }
        if (n == 1)
            return true;
        return false;
    }
}
