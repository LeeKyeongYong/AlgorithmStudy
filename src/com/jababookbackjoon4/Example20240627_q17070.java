package com.jababookbackjoon4;

import java.util.Scanner;

public class Example20240627_q17070 {
    static int n;
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        if (map[n - 1][n - 1] == 1) {
            System.out.println(answer);
            return;
        }

        /**
         * 2 : 가로
         * 3 : 대각선
         * 4 : 세로
         */
        map[0][0] = 2;
        map[0][1] = 2;

        permutation(copy(map), new int[]{0, 0, 0, 1});
        System.out.println(answer);
    }

    static void permutation(int[][] localMap, int[] positions) {
        int[] before1 = new int[]{positions[0], positions[1]};
        int[] before2 = new int[]{positions[2], positions[3]};

        if (before2[0] == n - 1 && before2[1] == n - 1) {
            answer++;
            return;
        }

        if (localMap[before2[0]][before2[1]] == 2) {
            // 가로인 경우 : 가로, 대각선 가능
            int[] next1 = before2.clone();
            int[] next2 = new int[]{before2[0], before2[1] + 1};
            if (next2[1] < n && map[next2[0]][next2[1]] != 1) {
                localMap[next1[0]][next1[1]] = 2;
                localMap[next2[0]][next2[1]] = 2;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }

            next1 = before2.clone();
            next2 = new int[]{before2[0] + 1, before2[1] + 1};
            if (next2[1] < n && next2[0] < n && map[next2[0]][next2[1]] != 1
                    && map[next2[0] - 1][next2[1]] != 1
                    && map[next2[0]][next2[1] - 1] != 1
            ) {
                localMap[next1[0]][next1[1]] = 3;
                localMap[next2[0]][next2[1]] = 3;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }

        } else if (localMap[before2[0]][before2[1]] == 3) {
            // 대각선인 경우 : 세 방향 모두 가능
            int[] next1 = before2.clone();
            int[] next2 = new int[]{before2[0], before2[1] + 1};
            if (next2[1] < n && map[next2[0]][next2[1]] != 1) {
                localMap[next1[0]][next1[1]] = 2;
                localMap[next2[0]][next2[1]] = 2;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }

            next1 = before2.clone();
            next2 = new int[]{before2[0] + 1, before2[1] + 1};
            if (next2[1] < n && next2[0] < n && map[next2[0]][next2[1]] != 1
                    && map[next2[0] - 1][next2[1]] != 1
                    && map[next2[0]][next2[1] - 1] != 1
            ) {
                localMap[next1[0]][next1[1]] = 3;
                localMap[next2[0]][next2[1]] = 3;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }

            next1 = before2.clone();
            next2 = new int[]{before2[0] + 1, before2[1]};
            if (next2[1] < n && next2[0] < n && map[next2[0]][next2[1]] != 1) {
                localMap[next1[0]][next1[1]] = 4;
                localMap[next2[0]][next2[1]] = 4;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }


        } else if (localMap[before2[0]][before2[1]] == 4) {
            // 세로인 경우 : 세로, 대각선 가능
            int[] next1 = before2.clone();
            int[] next2 = new int[]{before2[0] + 1, before2[1]};
            if (next2[1] < n && next2[0] < n && map[next2[0]][next2[1]] != 1) {
                localMap[next1[0]][next1[1]] = 4;
                localMap[next2[0]][next2[1]] = 4;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }

            next1 = before2.clone();
            next2 = new int[]{before2[0] + 1, before2[1] + 1};
            if (next2[1] < n && next2[0] < n && map[next2[0]][next2[1]] != 1
                    && map[next2[0] - 1][next2[1]] != 1
                    && map[next2[0]][next2[1] - 1] != 1
            ) {
                localMap[next1[0]][next1[1]] = 3;
                localMap[next2[0]][next2[1]] = 3;
                permutation(copy(localMap), new int[]{next1[0], next1[1], next2[0], next2[1]});
            }
        }
    }

    static int[][] copy(int[][] arr) {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }
}
