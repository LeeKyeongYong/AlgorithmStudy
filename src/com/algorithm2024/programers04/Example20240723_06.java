package com.algorithm2024.programers04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240723_06 { //깊이/너비 우선 탐색(DFS/BFS) 아이템 줍기

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        final int SIZE = 102;
        int[][] field = new int[SIZE][SIZE];
        int[][] visited = new int[SIZE][SIZE];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the field and visited arrays
        for (int[] row : field) {
            Arrays.fill(row, -1);
        }
        for (int[] row : visited) {
            Arrays.fill(row, 1);
        }

        // Fill the field based on the rectangles
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i > x1 && i < x2 && j > y1 && j < y2) {
                        field[i][j] = 0; // Inside the rectangle
                    } else if (field[i][j] != 0) {
                        field[i][j] = 1; // Border of the rectangle
                    }
                }
            }
        }

        // Scale character and item coordinates
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;

        // BFS initialization
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return visited[x][y] / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && field[nx][ny] == 1 && visited[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }

        return 0; // If there's no path (though according to the problem, there should always be a path)
    }

}
