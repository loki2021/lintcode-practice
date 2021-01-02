package com.yf.lintcode.binarytree;

import com.yf.lintcode.TreeNode;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        //traverseTree(root);
        invertTree(root);
        traverseTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void traverseTree(TreeNode root){
        if(root == null){
            return;
        }
        traverseTree(root.left);
        System.out.println(root.val);
        traverseTree(root.right);
    }
}
