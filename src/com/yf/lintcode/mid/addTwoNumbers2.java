package com.yf.lintcode.mid;

import com.yf.lintcode.ListNode;

public class addTwoNumbers2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        add(l1, l2, res);
        return res.next;
    }

    public static void add(ListNode l1, ListNode l2, ListNode res) {
        if (l1 == null && l2 == null)
            return;
        if (l1 == null) {
            int n2 = l2.val;
            if (n2 >= 10) {
                res.next = new ListNode(n2 % 10);
                if (l2.next==null){
                    res.next.next = new ListNode(1);
                    return;
                }
                l2.next.val += 1;
                add(l1, l2.next, res.next);
                return;
            }
            res.next = l2;
            return;
        }
        if (l2 == null) {
            int n1 = l1.val;
            if (n1 >= 10) {
                res.next = new ListNode(n1 % 10);
                if (l1.next==null){
                    res.next.next = new ListNode(1);
                    return;
                }
                l1.next.val += 1;
                add(l1.next, l2, res.next);
                return;
            }
            res.next = l1;
            return;
        }
        int tmp = l1.val + l2.val;
        if (tmp < 10) {
            res.next = new ListNode((l1.val + l2.val));
            add(l1.next, l2.next, res.next);
            return;
        }
        res.next = new ListNode((l1.val + l2.val) % 10);
        if (l1.next == null && l2.next == null) {
            res.next.next = new ListNode(1);
            return;
        }
        if (l1.next != null) {
            l1.next.val += 1;
        } else {
            l2.next.val += 1;
        }
        add(l1.next, l2.next, res.next);
        return;
    }

}
