package com.algorithm2024.programers03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sample20240627_01 { //프로그래머스 양과 늑대
    private static int answer;
    private static final List<List<Integer>> GRAPH = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        // 그래프 초기화
        GRAPH.clear();
        IntStream.range(0, info.length).forEach(i -> GRAPH.add(new ArrayList<>()));

        // 엣지 추가
        Arrays.stream(edges).forEach(edge -> GRAPH.get(edge[0]).add(edge[1]));

        // 초기 노드 설정
        List<Integer> next = new ArrayList<>(List.of(0));

        // DFS 수행
        dfs(info, next, 0, 0, 0);

        return answer;
    }

    private void dfs(int[] info, List<Integer> list, int node, int sheep, int wolf) {
        // 양과 늑대 수 계산
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 조건 만족하지 않으면 리턴
        if (sheep <= wolf) {
            return;
        }

        // 최대 양의 수 갱신
        answer = Math.max(answer, sheep);

        // 다음 탐색 노드 리스트 생성
        List<Integer> next = new ArrayList<>(list);
        next.addAll(GRAPH.get(node));
        next.remove(Integer.valueOf(node));

        // 다음 노드로 DFS 수행
        for (int n : next) {
            List<Integer> newList = new ArrayList<>(next);
            dfs(info, newList, n, sheep, wolf);
        }
    }

    public static void main(String[] args) {
        Sample20240627_01 sol = new Sample20240627_01();
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {4, 8}, {5, 9}};
        System.out.println(sol.solution(info, edges));  // 예상 결과: 최대 양의 수
    }
}
