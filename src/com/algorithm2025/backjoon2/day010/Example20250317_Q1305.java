package com.algorithm2025.backjoon2.day010;

import java.util.Arrays;

public class Example20250317_Q1305 { //코딩테스트 연습 2021 카카오 채용연계형 인턴십 시험장 나누기

    int n, root, cnt;
    int[] parent, left, right, people;

    public int Example20250317_Q1305(int k, int[] num, int[][] links) {
        n = num.length;
        parent = new int[n];
        left = new int[n];
        right = new int[n];
        people = num;

        Arrays.fill(parent, -1);
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        // 트리 구조 설정
        for (int i = 0; i < n; i++) {
            if (links[i][0] != -1) left[i] = links[i][0];
            if (links[i][1] != -1) right[i] = links[i][1];

            if (left[i] != -1) parent[left[i]] = i;
            if (right[i] != -1) parent[right[i]] = i;
        }

        // 루트 노드 찾기
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }

        // 이진 탐색 범위 설정
        int lo = Arrays.stream(people).max().getAsInt();  // 최소 limit은 사람들이 가장 많은 수
        int hi = (int) 1e9;

        // 이진 탐색
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (getGroup(mid) <= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // limit 이하로 그룹을 나누는 데 필요한 그룹 수를 반환
    public int getGroup(int limit) {
        cnt = 0;
        dfs(root, limit);
        return cnt + 1;  // 루트 포함해 최종 그룹 수 반환
    }

    // DFS 탐색으로 사람을 그룹화
    public int dfs(int curr, int limit) {
        // 자식 노드로부터 받은 사람 수
        int lv = 0, rv = 0;
        if (left[curr] != -1) lv = dfs(left[curr], limit);
        if (right[curr] != -1) rv = dfs(right[curr], limit);

        // 현재 노드를 포함한 그룹이 limit 이하일 경우, 합산된 사람 수 반환
        if (people[curr] + lv + rv <= limit) {
            return people[curr] + lv + rv;
        }

        // 그룹을 나누어야 하는 경우
        if (people[curr] + Math.min(lv, rv) <= limit) {
            cnt++;
            return people[curr] + Math.min(lv, rv);
        }

        // 나누기 어려우면 하나의 그룹으로 처리
        cnt += 2;
        return people[curr];
    }
}
