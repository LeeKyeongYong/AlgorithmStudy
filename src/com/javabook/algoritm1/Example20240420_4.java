package com.javabook.algoritm1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240420_4 {

    static int answer;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    static int solution(int[][] relationships, int target, int limit) {
        answer = 0;
        list = new ArrayList[101];
        visited = new boolean[101];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] r : relationships) {
            list[r[0]].add(r[1]);
            list[r[1]].add(r[0]);
        }

        visited[target] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target, 0});
        int sum = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int who = now[0];
            int depth = now[1];

            if (depth <= target) {
                if (depth == 1) {
                    answer += 5;
                } else {
                    answer += 11;
                }
            } else {
                continue;
            }

            for (Integer friend : list[who]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    q.add(new int[]{friend, depth + 1});
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] re = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};

        // 37
        System.out.println(solution(re, 2, 3));
    }
}
