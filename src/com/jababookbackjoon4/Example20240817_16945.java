package com.jababookbackjoon4;

import java.util.Scanner;

public class Example20240817_16945 {

    static int[] arr;
    static boolean[] visited;
    static int answer;
    static int[][] pos = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    /**
     * 0, 1, 2
     * 3, 4, 5
     * 6, 7, 8
     * 0, 3, 6
     * 1, 4, 7
     * 2, 5, 8
     * 0, 4, 8
     * 2, 4, 6
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        visited = new boolean[10];
        arr = new int[9];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        permutation(0, new int[9]);
        System.out.println(answer);
    }

    static void permutation(int index, int[] customMap) {
        if (index == 9) {
            if (isMagicNumber(customMap)) {
                answer = Math.min(answer, getMin(customMap));
            }

            return;
        }

        for (int i = 0; i < customMap.length; i++) {
            if (!visited[i + 1]) {
                visited[i + 1] = true;
                customMap[index] = i + 1;
                permutation(index + 1, customMap);
                customMap[index] = 0;
                visited[i + 1] = false;
            }
        }
    }

    static int getMin(int[] customMap) {
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            if (customMap[i] != arr[i]) {
                sum += Math.abs(arr[i] - customMap[i]);
            }
        }

        return sum;
    }

    static boolean isMagicNumber(int[] customMap) {
        for (int[] po : pos) {
            int sum = 0;

            for (int i : po) {
                sum += customMap[i];
            }

            if (sum != 15) {
                return false;
            }
        }

        return true;
    }

}
