package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240405_q6603 {
    static final StringBuilder sb = new StringBuilder();

    static int[] lotto;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();

            if (k == 0) {
                break;
            }

            lotto = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                lotto[i] = sc.nextInt();
            }

            permutation(0, 0, new int[k]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void permutation(int index, int start, int[] now) {
        if (index == 6) {
            for (int i : now) {
                if (i == 0) {
                    continue;
                }
                sb.append(i)
                        .append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < now.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            now[index] = lotto[i];
            permutation(index + 1, i + 1, now);
            visited[i] = false;
        }
    }
}
