package com.yf.leetcode.mid;

import com.yf.leetcode.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode cur = null;
        int adv = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + adv;
            adv = sum / 10;
            if (cur == null) {
                res = new ListNode(sum % 10);
                cur = res;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + adv;
            adv = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + adv;
            adv = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if (adv != 0) {
            cur.next = new ListNode(adv);
        }
        return res;
    }

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
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
