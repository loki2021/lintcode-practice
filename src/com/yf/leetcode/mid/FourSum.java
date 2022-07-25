package com.yf.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(fourSum(nums, -1));
    }

    // 错误版本
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] > target) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int g = j + 1;
                int k = nums.length - 1;
                while (g < k) {
                    int sum = nums[i] + nums[j] + nums[g] + nums[k];
                    if (sum < target) {
                        while (g < k && nums[g] == nums[++g]) {
                        }
                        ;
                    } else if (sum > target) {
                        while (g < k && nums[k] == nums[--k]) {
                        }
                        ;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[g], nums[k]));
                        while (g < k && nums[g] == nums[++g]) {
                        }
                        while (g < k && nums[k] == nums[--k]) {
                        }
                    }
                }

            }
        }
        return res;
    }

    // 相比于错的版本就是不要随便检测特殊情况，三数之和为0的时候是一种特殊情况，首元素如果大于0 那么一定不会有结果
    // 但是对于变量目标有可能出现负数的情况，当负数出现的时候会出现和越来越小的情况
    public static List<List<Integer>> fourSum0(int [] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int g = j + 1;
                int k = nums.length - 1;
                while (g < k) {
                    int sum = nums[i] + nums[j] + nums[g] + nums[k];
                    if (sum < target) {
                        while (g < k && nums[g] == nums[++g]) {
                        }
                        ;
                    } else if (sum > target) {
                        while (g < k && nums[k] == nums[--k]) {
                        }
                        ;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[g], nums[k]));
                        while (g < k && nums[g] == nums[++g]) {
                        }
                        while (g < k && nums[k] == nums[--k]) {
                        }
                    }
                }

            }
        }
        return res;
    }
}
