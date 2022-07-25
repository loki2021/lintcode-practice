package com.yf.leetcode;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class TestBinSearch {

    public static int binSearch(int[] A, int target, int lo, int hi) {
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (A[mi] > target) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return (A[lo] == target) ? lo : -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("今天周几");
        String day = input.next();
        switch (day) {
            case "星期一":
                System.out.println("天气如何");
                String weather = input.next();
                if (weather == "天气好") {
                    System.out.println("玩");
                } else {
                    System.out.println("看书");
                }
                break;
            default:
                System.out.println("err");
        }
    }
}
