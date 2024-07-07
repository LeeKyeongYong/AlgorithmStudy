package com.algorithm2024.programers04;

public class Example20240707_05 { //연속 펄스 부분 수열의 합
    public long solution(int[] sequence) {
        // 결과를 저장할 변수
        long answer = 0;

        // 두 가지 패턴에 대한 최대 합을 계산할 변수
        long maxSum1 = 0, maxSum2 = 0;
        long currentSum1 = 0, currentSum2 = 0;

        // 첫 번째 패턴: [1, -1, 1, -1, ...]
        // 두 번째 패턴: [-1, 1, -1, 1, ...]
        boolean isPlus = true;

        for (int num : sequence) {
            if (isPlus) {
                currentSum1 += num;  // 첫 번째 패턴의 현재 합
                currentSum2 -= num;  // 두 번째 패턴의 현재 합
            } else {
                currentSum1 -= num;  // 첫 번째 패턴의 현재 합
                currentSum2 += num;  // 두 번째 패턴의 현재 합
            }

            // 최대 연속 부분합을 갱신
            maxSum1 = Math.max(maxSum1, currentSum1);
            maxSum2 = Math.max(maxSum2, currentSum2);

            // 현재 합이 음수가 되면 0으로 초기화
            currentSum1 = Math.max(currentSum1, 0);
            currentSum2 = Math.max(currentSum2, 0);

            // 패턴 변경
            isPlus = !isPlus;
        }

        // 최대값을 반환
        answer = Math.max(maxSum1, maxSum2);
        return answer;
    }
}
