package com.op.leetcode;

public class ListPartition {
    public static void main(String[] args) {
        ListPartition listPartition = new ListPartition();
        ListNode p = new ListNode(1);
        ListNode first = p;
        ListNode q = new ListNode(4);
        p.next = q;
        p = q;
        q = new ListNode(3);
        p.next = q;
        p = q;
        q = new ListNode(2);
        p.next = q;
        p = q;
        q = new ListNode(5);
        p.next = q;
        p = q;
        q = new ListNode(2);
        p.next = q;
        p = q;

        ListNode f = listPartition.partition(first, 0);
        p = f;
        while (p != null) {
            System.out.println(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode firstPart = null, fp = null;
        ListNode secondPart = null, sp = null;
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            if (p.val < x) {
                if (firstPart == null) {
                    fp = firstPart = p;
                    firstPart.next = null;
                } else {
                    fp.next = p;
                    fp = p;
                    fp.next = null;
                }
            } else {
                if (secondPart == null) {
                    sp = secondPart = p;
                    secondPart.next = null;
                } else {
                    sp.next = p;
                    sp = p;
                    sp.next = null;
                }
            }
            p = q;
        }
        if (fp != null) {
            fp.next = secondPart;
        } else {
            return secondPart;
        }
        return firstPart;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
