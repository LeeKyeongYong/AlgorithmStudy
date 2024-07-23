package com.algorithm2024.letcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240723_q2418 { //키 정렬문제 (중복 이름 경우 처리한다)

    static class Node implements Comparable<Node> {
        public String name;
        public int height;

        public Node(final String name, final int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(final Node o) {
            return o.height - this.height;
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            nodes.add(new Node(names[i], heights[i]));
        }

        Collections.sort(nodes);

        String[] answer = new String[nodes.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nodes.get(i).name;
        }

        return answer;
    }

    public static void main(String[] args) {
        // b a b
        System.out.println(Arrays.toString(sortPeople(
                new String[]{"a", "b", "b"},
                new int[]{155, 185, 150}
        )));
    }

}
