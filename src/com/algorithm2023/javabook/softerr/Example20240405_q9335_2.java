package com.algorithm2023.javabook.softerr;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Example20240405_q9335_2 {
    static final Scanner sc = new Scanner(System.in);

    static int n;
    static int[] parent;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        n = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int d = sc.nextInt();

            for (int j = 0; j < d; j++) {
                int friend = sc.nextInt();
                union(i, friend);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(parent[i]);
        }

        System.out.println(set.size());
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}
