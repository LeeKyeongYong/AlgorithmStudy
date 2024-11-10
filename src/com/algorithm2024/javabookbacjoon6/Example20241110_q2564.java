package com.algorithm2024.javabookbacjoon6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20241110_q2564 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n + 1][m + 1];
        int t = sc.nextInt();
        List<Integer> shops = new ArrayList<>();

        for (int i = 1; i <= t; i++) {
            int dir = sc.nextInt();
            int position = sc.nextInt();

            shops.add(handle(dir, position, n, m));
        }

        int pos = sc.nextInt();
        int position = sc.nextInt();

        int start = handle(pos, position, n, m);
        int answer = 0;
        for (int shop : shops) {
            int case1 = Math.abs(shop - start);
            int case2 = 2 * n + 2 * m - case1;

            answer += Math.min(case1, case2);
        }

        System.out.println(answer);
    }

    private static int handle(final int dir, final int position, final int n, final int m) {
        if (dir == 1) {
            // 북쪽
            return position;
        }

        if (dir == 2) {
            // 남쪽
            return m + m + n - position;
        }

        if (dir == 3) {
            // 서쪽
            return 2 * n + 2 * m - position;
        }

        if (dir == 4) {
            // 동쪽
            return m + position;
        }

        return -1;
    }

}
