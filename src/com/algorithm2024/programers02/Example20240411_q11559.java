package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240411_q11559 {
    static int n = 12;
    static int m = 6;
    static char[][] map;
    static int answer;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[n][m];
        answer = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next()
                    .toCharArray();
        }

        while (true) {
            // 1. 터뜨린다.
            int count = 0;
            while (true) {
                int[] target = getTarget();

                if (target[0] == -1) {
                    break;
                }

                count++;
                bfs(target);
            }

            if (count == 0) {
                break;
            }

            answer++;

            // 3. 맵을 당긴다.
            map = resize();
        }

        System.out.println(answer);
    }

    static char[][] resize() {
        char[][] copy = new char[n][m];

        for (char[] ints : copy) {
            Arrays.fill(ints, '.');
        }

        Queue<Character> q = new LinkedList<>();

        for (int col = 0; col < m; col++) {
            q = new LinkedList<>();

            for (int row = n - 1; row >= 0; row--) {
                if (map[row][col] == '.') {
                    continue;
                }

                q.add(map[row][col]);
            }

            int size = q.size(); // 2

            for (int row = n - 1; row >= 0; row--) {
                if (size == 0) {
                    break;
                }

                size--;
                copy[row][col] = q.poll();
            }
        }

        return copy;
    }

    static void bfs(int[] target) {
        visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(target);
        visited[target[0]][target[1]] = true;
        char color = map[target[0]][target[1]];
        map[target[0]][target[1]] = '.';

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == color)) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                map[nr][nc] = '.';
            }
        }
    }

    static int[] getTarget() {
        // 1. 맵을 for문으로 탐색하면서 bfs를 돌려서 하나라도 4개 이상있는 부분을 찾는다
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = count(i, j);
                if (count >= 4) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int count(int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        char color = map[row][col];
        int count = 1;

        if (color == '.') {
            return -1;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == color)) {
                    continue;
                }

                count++;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        return count;
    }
}
