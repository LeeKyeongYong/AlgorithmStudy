package com.algorithm2025.backjoon2.day003;

public class Example20250304_Q389478 { //코딩테스트 연습 2025 프로그래머스 코드챌린지 2차 예선 택배 상자 꺼내기
    public int solution(int n, int w, int num) {
        // 총 층 수 계산
        int totalRows = (n + w - 1) / w; // 올림 계산: ceil(n / w)

        // num번 상자의 위치 계산
        int numRow = (num - 1) / w; // 층 번호 (0부터 시작)
        int numCol;
        if (numRow % 2 == 0) {
            // 짝수 층: 왼쪽 → 오른쪽
            numCol = (num - 1) % w;
        } else {
            // 홀수 층: 오른쪽 → 왼쪽
            numCol = w - 1 - (num - 1) % w;
        }

        // num번 상자 위의 상자 개수 계산
        int boxesToRemove = 0;
        for (int i = num + 1; i <= n; i++) {
            int row = (i - 1) / w;
            int col;
            if (row % 2 == 0) {
                col = (i - 1) % w;
            } else {
                col = w - 1 - (i - 1) % w;
            }

            // 같은 열이고 더 높은 층에 있는 상자라면 제거해야 함
            if (col == numCol && row > numRow) {
                boxesToRemove++;
            }
        }

        // num번 상자 자체를 포함하여 반환
        return boxesToRemove + 1;
    }
}
