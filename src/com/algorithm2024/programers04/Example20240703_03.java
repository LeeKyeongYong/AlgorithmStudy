package com.algorithm2024.programers04;

public class Example20240703_03 { //최고의 집합
    public int[] solution(int n, int s) {
        int quotient = s / n;  // 몫
        int remainder = s % n; // 나머지

        // 몫이 0이라면 불가능한 경우
        if (quotient == 0) {
            return new int[]{-1};
        }

        // 결과 배열
        int[] answer = new int[n];

        // 배열 뒤에서부터 처리하여 큰 값부터 할당
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = quotient; // 몫을 할당
            if (remainder > 0) {
                answer[i]++; // 나머지가 남아있으면 1씩 더해줌
                remainder--; // 남은 나머지를 하나 감소
            }
        }

        return answer;
    }
}
