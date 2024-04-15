package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240415_q28215 {
    static int n;
    static int k;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        answer = Integer.MAX_VALUE;

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        visited = new boolean[n];

        permutation(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    static void permutation(int index, int start, List<int[]> now) {
        if (index == k) {
            int maxDistanceByHomes = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                // 대피소라면 skip
                if (visited[i]) {
                    continue;
                }

                int[] home = arr[i];
                int minDistance = Integer.MAX_VALUE;

                // 대피소와 비교
                for (int[] shelter : now) {
                    minDistance = Math.min(minDistance, Math.abs(home[0] - shelter[0]) + Math.abs(home[1] - shelter[1]));
                }

                maxDistanceByHomes = Math.max(maxDistanceByHomes, minDistance);
            }

            answer = Math.min(answer, maxDistanceByHomes);
            return;
        }

        for (int i = start; i < n; i++) {
            now.add(arr[i]);
            visited[i] = true;
            permutation(index + 1, i + 1, now);
            visited[i] = false;
            now.remove(arr[i]);
        }
    }
}
