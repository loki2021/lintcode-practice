package com.yf.leetcode.mid;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        HashSet<Integer> singleSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        int sizeBefore = singleSet.size();
                        singleSet.addAll(tmp);
                        if (sizeBefore == singleSet.size()) {
                            continue;
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum0(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        HashSet<String> singleSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        if (singleSet.contains(tmp.toString())) {
                            continue;
                        }
                        singleSet.add(tmp.toString());
                        res.add(tmp);
                    }
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (nums[i] + nums[j] + nums[k] != 0) {
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            if (j != k) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                tmp.add(nums[k]);
                res.add(tmp);
            }

        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) {
                    }
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) {
                    }
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[++j]) {
                    }
                    while (j < k && nums[k] == nums[--k]) {
                    }
                }
            }

        }
        return res;
    }

}
