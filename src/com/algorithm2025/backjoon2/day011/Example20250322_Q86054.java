package com.algorithm2025.backjoon2.day011;

public class Example20250322_Q86054 { // 코딩테스트 연습 월간 코드 챌린지 시즌3 안티세포
    static final int MOD = 1000000007;

    // 세포 연결을 추적하는 배열
    static long[] sum;

    public int[] Example20250322_Q86054(int[] a, int[] s) {
        int[] answer = new int[s.length];

        for (int t = 0; t < s.length; t++) {
            int n = s[t];
            sum = new long[n + 1]; // 각 세포에 대한 결과 값을 저장
            sum[0] = 1; // 초기 조건: 시작점은 1

            // 동적 계획법을 위한 DP 테이블 초기화
            for (int i = 1; i <= n; i++) {
                sum[i] = 0;
            }

            // 세포 연결
            for (int i = 0; i < n; i++) {
                connect(a[i], i + 1, n);
            }

            // 결과 저장
            answer[t] = (int) (sum[n] % MOD);
        }

        return answer;
    }

    // connect 메서드: 각 세포를 연결하여 가능한 조합 수를 계산
    static void connect(long num, int index, int n) {
        // 해당 세포 크기(num)에 대한 값을 업데이트
        long temp = sum[index - 1];

        // 해당 값으로 가능하면 수를 갱신
        for (int i = 0; i < index; i++) {
            if (sum[i] != 0) {
                temp = (temp + sum[i] * num) % MOD;
            }
        }

        sum[index] = temp;
    }
}
