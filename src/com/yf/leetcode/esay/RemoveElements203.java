package com.yf.leetcode.esay;

import com.yf.leetcode.ListNode;

public class RemoveElements203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }

}
