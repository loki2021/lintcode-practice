package com.yf.leetcode.binarytree;

import com.yf.leetcode.TreeNode;

/**
 * @author yanfei
 */
public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if(p != null && q == null){
            return false;
        }
        if (p == null && q != null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}
