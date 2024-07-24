package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240724_02 { //월간 코드 챌린지 시즌2 모두 0으로 만들기


    public long solution(int[] a, int[][] edges) {
        long answer = 0, sum = 0;
        int totalNodesCount = a.length; //전체 노드 개수
        long[] copyA = new long[totalNodesCount]; //int 배열 a -> long 배열로 복사
        Queue<Integer> q = new LinkedList<>(); //BFS 탐색용 큐

        for (int i = 0; i < totalNodesCount; i++)//long 배열로 옮기며 노드 값 총합도 계산
            sum += copyA[i] = a[i];

        if (sum != 0) //0이 아니면 애초에 과정이 불가능
            return -1;

        ArrayList<Integer>[] adjacentNodes = new ArrayList[totalNodesCount]; //인접 노드 리스트
        int[] adjacentNodesCount = new int[totalNodesCount]; //인접 노드 개수
        boolean[] visited = new boolean[totalNodesCount]; //중복 방문 방지용

        for (int i = 0; i < totalNodesCount; i++) //인접 노드 리스트 초기화
            adjacentNodes[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) { //값 채우기
            ++adjacentNodesCount[edges[i][0]];
            ++adjacentNodesCount[edges[i][1]];
            adjacentNodes[edges[i][0]].add(edges[i][1]);
            adjacentNodes[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < totalNodesCount; i++) { //리프노드(인접 노드 1개)만 큐에 입력
            if (adjacentNodesCount[i] == 1)
                q.add(i);
        }

        while (!q.isEmpty()) { //BFS 탐색
            int nowNode = q.remove();

            visited[nowNode] = true;
            long value = copyA[nowNode];

            for (int i = 0; i < adjacentNodes[nowNode].size(); i++) { //인접 노드에 값 전달
                int nextNode = adjacentNodes[nowNode].get(i);

                if (!visited[nextNode]) {
                    --adjacentNodesCount[nextNode];
                    copyA[nextNode] += value;
                    copyA[nowNode] = 0;
                    answer += Math.abs(value);

                    if (adjacentNodesCount[nextNode] == 1) {
                        q.add(adjacentNodes[nowNode].get(i));
                    }

                    break;
                }
            }
        }

        return answer;
    }

}
