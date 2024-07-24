package com.algorithm2024.letcode4;

import java.util.*;

public class Example20240725_q2191 {

    static class Node implements Comparable<Node> { //숫자 매핑 문제 : Map + 정렬 + 구현

        public int originNumber;
        public int mappingNumber;

        public Node(final String originNumber, final String mappingNumber) {
            this.originNumber = Integer.parseInt(originNumber);
            this.mappingNumber = Integer.parseInt(mappingNumber);
        }

        @Override
        public int compareTo(final Node o) {
            return this.mappingNumber - o.mappingNumber;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "originNumber=" + originNumber +
                    ", mappingNumber=" + mappingNumber +
                    '}';
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> numberByIndex = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            numberByIndex.put(i, mapping[i]);
        }

        List<Node> nodes = new ArrayList<>();

        for (int num : nums) {
            String origin = String.valueOf(num);
            StringBuilder mappingNumber = new StringBuilder();

            for (char c : origin.toCharArray()) {
                mappingNumber.append(numberByIndex.get(c - '0'));
            }

            nodes.add(new Node(origin.toString(), mappingNumber.toString()));
        }

        Collections.sort(nodes);
        int[] answer = new int[nodes.size()];

        for (int i = 0; i < nodes.size(); i++) {
            answer[i] = nodes.get(i).originNumber;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};

        // 338, 38, 991
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }

}
