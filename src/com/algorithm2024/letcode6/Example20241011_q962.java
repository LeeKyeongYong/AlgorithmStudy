package com.algorithm2024.letcode6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20241011_q962 {
    class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(final int index, final int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(final Node o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

    public int maxWidthRamp(int[] nums) {
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new Node(i, nums[i]));
        }

        Collections.sort(list);

        int answer = 0;
        int minIndex = Integer.MAX_VALUE;

        for (Node node : list) {
            int index = node.index;
            minIndex = Math.min(minIndex, index);
            answer = Math.max(answer, index - minIndex);
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20241011_q962 sol = new Example20241011_q962();

        // 4
        System.out.println(sol.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
    }
}
