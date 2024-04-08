package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240408_q5567 {
    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = 0;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[1] >= 1 && now[1] <= 2) {
                answer++;
            }

            for (Integer friend : list[now[0]]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    q.add(new int[]{friend, now[1] + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
