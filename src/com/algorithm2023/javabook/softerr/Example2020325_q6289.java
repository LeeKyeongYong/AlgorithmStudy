package com.algorithm2023.javabook.softerr;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Example2020325_q6289 {
    static int n;
    static int m;
    static int[] arr;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            set.add(i);
        }

        System.out.println(set.size());
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if (arr[findX] > arr[findY]) {
            parent[y] = findX;
        } else if (arr[findX] < arr[findY]) {
            parent[x] = findY;
        } else {
            parent[y] = findX;
        }
    }
}
