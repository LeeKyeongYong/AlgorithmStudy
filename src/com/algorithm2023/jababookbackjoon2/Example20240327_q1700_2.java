package com.algorithm2023.jababookbackjoon2;

import java.util.*;

public class Example20240327_q1700_2 {
    static class Node {
        int index;
        int count;

        public Node(final int index, final Integer integer) {
            this.index = index;
            count = integer;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return index == node.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int index = sc.nextInt();
            arr[i] = index;
            map.put(index, map.getOrDefault(index, 0) + 1);
        }

        PriorityQueue<Node> tab = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);

        int index = 0;
        while (index != m) {
            int plug = arr[index];

            if (tab.size() < n) {
                map.put(plug, map.get(plug) - 1);
                if (map.get(plug) == 0) {
                    map.remove(plug);
                }

                if (!tab.isEmpty() && tab.contains(new Node(plug, 0))) {
                    index++;
                    continue;
                }

                tab.add(new Node(plug, map.getOrDefault(plug, 0)));
                index++;
                continue;
            }

            // 플러그가 가득 찬 상황
            // 2-1. 그대로 냅두는 경우
            if (tab.contains(new Node(plug, 0))) {
                index++;
                continue;
            }

            // 2-2. 하나 뽑아야하는 경우
            tab.poll();
            answer++;
            index++;

            map.put(plug, map.get(plug) - 1);
            if (map.get(plug) == 0) {
                map.remove(plug);
            }

            tab.add(new Node(plug, map.getOrDefault(plug, 0)));
        }

        System.out.println(answer);
    }
}
