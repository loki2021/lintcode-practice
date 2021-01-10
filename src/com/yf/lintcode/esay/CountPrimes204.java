package com.yf.lintcode.esay;

import java.util.ArrayList;
import java.util.Scanner;

public class CountPrimes204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--请输入一个整数--");
        while (sc.hasNext()) {
            int input = sc.nextInt();
            int res = countPrimes0(input);
            System.out.println("--res--: " + res + '\n');
            System.out.println("--请输入一个整数--");
        }
    }

    // 计算超时
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag)
                cnt++;
        }
        return cnt;
    }


    // 计算超时
    public static int countPrimes0(int n) {
        if (n <= 2) {
            return 0;
        }
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3;  i < n; i++) {
            boolean flag = true;
            for (Integer j : primes) {
                if(j* j > i){
                   break;
                }
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                primes.add(i);
        }
        return primes.size();
    }

    public static int countPrimes1(int n) {
        if (n <= 2) {
            return 0;
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                cnt++;
        }
        return cnt;
    }

}
