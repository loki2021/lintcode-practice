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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }
}
