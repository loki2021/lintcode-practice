package com.yf.lintcode.esay;

/**
 * @date 2021-01-01
 * @author yanfei
 */
public class APlusB {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int res = aplusb(a, b);
        int i = 16000000;
        long j = i * 16000000L;
        System.out.println(j);
        System.out.println(res);

    }

    private static int aplusb(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        int x = a ^ b;
        int y = (a & b) << 1;
        return aplusb(x, y);
    }

}
