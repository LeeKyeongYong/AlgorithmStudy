package com.algorithm2025.backjoon.day018;

import java.util.ArrayList;
import java.util.List;

public class Example20250302_Q181860 { //코딩테스트 연습 코딩 기초 트레이닝 빈 배열에 추가, 삭제하기
    public String solution(String my_string, int[] indices) {
        // 삭제할 인덱스를 배열로부터 List로 변환
        List<Integer> indicesList = new ArrayList<>();
        for (int index : indices) {
            indicesList.add(index);
        }

        // 결과 문자열을 담을 StringBuilder
        StringBuilder result = new StringBuilder();

        // my_string의 각 문자에 대해 인덱스를 확인하고, 삭제할 인덱스가 아니면 결과에 추가
        for (int i = 0; i < my_string.length(); i++) {
            if (!indicesList.contains(i)) {
                result.append(my_string.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Example20250302_Q181860 solution = new Example20250302_Q181860();

        // 첫 번째 예제
        String my_string1 = "apporoograpemmemprs";
        int[] indices1 = {1, 16, 6, 15, 0, 10, 11, 3};
        System.out.println(solution.solution(my_string1, indices1));  // 출력: "programmers"
    }
}
