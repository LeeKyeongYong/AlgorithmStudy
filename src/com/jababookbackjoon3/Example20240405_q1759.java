package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example20240405_q1759 {
    static int n;
    static int m;
    static char[] arr;
    static List<String> candidate;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[m];
        visited = new boolean[m];
        candidate = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        permutation(0, 0, "");
        StringBuilder sb = new StringBuilder();

        for (String s : candidate) {
            sb.append(s)
                    .append("\n");
        }

        System.out.println(sb.toString());
    }

    static void permutation(int index, int start, String sum) {
        if (index == n) {
            if (isValid(sum)) {
                candidate.add(sum);
            }
            return;
        }

        for (int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, i + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid(String sum) {
        int aeiou = 0;
        int elseChar = 0;

        for (char x : sum.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                aeiou++;
            } else {
                elseChar++;
            }
        }

        return aeiou >= 1 && elseChar >= 2;
    }
}
