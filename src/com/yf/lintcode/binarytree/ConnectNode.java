package com.yf.lintcode.binarytree;

import com.yf.lintcode.Node;

import java.util.Queue;
import java.util.Stack;

public class ConnectNode {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);

    }

    public static Node connect(Node root) {

        Stack<Node> s = new Stack<>();
        Stack<Node> tmp = new Stack<>();
        s.add(root);
        while (!s.empty()) {
            Node pre = null;
            while (!s.empty()){
                Node node = s.pop();
                if(pre!= null && pre.right!= null){
                    pre.right.next = node.left;// 忘记加next 忘记判断null
                }
                if(node.left!=null){
                    node.left.next = node.right;
                }
                pre = node;
                if(node.left != null){
                    tmp.push(node.left);
                }
                if(node.right != null){
                    tmp.push(node.right);
                }

            }
            // 第一遍忘记！
            while (!tmp.empty()){
                s.push(tmp.pop());
            }
        }
        return root;
    }
}
