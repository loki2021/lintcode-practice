package com.yf.lintcode.binarytree;

import com.yf.lintcode.TreeNode;
import com.yf.lintcode.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeUtils.buildTree(root);
        List<Integer> res = inOrderTraversal(root);

        for (Integer i : res) {
            System.out.println("---" + i);
        }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public static void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }
}
