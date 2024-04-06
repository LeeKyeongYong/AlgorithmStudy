package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.List;

public class Example20240406_1 {//양과 늑대
    static int n;
    static ArrayList<Integer>[] graph;
    static int answer;
    static int[] infos;

    public static int solution(int[] info, int[][] edges) {
        answer = 0;
        n = info.length;
        graph = new ArrayList[n];
        infos = info;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        List<Integer> n = new ArrayList<>();
        permutation(n, 0, 0, 0);
        return answer;
    }

    static void permutation(List<Integer> list, int index, int sheep, int wolves) {
        if (infos[index] == 0) {
            sheep++;
        } else {
            wolves++;
        }

        if (sheep <= wolves) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> next = new ArrayList<>(list);
        if (!graph[index].isEmpty()) {
            next.addAll(graph[index]);
        }
        next.remove(Integer.valueOf(index));

        for (Integer i : next) {
            permutation(next, i, sheep, wolves);
        }

    }

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};

        // 5
        System.out.println(solution(info, edges));
    }
}
