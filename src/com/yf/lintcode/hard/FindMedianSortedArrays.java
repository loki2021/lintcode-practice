package com.yf.lintcode.hard;

/**
 * @author yanfei
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] res = new int[n];
        merge(nums1, nums2, res);
        if (n % 2 == 0) {
            return (res[n / 2] + res[n / 2 - 1]) / 2.0;
        }
        return res[n / 2];

    }

    public static void merge(int[] nums1, int[] nums2, int[] res) {
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < nums1.length && n - 1 < res.length / 2) {
            while (j < nums2.length && nums1[i] > nums2[j]) {
                res[n++] = nums2[j++];
            }
            res[n++] = nums1[i++];
        }
        while (i < nums1.length && n - 1 < res.length / 2) {
            res[n++] = nums1[i++];
        }
        while (j < nums2.length && n - 1 < res.length / 2) {
            res[n++] = nums2[j++];
        }
    }

}
