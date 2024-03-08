package com.algorithm2024.letcode;

public class Example20240308_q876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        // 2씩 이동
        ListNode origin = head;

        // 1씩 이동
        ListNode half = head;

        while (origin != null) {
            origin = origin.next;

            if (origin != null) {
                origin = origin.next;
                half = half.next;
            }
        }

        return half;
    }
}
