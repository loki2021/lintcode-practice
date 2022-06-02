package com.yf.leetcode.binarytree;

import com.yf.leetcode.TreeNode;
import com.yf.leetcode.TreeUtils;

public class FlattenTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeUtils.buildTree(root);
        flatten(root);
        TreeUtils.traverseTree(root);
    }

    public static TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = flatten(left);
        TreeNode tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = flatten(right);
        return root;
    }
}
