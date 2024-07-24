package com.algorithm2024.programers04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Example20240725_02 { //2019 카카오 개발자 겨울 인턴십 튜플

    public static int[] solution(String s) {
        // 결과를 담을 Set
        Set<Integer> resultSet = new LinkedHashSet<>();

        // 문자열 처리
        s = s.substring(1, s.length() - 1);  // 외부 중괄호 제거
        String[] tuples = s.split("\\},\\{");  // 중괄호로 나누기

        // 각 튜플을 처리
        for (int i = 0; i < tuples.length; i++) {
            tuples[i] = tuples[i].replace("{", "").replace("}", "");
        }

        // 튜플 길이 기준으로 정렬
        Arrays.sort(tuples, Comparator.comparingInt(String::length));

        // 결과 집합에 추가
        for (String tuple : tuples) {
            String[] numbers = tuple.split(",");
            for (String num : numbers) {
                resultSet.add(Integer.parseInt(num));
            }
        }

        // Set을 배열로 변환
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

}
