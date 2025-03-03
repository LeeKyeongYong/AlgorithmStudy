package com.algorithm2023.jababookbackjoon4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example20240501_q15666 {
    static int[] arr;
    static int n;
    static int m;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        permutation(0, 0, "");
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void permutation(int index, int start, String sum) {
        if (index == m) {
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            permutation(index + 1, i, sum + arr[i] + " ");
        }
    }
}
