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
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }
}
