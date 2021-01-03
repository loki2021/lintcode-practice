package com.yf.lintcode.binarytree;

import com.yf.lintcode.TreeNode;
import com.yf.lintcode.TreeUtils;

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
