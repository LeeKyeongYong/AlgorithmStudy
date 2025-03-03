package com.algorithm2023.jababookbackjoon3;

import java.util.*;

public class Example20240424_q16166 {

    static int n;
    static HashMap<Integer, List<Integer>> map;
    static boolean[][] visited;
    static int dest;

    static class Node {
        int number;
        int station;
        int value;

        public Node(final int train, final int station, final int value) {
            this.number = train;
            this.station = station;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", station=" + station +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new HashMap<>();
        n = sc.nextInt();
        visited = new boolean[n][11];

        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            map.put(i, new ArrayList<>());

            for (int j = 0; j < count; j++) {
                map.get(i).add(sc.nextInt());
            }
        }

        dest = sc.nextInt();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        int answer = -1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.station == dest) {
                answer = now.value;
                break;
            }

            // 환승 가능역 추가
            List<Integer> nextNumbers = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getKey() == now.number) {
                    continue;
                }

                if (entry.getValue().contains(now.station)) {
                    nextNumbers.add(entry.getKey());
                }
            }

            // 현재 호선에서 갈 수 있는 곳 모두 탐색
            for (Integer next : map.get(now.number)) {
                if (!visited[now.number][next]) {
                    visited[now.number][next] = true;
                    q.add(new Node(now.number, next, now.value));
                }
            }

            // 환승 호선에서 갈 수 있는 곳 추가
            for (Integer nextNumber : nextNumbers) {
                if (!visited[nextNumber][now.station]) {
                    visited[nextNumber][now.station] = true;

                    if (now.station == 0) {
                        q.add(new Node(nextNumber, now.station, now.value));
                    } else {
                        q.add(new Node(nextNumber, now.station, now.value + 1));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
