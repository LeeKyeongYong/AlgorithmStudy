package com.algorithm2023.jababookbackjoon4;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240817_q3967 {

    static boolean[] visited;
    static char[] arr;
    static int[] positions; // '-' 위치 저장
    static boolean found;
    static int[][] pos = {
            {0, 2, 5, 7},
            {0, 3, 6, 10},
            {1, 2, 3, 4},
            {1, 5, 8, 11},
            {7, 8, 9, 10},
            {4, 6, 9, 11}
    };

    // a b c d e f g h i j k l
    // 0 2 5 7
    // 0 3 6 10
    // 1 2 3 4
    // 1 5 8 11
    // 7 8 9 10
    // 4 6 9 11

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        visited = new boolean[12];
        arr = new char[12];
        found = false;
        Arrays.fill(arr, '-');
        positions = new int[12];
        int positionCount = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            for (char c : line.toCharArray()) {
                if (c != '.') {
                    sb.append(c);
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c != 'x') {
                arr[i] = c;
                visited[c - 'A'] = true;
            } else {
                positions[positionCount] = i;
                positionCount++;
            }
        }

        backtrack(0, positionCount);
    }

    static void backtrack(int index, int positionCount) {
        if (index == positionCount) {
            if (isValid(arr)) {
                printResult(arr);
                System.exit(0);
            }
            return;
        }

        int pos = positions[index];
        for (int i = 0; i < 12; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[pos] = (char) ('A' + i);
                backtrack(index + 1, positionCount);
                arr[pos] = '-';
                visited[i] = false;
            }
        }
    }

    static boolean isValid(final char[] arr) {
        for (int[] p : pos) {
            int sum = 0;

            for (int i : p) {
                sum += arr[i] - 'A' + 1;
            }

            if (sum != 26) {
                return false;
            }
        }

        return true;
    }

    static void printResult(final char[] arr) {
        char[][] map = {
                {'.', '.', '.', '.', arr[0], '.', '.', '.', '.'},
                {'.', arr[1], '.', arr[2], '.', arr[3], '.', arr[4], '.'},
                {'.', '.', arr[5], '.', '.', '.', arr[6], '.', '.'},
                {'.', arr[7], '.', arr[8], '.', arr[9], '.', arr[10], '.'},
                {'.', '.', '.', '.', arr[11], '.', '.', '.', '.'}
        };

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
