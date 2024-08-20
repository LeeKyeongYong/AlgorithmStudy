package com.algorithm2024.letcode5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Example20240820_q650 {

    static class Node {
        int value;
        int length;
        int clipboard;

        public Node(int value, int length, int clipboard) {
            this.value = value;
            this.length = length;
            this.clipboard = clipboard;
        }
    }

    public int minSteps(int n) {
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Node(0, 1, 0));
        visited.add("1-0");

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.length == n) {
                return now.value;
            }

            // 복사
            if (now.length > 0 && now.length <= n) {
                String state = now.length + "-" + now.length;

                if (!visited.contains(state)) {
                    visited.add(state);
                    q.add(new Node(now.value + 1, now.length, now.length));
                }
            }

            // 붙여넣기
            if (now.clipboard > 0 && now.length + now.clipboard <= n) {
                String state = (now.length + now.clipboard) + "-" + now.clipboard;
                if (!visited.contains(state)) {
                    visited.add(state);
                    q.add(new Node(now.value + 1, now.length + now.clipboard, now.clipboard));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Example20240820_q650 sol = new Example20240820_q650();
        System.out.println(sol.minSteps(3));
        System.out.println(sol.minSteps(1));
    }

}
