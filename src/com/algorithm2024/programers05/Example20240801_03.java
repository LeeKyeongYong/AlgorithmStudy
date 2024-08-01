package com.algorithm2024.programers05;

public class Example20240801_03 { //공 이동 시뮬레이션
    public static long solution(int n, int m, int x, int y, int[][] queries) {
        // 현재 위치를 (x, y)로 초기화
        long[] current = {y, y + 1, x, x + 1};
        // 이동 방향과 경계 설정
        int[] dir = {-1, 1, -1, 1};
        int[] boundary = {0, m, 0, n};
        int[] limit = {m, m, n, n};

        // 쿼리를 역순으로 처리
        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            int dx = queries[i][1];
            int reverse = command ^ 1; // 반대 방향

            // 반대 방향으로 이동
            current[reverse] += dir[reverse] * dx;
            current[reverse] = Math.max(Math.min(current[reverse], limit[reverse]), 0);

            // 현재 위치가 경계에 도달하지 않았을 때
            if (current[command] != boundary[command]) {
                current[command] += dir[reverse] * dx;
                current[command] = Math.max(Math.min(current[command], limit[command]), 0);
            }

            // 경계를 벗어난 경우
            if (current[0] == m || current[1] == 0 || current[2] == n || current[3] == 0) {
                return 0L;
            }
        }

        // 격자 내 가능한 시작점의 개수 계산
        return (1L * current[1] - current[0]) * (1L * current[3] - current[2]);
    }
}
