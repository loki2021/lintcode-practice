package com.yf.leetcode.mid;

public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    // 超时了
    public static int maxArea0(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int curArea = (j - i) * Math.min(height[i], height[j]);
                if (maxArea < curArea) {
                    maxArea = curArea;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(curArea, maxArea);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    // 双指针，宽从最大开始，如果减少宽度，那么移动高度大的一端，面积一定比上一步减少，
    // 因为矮的一端是实际高度，而高度不变的情况下，减少宽度面积必定减少
    // 如果移动高度小的一端那么面积有可能增大
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = height[i] >height[j]?
                    Math.max((j - i) * height[j--], maxArea):
                    Math.max((j - i) * height[i++], maxArea);
        }
        return maxArea;
    }
}

