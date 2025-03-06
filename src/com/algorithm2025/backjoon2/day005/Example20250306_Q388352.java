package com.algorithm2025.backjoon2.day005;

import java.util.ArrayList;
import java.util.List;

public class Example20250306_Q388352 { //코딩테스트 연습 2025 프로그래머스 코드챌린지 1차 예선 비밀 코드 해독

    public int solution(int n, int[][] q, int[] ans) {
        // 가능한 모든 5개의 숫자 조합(비밀 코드 후보)을 저장할 리스트
        List<int[]> possibleCodes = new ArrayList<>();

        // 1부터 n까지의 숫자 중 5개를 선택하는 모든 조합 생성 (초기 후보군)
        generateCombinations(1, n, new int[5], 0, possibleCodes);

        // 각 시도 결과를 바탕으로 불가능한 비밀 코드 필터링
        for (int i = 0; i < q.length; i++) {
            int[] attempt = q[i];       // 시도한 5개 숫자
            int matches = ans[i];       // 시스템이 응답한 일치 개수

            // 필터링된 새로운 후보군을 저장할 리스트
            List<int[]> filteredCodes = new ArrayList<>();

            // 각 후보 코드를 검사
            for (int[] code : possibleCodes) {
                // 현재 시도한 숫자와 후보 코드 간의 일치하는 숫자 개수 계산
                int count = countMatches(attempt, code);

                // 시스템 응답과 일치하는 경우만 유지
                if (count == matches) {
                    filteredCodes.add(code);
                }
            }

            // 필터링된 후보군으로 업데이트
            possibleCodes = filteredCodes;
        }

        // 가능한 비밀 코드 조합의 개수 반환
        return possibleCodes.size();
    }

    // 두 배열에서 일치하는 요소의 개수를 계산하는 메소드
    private int countMatches(int[] arr1, int[] arr2) {
        int count = 0;
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                if (num1 == num2) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // 조합 생성을 위한 재귀 함수
    private void generateCombinations(int start, int n, int[] current, int depth, List<int[]> result) {
        // 5개 숫자가 선택되었으면 결과에 추가
        if (depth == 5) {
            result.add(current.clone());
            return;
        }

        // start부터 n까지의 숫자 중에서 선택
        for (int i = start; i <= n; i++) {
            current[depth] = i;
            generateCombinations(i + 1, n, current, depth + 1, result);
        }
    }
}