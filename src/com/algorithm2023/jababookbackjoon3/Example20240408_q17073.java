package com.algorithm2023.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Scanner;

public class Example20240408_q17073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[b].add(a);
            list[a].add(b);
        }

        int leaf = 0;
        for (int i = 2; i <= n; i++) {
            if (list[i].size() == 1) {
                leaf++;
            }
        }

        System.out.println(String.format("%.10f", (double) m / leaf));
    }
}
