package com.algorithm2024.programers03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Sample20240627_02 { //프로그래머스 양과 늑대
    private int answer;
    private final List<List<Integer>> graph;

    public Sample20240627_02() {
        this.answer = 0;
        this.graph = new ArrayList<>();
    }

    public int solution(int[] info, int[][] edges) {
        initializeGraph(info.length);
        buildGraph(edges);

        dfs(info, Collections.singletonList(0), 0, 0, 0);

        return answer;
    }

    private void initializeGraph(int size) {
        IntStream.range(0, size)
                .forEach(i -> graph.add(new ArrayList<>()));
    }

    private void buildGraph(int[][] edges) {
        Arrays.stream(edges)
                .forEach(edge -> graph.get(edge[0]).add(edge[1]));
    }

    private void dfs(int[] info, List<Integer> nextNodes, int node, int sheep, int wolf) {
        final int newSheep = sheep + (info[node] == 0 ? 1 : 0);
        final int newWolf = wolf + (info[node] == 1 ? 1 : 0);

        if (newSheep <= newWolf) {
            return;
        }

        answer = Math.max(answer, newSheep);

        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.addAll(graph.get(node));
        newNextNodes.remove(Integer.valueOf(node));

        for (int nextNode : newNextNodes) {
            dfs(info, newNextNodes, nextNode, newSheep, newWolf);
        }
    }
}
