package com.algorithm2024.programers04;

public class Example20240705_05 { //순위
    public int solution(int n, int[][] results) {
        int[][] distArray = new int[n][n];

        // 초기화: 승리 결과 반영
        for (int[] result : results) {
            int win = result[0] - 1;
            int lose = result[1] - 1;
            distArray[win][lose] = 1;
        }

        // Floyd-Warshall 알고리즘 수행
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distArray[i][j] == 0 && distArray[i][k] == 1 && distArray[k][j] == 1) {
                        distArray[i][j] = 1;
                    }
                }
            }
        }

        int[] columnSum = new int[n];
        int[] rowSum = new int[n];

        // 각 행과 열의 합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columnSum[j] += distArray[i][j];
                rowSum[i] += distArray[i][j];
            }
        }

        // 정확한 순위를 매길 수 있는 선수 수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (columnSum[i] + rowSum[i] == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
