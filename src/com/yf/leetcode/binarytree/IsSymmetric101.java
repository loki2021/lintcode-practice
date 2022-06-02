package com.yf.leetcode.binarytree;

import com.yf.leetcode.TreeNode;

/*
 * 对称二叉树
 * */
public class IsSymmetric101 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
/*        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right.left= new TreeNode(7);
        root.left.right.right= new TreeNode(8);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);*/
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helpSymmetric(root.left, root.right);
    }

    public static boolean helpSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return helpSymmetric(left.right, right.left) & helpSymmetric(left.left, right.right);
    }
}
