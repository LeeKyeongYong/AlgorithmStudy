package com.algorithm2023.jababookbacojoon5;

import java.util.LinkedList;
import java.util.Queue;

public class Example20241020_q1 {
    private static final int[] dir = {-1, 1};

    public static boolean solution(int[][] map, int[] entrancePoint) {
        int n = map.length;
        int m = map[0].length;
        boolean[][][] visited = new boolean[n][m][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrancePoint[0], entrancePoint[1], 0});
        visited[entrancePoint[0]][entrancePoint[1]][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            int direction = now[2]; // 0: 좌우 이동, 1: 상하 이동

            if (map[row][col] == 7) {
                return true;
            }

            if (map[row][col] == 0 || map[row][col] == 8) {
                continue;
            }

            int moveDistance = map[row][col];

            // 좌우 이동 차례일 경우
            if (direction == 0) {
                for (int i = 0; i < 2; i++) {
                    int nr = row;
                    int nc = col + dir[i] * moveDistance;

                    if (isValid(nr, nc, n, m) && !visited[nr][nc][1]) {
                        queue.offer(new int[]{nr, nc, 1});
                        visited[nr][nc][1] = true;
                    }
                }
            } else {
                // 상하
                for (int i = 0; i < 2; i++) {
                    int nx = row + dir[i] * moveDistance;
                    int ny = col;

                    if (isValid(nx, ny, n, m) && !visited[nx][ny][0]) {
                        queue.offer(new int[]{nx, ny, 0}); // 다음은 좌우 이동
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int nr, int nc) {
        return row >= 0 && col >= 0 && row < nr && col < nc;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{
                        {1, 2, 1},
                        {8, 2, 0},
                        {1, 7, 2}
                }, new int[]{0, 0}
        ));
    }
}
