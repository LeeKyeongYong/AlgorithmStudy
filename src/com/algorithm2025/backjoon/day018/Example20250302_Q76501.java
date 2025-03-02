package com.algorithm2025.backjoon.day018;

import java.util.ArrayList;
import java.util.List;

public class Example20250302_Q76501 { //코딩테스트 연습 월간 코드 챌린지 시즌2 음양 더하기
    public List<Integer> solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                // flag[i]가 true인 경우 arr[i] × 2 번 arr[i]를 추가
                for (int j = 0; j < arr[i] * 2; j++) {
                    X.add(arr[i]);
                }
            } else {
                // flag[i]가 false인 경우 arr[i]개의 원소를 제거
                for (int j = 0; j < arr[i]; j++) {
                    if (!X.isEmpty()) {
                        X.remove(X.size() - 1);
                    }
                }
            }
        }

        return X;
    }

    public static void main(String[] args) {
        Example20250302_Q76501 solution = new Example20250302_Q76501();

        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        List<Integer> result = solution.solution(arr, flag);
        System.out.println(result);  // [3, 3, 3, 3, 4, 4, 4, 4]
    }
}
