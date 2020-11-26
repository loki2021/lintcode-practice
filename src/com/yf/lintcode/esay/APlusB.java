/**
 * Copyright (c) 2019 playcrab.All rights reserved.
 */

package com.yf.lintcode.esay;

/**
 * 
 *
 * @date 2019-07-13
 * @author
 */
public class APlusB {

    public static void main(String[] args) {

        int a = 3;
        int b = 2;
        b = ~b + 1;
        int res = aplusb(a, b);

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
