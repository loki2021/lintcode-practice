package com.yf.lintcode.binarytree;

import com.yf.lintcode.TreeNode;
import com.yf.lintcode.TreeUtils;

public class MaxDepth104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeUtils.buildTree(root);

        int res = maxDepth(root);
        System.out.println("--depth-"+res);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
