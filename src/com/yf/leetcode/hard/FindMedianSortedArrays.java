package com.yf.leetcode.hard;

public class FindMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums2 = new int[]{2, 2, 4, 4};
        int[] nums1 = new int[]{2, 2, 4, 4};
        findMedianSortedArrays(nums1, nums2);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int mid = (m + n) / 2;
        int[] sortArray = new int[m + n];
        // 这里必须算上k，
        while (k <= mid && i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sortArray[k++] = nums1[i++];
            } else {
                sortArray[k++] = nums2[j++];
            }
        }
        // k等于mid之后还要继续添加是因为偶数时要取到mid和mid+1
        while (k <= mid && i != m) {
            sortArray[k++] = nums1[i++];
        }
        while (k <= mid && j != n) {
            sortArray[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 0) {
            // 因为k++这个运算，所以k一定会多+1
            return (sortArray[k - 1] + sortArray[k - 2]) / 2.0D;
        } else {
            return sortArray[k - 1];
        }
    }


    public static double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int mid = (m + n) / 2;
        int[] sortArray = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sortArray[k++] = nums1[i++];
            } else {
                sortArray[k++] = nums2[j++];
            }
        }
        // k等于mid之后还要继续添加是因为偶数时要取到mid和mid+1
        while (k <= mid && i != m) {
            sortArray[k++] = nums1[i++];
        }
        while (k <= mid && j != n) {
            sortArray[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 0) {
            // 因为k++这个运算，所以k一定会多+1
            return (sortArray[mid] + sortArray[mid - 1]) / 2.0D;
        } else {
            return sortArray[mid];
        }
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] res = new int[n];
        merge(nums1, nums2, res);
        if (n % 2 == 0) {
            return (res[n / 2] + res[n / 2 - 1]) / 2.0;
        } else {
            return res[n / 2];
        }

    }

    public static void merge(int[] nums1, int[] nums2, int[] res) {
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < nums1.length && n < res.length) {
            while (j < nums2.length && nums1[i] > nums2[j]) {
                res[n++] = nums2[j++];
            }
            res[n++] = nums1[i++];
        }
        if (res.length == n) {
            return;
        }
        while (i < nums1.length) {
            res[n++] = nums1[i++];
        }

        while (j < nums2.length) {
            res[n++] = nums2[j++];
        }
        return;
    }
}
