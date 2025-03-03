package com.algorithm2023.jababookbackjoon2;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240327_q17135 {
    static int n;
    static int m;
    static int d;
    static int[][] map;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = 0;

        permutation(0, 0, new int[3]);
        System.out.println(answer);
    }

    static void permutation(int index, int start, int[] archers) {
        if (index == 3) {
            int[][] copyMap = copy(map);
            int max = startGame(copyMap, archers);
            answer = Math.max(answer, max);
            return;
        }

        for (int i = start; i < m; i++) {
            archers[index] = i;
            permutation(index + 1, i + 1, archers);
        }
    }

    static int startGame(int[][] copyMap, int[] archers) {
        int count = 0;

        for (int lineRow = n; lineRow >= 1; lineRow--) {
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < 3; i++) {
                int archerColumn = archers[i];
                int minRow = Integer.MAX_VALUE;
                int minCol = Integer.MAX_VALUE;
                int minDistance = Integer.MAX_VALUE;

                for (int nr = 0; nr < n; nr++) {
                    for (int nc = 0; nc < m; nc++) {
                        if (copyMap[nr][nc] == 1) {
                            int distance = getDistance(lineRow, archerColumn, nr, nc);

                            if (distance < minDistance) {
                                minDistance = distance;
                                minRow = nr;
                                minCol = nc;
                            } else if (distance == minDistance && nc < minCol) {
                                // 왼쪽 적 먼저 타격해야하므로
                                minRow = nr;
                                minCol = nc;
                            }
                        }
                    }
                }

                if (minDistance <= d) {
                    visited[minRow][minCol] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        copyMap[i][j] = 0;
                        count++;
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (i == 0) {
                        Arrays.fill(copyMap[i], 0);
                        break;
                    }
                    copyMap[i][j] = copyMap[i - 1][j];
                }
            }
        }

        return count;
    }

    static int[][] copy(int[][] map) {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }

    static int getDistance(int row, int col, int nr, int nc) {
        return Math.abs(row - nr) + Math.abs(col - nc);
    }
}
