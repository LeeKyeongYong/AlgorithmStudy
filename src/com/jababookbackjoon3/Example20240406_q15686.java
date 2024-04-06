package com.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Example20240406_q15686 {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> chickens;
    static List<int[]> homes;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                map[i][j] = num;

                if (num == 2) {
                    chickens.add(new int[]{i, j});
                }

                if (num == 1) {
                    homes.add(new int[]{i, j});
                }
            }
        }

        permutation(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    static void permutation(int index, int start, List<int[]> now) {
        if (index == m) {
            int sum = getChickenLength(now);
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            int[] pos = chickens.get(i);
            now.add(pos);
            permutation(index + 1, i + 1, now);
            now.remove(pos);
        }
    }

    static int getChickenLength(List<int[]> now) {
        int sum = 0;

        for (int[] home : homes) {
            int temp = Integer.MAX_VALUE;

            for (int[] chickens : now) {
                temp = Math.min(temp, getDistance(home[0], home[1], chickens[0], chickens[1]));
            }

            sum += temp;
        }

        return sum;
    }

    static int getDistance(int row, int col, int nr, int nc) {
        return Math.abs(row - nr) + Math.abs(col - nc);
    }
}
