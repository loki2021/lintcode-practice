package com.yf.lintcode;

public class TreeUtils {
    public static void traverseTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public static void buildTree(TreeNode root){
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
    }
}
