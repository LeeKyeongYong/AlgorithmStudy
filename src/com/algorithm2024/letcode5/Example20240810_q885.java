package com.algorithm2024.letcode5;

public class Example20240810_q885 {

    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] map = new int[rows * cols][2];
        int index = 0;

        for (int step = 1, direction = 0; index < rows * cols; ) {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        map[index][0] = rStart;
                        map[index][1] = cStart;
                        index++;
                    }

                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }

            step++;
        }

        return map;
    }

}
