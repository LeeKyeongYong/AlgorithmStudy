package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20240705_04 { //가짜 해밀토니안

    private static int answer = 1;

    private static List<Integer> DFS(int parNode, int nowNode, List<List<Integer>> graph) {
        List<Integer> nv = Arrays.asList(1, 1, 1); // depth, spread, 하위 spread 2개 합
        List<List<Integer>> v = new ArrayList<>();
        int childNode = 0;

        for (int i = 0; i < graph.get(nowNode).size(); i++) {
            childNode = graph.get(nowNode).get(i);
            if (childNode != parNode) {
                v.add(DFS(nowNode, childNode, graph));
            }
        }

        if (!v.isEmpty()) {
            // v3 값 계산
            v.sort((a, b) -> a.get(2) == b.get(2) ? b.get(0) - a.get(0) : b.get(2) - a.get(2));
            int maxDepth = 0;
            int maxV2 = v.get(0).get(2); // max nv[2] 값

            if (v.size() > 2) {
                for (int i = 2; i < v.size(); i++) {
                    maxDepth = Math.max(maxDepth, v.get(i).get(0));
                }
                answer = Math.max(answer, 1 + Math.max(maxDepth, v.get(1).get(0)) + v.get(0).get(2));
                answer = Math.max(answer, 1 + Math.max(maxDepth, v.get(0).get(0)) + v.get(1).get(2));
            } else if (v.size() == 2) {
                answer = Math.max(answer, 1 + v.get(1).get(0) + v.get(0).get(2));
                answer = Math.max(answer, 1 + v.get(0).get(0) + v.get(1).get(2));
            } else if (v.size() == 1) {
                answer = Math.max(answer, 1 + v.get(0).get(2));
            }

            v.sort((a, b) -> a.get(1) == b.get(1) ? b.get(0) - a.get(0) : b.get(1) - a.get(1));
            maxDepth = 0;
            if (v.size() > 2) {
                for (int i = 3; i < v.size(); i++) {
                    maxDepth = Math.max(maxDepth, v.get(i).get(0));
                }
                answer = Math.max(answer, 1 + Math.max(maxDepth, v.get(2).get(0)) + v.get(0).get(1) + v.get(1).get(1));
                answer = Math.max(answer, 1 + Math.max(maxDepth, v.get(0).get(0)) + v.get(1).get(1) + v.get(2).get(1));
                answer = Math.max(answer, 1 + Math.max(maxDepth, v.get(1).get(0)) + v.get(0).get(1) + v.get(2).get(1));

                nv.set(0, 1 + Math.max(maxDepth, Math.max(v.get(0).get(0), Math.max(v.get(1).get(0), v.get(2).get(0)))));
                nv.set(1, 1 + Math.max(Math.max(maxDepth, v.get(0).get(0)), v.get(2).get(0)) + v.get(1).get(1));
                nv.set(1, Math.max(nv.get(1), 1 + Math.max(Math.max(maxDepth, v.get(1).get(0)), v.get(2).get(0)) + v.get(0).get(1)));
                nv.set(2, Math.max(maxV2 + 1, v.get(0).get(1) + v.get(1).get(1) + 1));
                return nv;
            } else if (v.size() == 2) {
                answer = Math.max(answer, 1 + v.get(0).get(1) + v.get(1).get(1));
                nv.set(1, 1 + Math.max(v.get(0).get(0) + v.get(1).get(1), v.get(0).get(1) + v.get(1).get(0)));
                nv.set(0, 1 + Math.max(v.get(0).get(0), v.get(1).get(0)));
                nv.set(2, Math.max(maxV2 + 1, v.get(0).get(1) + v.get(1).get(1) + 1));
                return nv;
            } else {
                nv.set(0, 1 + v.get(0).get(0));
                nv.set(1, 1 + v.get(0).get(1));
                answer = Math.max(answer, nv.get(1));
                nv.set(2, Math.max(maxV2 + 1, v.get(0).get(1) + 1));
                return nv;
            }
        }
        return nv;
    }

    public static int solution(int[][] t) {
        int n = t.length + 1;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : t) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        DFS(-1, t[0][0], graph);
        return answer;
    }

}
