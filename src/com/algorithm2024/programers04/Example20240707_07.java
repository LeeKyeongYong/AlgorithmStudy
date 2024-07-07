package com.algorithm2024.programers04;

import java.util.*;

public class Example20240707_07 { // 깊이/너비 우선 탐색(DFS/BFS) 여행경로

    public List<String> solution(String[][] tickets) {
        // 그래프를 저장할 맵 생성
        Map<String, List<String>> graph = new HashMap<>();

        // 항공권 정보를 그래프에 저장
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(end);
        }

        // 모든 리스트를 내림차순으로 정렬
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
            Collections.reverse(destinations);
        }

        // 경로를 저장할 리스트
        List<String> path = new ArrayList<>();
        // 스택을 생성하고 ICN을 시작점으로 추가
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        // 스택을 사용하여 DFS 탐색 수행
        while (!stack.isEmpty()) {
            String route = stack.peek();
            if (!graph.containsKey(route) || graph.get(route).isEmpty()) {
                path.add(stack.pop());
            } else {
                stack.push(graph.get(route).remove(graph.get(route).size() - 1));
            }
        }

        // 경로를 뒤집어서 반환
        Collections.reverse(path);
        return path;
    }


}
