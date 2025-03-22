package com.algorithm2025.backjoon2.day011;

import java.util.HashMap;
import java.util.Map;

public class Example20250322_Q68938 {  //코딩테스트 연습 월간 코드 챌린지 시즌1 문자열의 아름다움
    public static long Example20250322_Q68938(String s) {
        // `lumps`를 관리할 Map
        Map<Character, Map<Integer, Integer>> lumps = new HashMap<>();

        // 문자열에서 연속된 문자 그룹 찾기
        char prevChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                lumps.computeIfAbsent(prevChar, k -> new HashMap<>())
                        .merge(count, 1, Integer::sum);
                prevChar = currentChar;
                count = 1;
            }
        }
        // 마지막 그룹 추가
        lumps.computeIfAbsent(prevChar, k -> new HashMap<>())
                .merge(count, 1, Integer::sum);

        // `unpretty` 계산
        long n = s.length();
        long unpretty = (n - 1) * n * (n + 1) / 6;

        // lumps 내의 각 그룹에 대해 unpretty를 계산
        for (Map<Integer, Integer> lump : lumps.values()) {
            long total = 0;
            long bothSide = 0;

            // lump에서 각 크기의 그룹에 대해 합산
            for (Map.Entry<Integer, Integer> entry : lump.entrySet()) {
                int length = entry.getKey();
                int countOfLength = entry.getValue();
                total += (long) length * countOfLength;
                bothSide += countOfLength;
            }

            // 이 그룹에 대한 'unpretty' 계산
            for (int i = 1; i <= lump.size(); i++) {
                unpretty -= total * (total - 1) / 2;
                total -= bothSide;
                bothSide -= lump.getOrDefault(i, 0);
            }
        }

        return unpretty;
    }
}
