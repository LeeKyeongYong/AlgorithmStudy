package com.algorithm2025.backjoon.day006;

import java.util.ArrayList;
import java.util.List;

public class Example20250203_q181886 { //코딩테스트 연습 코딩 기초 트레이닝 5명씩
    public String[] solution(String[] names) {
        List<String> result = new ArrayList<>();

        // 5명씩 그룹을 나누어 각 그룹의 첫 번째 사람을 결과 리스트에 추가
        for (int i = 0; i < names.length; i += 5) {
            result.add(names[i]);
        }

        // List<String>을 String[] 배열로 변환
        return result.toArray(new String[0]);
    }

    // 테스트를 위한 메인 메소드
    public static void main(String[] args) {
        Example20250203_q181886 solution = new Example20250203_q181886();

        // 테스트 케이스
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};
        String[] result = solution.solution(names);

        // 결과 출력
        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print("\"" + result[i] + "\"");
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
