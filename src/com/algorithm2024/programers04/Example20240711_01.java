package com.algorithm2024.programers04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example20240711_01 { // 2018 KAKAO BLIND RECRUITMENT [1차] 뉴스 클러스터링

    public int solution(String str1, String str2) {
        List<String> str1Lst = createBigrams(str1.toLowerCase());
        List<String> str2Lst = createBigrams(str2.toLowerCase());

        if (str1Lst.isEmpty() && str2Lst.isEmpty()) {
            return 65536;
        }

        Map<String, Long> counter1 = str1Lst.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<String, Long> counter2 = str2Lst.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long inter = counter1.entrySet().stream()
                .filter(e -> counter2.containsKey(e.getKey()))
                .mapToLong(e -> Math.min(e.getValue(), counter2.get(e.getKey())))
                .sum();

        long union = counter1.entrySet().stream()
                .mapToLong(e -> Math.max(e.getValue(), counter2.getOrDefault(e.getKey(), 0L)))
                .sum()
                + counter2.entrySet().stream()
                .filter(e -> !counter1.containsKey(e.getKey()))
                .mapToLong(Map.Entry::getValue)
                .sum();

        return (int) ((double) inter / union * 65536);
    }

    private List<String> createBigrams(String str) {
        return IntStream.range(0, str.length() - 1)
                .mapToObj(i -> str.substring(i, i + 2))
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Example20240711_01 sol = new Example20240711_01();
        System.out.println(sol.solution("FRANCE", "french")); // 16384
        System.out.println(sol.solution("handshake", "shake hands")); // 65536
        System.out.println(sol.solution("aa1+aa2", "AAAA12")); // 43690
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2")); // 65536
    }


}
