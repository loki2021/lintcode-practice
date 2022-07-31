package com.yf.leetcode.mid;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.yf.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanfei
 */
public class Rob3 {
    public static int rob(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list);
        if (list.isEmpty()) {
            return 0;
        }
        int len = list.size();
        if (len == 1) {
            return list.get(0);
        }
        int[] dp = new int[len];
        dp[0] = list.get(0);
        dp[1] = Math.max(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + list.get(i));
        }
        return dp[len - 1];
    }

    public static void traverse(TreeNode root, ArrayList<Integer> nums) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        int size = queue.size();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            size--;
            if (curNode != null) {
                sum += curNode.val;
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            if (size == 0) {
                size = queue.size();
                nums.add(sum);
                sum = 0;
            }
        }
    }

    public static int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static int rob1(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(rob1(root));
    }
}
