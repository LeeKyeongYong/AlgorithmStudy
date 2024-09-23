package com.jababookbackjoon3;

import java.util.*;

public class Example20240923_q1525 {
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[3][3];
        StringBuilder start = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                start.append(num);
            }
        }

        int answer = bfs(start.toString());
        System.out.println(answer);
    }

    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String now = queue.poll();
            int moveCount = visited.get(now);

            if (now.equals("123456780")) {
                return moveCount;
            }

            int zeroIndex = now.indexOf('0');
            int row = zeroIndex / 3;
            int col = zeroIndex % 3;

            for (int[] p : pos) {
                int nr = row + p[0];
                int nc = col + p[1];

                if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                    String nextState = swap(now, zeroIndex, nr * 3 + nc);

                    if (!visited.containsKey(nextState)) {
                        visited.put(nextState, moveCount + 1);
                        queue.offer(nextState);
                    }
                }
            }
        }

        return -1;
    }

    static String swap(String state, int a, int b) {
        StringBuilder sb = new StringBuilder(state);

        char temp = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);

        return sb.toString();
    }
}
