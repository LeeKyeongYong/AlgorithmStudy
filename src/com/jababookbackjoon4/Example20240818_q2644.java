package com.jababookbackjoon4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240818_q2644 {
    static int n;
    static int targetFrom;
    static int targetTo;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        targetFrom = sc.nextInt();
        targetTo = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = -1;

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{targetFrom, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == targetTo) {
                answer = now[1];
                break;
            }

            for (Integer link : list[now[0]]) {
                if (visited[link]) {
                    continue;
                }

                visited[link] = true;
                q.add(new int[]{link, now[1] + 1});
            }
        }

        System.out.println(answer);
    }
}
