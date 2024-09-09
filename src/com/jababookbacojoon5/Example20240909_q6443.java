package com.jababookbacojoon5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example20240909_q6443 {
    static int n;
    static char[] arr;
    static boolean[] visited;
    static List<String> list;
    static StringBuilder answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = new StringBuilder();

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            String str = sc.next();
            solve(str);
        }

        System.out.println(answer.toString());
    }

    static void solve(String str) {
        n = str.length();
        arr = str.toCharArray();
        visited = new boolean[n];
        list = new ArrayList<>();
        Arrays.sort(arr);

        permutation(0, new StringBuilder());

        for (String s : list) {
            answer.append(s)
                    .append("\n");
        }
    }

    static void permutation(int index, StringBuilder now) {
        if (now.length() == n) {
            answer.append(now)
                    .append("\n");
            return;
        }

        char prev = '\0';
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true;
                now.append(arr[i]);
                permutation(index + 1, now);
                now.deleteCharAt(now.length() - 1);
                visited[i] = false;
                prev = arr[i];
            }
        }
    }
}
