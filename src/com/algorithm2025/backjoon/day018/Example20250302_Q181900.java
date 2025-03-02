package com.algorithm2025.backjoon.day018;

public class Example20250302_Q181900 { //코딩테스트 연습 코딩 기초 트레이닝 글자 지우기
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;

        // absolutes 배열의 길이만큼 반복하며 실제 값을 계산하고 합산
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                // signs[i]가 true면 해당 값은 양수
                result += absolutes[i];
            } else {
                // signs[i]가 false면 해당 값은 음수
                result -= absolutes[i];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Example20250302_Q181900 solution = new Example20250302_Q181900();

        // 첫 번째 예제
        int[] absolutes1 = {4, 7, 12};
        boolean[] signs1 = {true, false, true};
        System.out.println(solution.solution(absolutes1, signs1));  // 출력: 9

        // 두 번째 예제
        int[] absolutes2 = {1, 2, 3};
        boolean[] signs2 = {false, false, true};
        System.out.println(solution.solution(absolutes2, signs2));  // 출력: 0
    }

}
