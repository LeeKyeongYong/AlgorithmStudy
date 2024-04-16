package com.algorithm2024.programers02;

import java.util.*;

public class Example20240416_1 {
    static int n;
    static int m;
    static char[][] map;
    static List<Integer> answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] solution(String[] maps) {
        answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(map[i][j])) {
                    if (!visited[i][j]) {
                        int num = bfs(i, j);
                        answer.add(num);
                        System.out.println(num);
                    }
                }
            }
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    static int bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));
        visited[row][col] = true;
        int count = map[row][col] - '0';

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now.row + pos[i][0];
                int nc = now.col + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc])) {
                    continue;
                }

                if (!Character.isDigit(map[nr][nc])) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new Node(nr, nc));
                count += map[nr][nc] - '0';
            }

        }
        return count;
    }
}
