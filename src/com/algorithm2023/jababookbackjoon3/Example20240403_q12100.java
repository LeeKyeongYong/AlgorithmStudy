package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240403_q12100 {
    static int n;
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        permutation(0, map.clone());
        System.out.println(answer);
    }

    static void permutation(int depth, int[][] copy) {
        if (depth == 5) {
            int temp = getMax(copy);
            answer = Math.max(answer, temp);
            return;
        }

        for (int pos = 0; pos < 4; pos++) {
            int[][] copyMap = map.clone();

            if (pos == 0) {
                for (int col = 0; col < n; col++) {
                    int beforeValue = 0;
                    int index = 0;

                    for (int row = 0; row < n; row++) {
                        if (copyMap[row][col] != 0) {
                            if (beforeValue == copyMap[row][col]) {
                                copyMap[index - 1][col] = beforeValue * 2;
                                beforeValue = 0;
                                copyMap[row][col] = 0;
                            } else {
                                beforeValue = copyMap[row][col];
                                copyMap[row][col] = 0;
                                copyMap[index][col] = beforeValue;
                                index++;
                            }
                        }
                    }
                }
            } else if (pos == 1) {
                for (int col = 0; col < n; col++) {
                    int index = n - 1;
                    int beforeValue = 0;

                    for (int row = n - 1; row >= 0; row--) {
                        if (copyMap[row][col] != 0) {
                            if (beforeValue == copyMap[row][col]) {
                                copyMap[index + 1][col] = beforeValue * 2;
                                beforeValue = 0;
                                copyMap[row][col] = 0;
                            } else {
                                beforeValue = copyMap[row][col];
                                copyMap[row][col] = 0;
                                copyMap[index][col] = beforeValue;
                                index--;
                            }
                        }
                    }
                }
            } else if (pos == 3) {
                for (int row = 0; row < n; row++) {
                    int index = 0;
                    int beforeValue = 0;

                    for (int col = 0; col < n; col++) {
                        if (copyMap[row][col] != 0) {
                            if (beforeValue == copyMap[row][col]) {
                                copyMap[row][index - 1] = beforeValue * 2;
                                beforeValue = 0;
                                copyMap[row][col] = 0;
                            } else {
                                beforeValue = copyMap[row][col];
                                copyMap[row][col] = 0;
                                copyMap[row][index] = beforeValue;
                                index++;
                            }
                        }
                    }
                }
            } else {
                for (int row = 0; row < n; row++) {
                    int index = n - 1;
                    int beforeValue = 0;

                    for (int col = n - 1; col >= 0; col--) {
                        if (copyMap[row][col] != 0) {
                            if (beforeValue == copyMap[row][col]) {
                                copyMap[row][index + 1] = beforeValue * 2;
                                beforeValue = 0;
                                copyMap[row][col] = 0;
                            } else {
                                beforeValue = copyMap[row][col];
                                copyMap[row][col] = 0;
                                copyMap[row][index] = beforeValue;
                                index--;
                            }
                        }
                    }
                }
            }

            permutation(depth + 1, copy);
        }
    }

    static int getMax(int[][] map) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        return max;
    }
}
