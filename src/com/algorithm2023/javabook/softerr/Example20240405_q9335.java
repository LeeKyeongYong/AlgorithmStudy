package com.algorithm2023.javabook.softerr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240405_q9335 {
    static final Scanner sc = new Scanner(System.in);

    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        n = sc.nextInt();
        list = new ArrayList[n + 1];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int d = sc.nextInt();

            for (int j = 0; j < d; j++) {
                int friend = sc.nextInt();
                list[i].add(friend);
                list[friend].add(i);
            }
        }

        visited = new boolean[n + 1];

        ArrayList<List<Integer>> candidate = new ArrayList<>();
        permutation(n, 1, new ArrayList<>(), candidate);

        for (List<Integer> c : candidate) {
            visited = new boolean[n + 1];

            for (int i = 0; i < c.size(); i++) {
                Integer now = c.get(i);
                visited[i + 1] = true;

                for (Integer friend : list[now]) {
                    visited[friend] = true;
                }

                if (check(visited)) {
                    answer = Math.min(answer, i + 1);
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean check(boolean[] visited) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    static void permutation(int n, int index, List<Integer> now, ArrayList<List<Integer>> candidate) {
        if (!now.isEmpty()) {
            candidate.add(now);
        }

        for (int i = index; i <= n; i++) {
            now.add(i);
            permutation(n, i + 1, new ArrayList<>(now), candidate);
            now.remove(now.size() - 1);
        }
    }
}
