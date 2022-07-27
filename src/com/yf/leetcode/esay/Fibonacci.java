package com.yf.leetcode.esay;

/**
 * @author yanfei
 */
public class Fibonacci {
    public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        int pre = 0;
        int cur = 1;
        // 因为n= 1已经计算了
        while (--n > 0) {
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
    public static void main(String[] args){
        System.out.println(fib(6));
    }
}
