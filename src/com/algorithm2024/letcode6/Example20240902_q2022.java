package com.algorithm2024.letcode6;

import java.util.Arrays;

public class Example20240902_q2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) {
            return new int[0][0];
        }

        int[][] map = new int[m][n];

        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = original[index];
                index++;
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Example20240902_q2022 sol = new Example20240902_q2022();

        // {{1,2}, {3,4}}
        System.out.println(Arrays.deepToString(sol.construct2DArray(
                new int[]{1, 2, 3, 4},
                2,
                2
        )));

        // []
        System.out.println(Arrays.deepToString(sol.construct2DArray(
                new int[]{1, 2},
                1,
                1
        )));
    }
}
