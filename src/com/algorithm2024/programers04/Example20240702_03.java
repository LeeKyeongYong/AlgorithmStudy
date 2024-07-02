package com.algorithm2024.programers04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Example20240702_03 {
    public static long solution(String s) {
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

        for (Map<Integer, Integer> lump : lumps.values()) {
            long total = lump.entrySet().stream()
                    .mapToLong(e -> (long) e.getKey() * e.getValue())
                    .sum();
            long bothSide = lump.values().stream().mapToLong(Integer::longValue).sum();

            for (int i = 1; i <= Collections.max(lump.keySet()); i++) {
                unpretty -= total * (total - 1) / 2;
                total -= bothSide;
                bothSide -= lump.getOrDefault(i, 0);
            }
        }

        return unpretty;
    }
}
