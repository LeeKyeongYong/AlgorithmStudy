package com.algorithm2024.letcode4;

public class Example20240705_q2181 {
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

    public ListNode mergeNodes(ListNode head) {
        ListNode next = head.next;
        ListNode nextSum = next;

        while (nextSum != null) {
            int sum = 0;

            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            next.val = sum;
            nextSum = nextSum.next;

            next.next = nextSum;
            next = next.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
    }
}
