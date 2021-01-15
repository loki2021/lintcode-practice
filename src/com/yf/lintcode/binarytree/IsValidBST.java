package com.yf.lintcode.binarytree;

import com.yf.lintcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;

public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> res = new ArrayList<>();
        boolean flag = treverse(root, res);
        if (!flag) {
            return false;
        }
        int[] tmp = new int[res.size()];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            int v = res.get(i);
            tmp[i] = v;
            set.add(v);
        }
        quickSort(tmp, 0, tmp.length - 1);

        if (tmp.length != res.size() || set.size() != res.size()) {
            return false;
        }

        for (int i = 0; i < res.size(); i++) {
            int temp = tmp[i];
            if (temp != res.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean treverse(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        treverse(left, res);
        res.add(root.val);
        treverse(right, res);
        return true;
    }

    public static void quickSort(int[] input, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partion(input, lo, hi);
        quickSort(input, lo, j - 1);
        quickSort(input, j + 1, hi);
    }

    public static int partion(int[] input, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = input[lo];
        while (true) {
            while (v > input[++i]) {
                if (i == hi) {
                    break;
                }
            }
            while (v < input[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(input, i, j);
        }
        swap(input, lo, j);
        return j;
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
