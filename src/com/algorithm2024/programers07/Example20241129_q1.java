package com.algorithm2024.programers07;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

interface LumpStrategy {
    Map<Character, Map<Integer, Integer>> processLumps(String s);
}

class DefaultLumpStrategy implements LumpStrategy {
    @Override
    public Map<Character, Map<Integer, Integer>> processLumps(String s) {
        Map<Character, Map<Integer, Integer>> lumps = new HashMap<>();
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
        lumps.computeIfAbsent(prevChar, k -> new HashMap<>())
                .merge(count, 1, Integer::sum);

        return lumps;
    }
}

interface UnprettyStrategy {
    long calculateUnpretty(Map<Character, Map<Integer, Integer>> lumps, long n);
}

class DefaultUnprettyStrategy implements UnprettyStrategy {
    @Override
    public long calculateUnpretty(Map<Character, Map<Integer, Integer>> lumps, long n) {
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

public class Example20241129_q1 {
    private LumpStrategy lumpStrategy;
    private UnprettyStrategy unprettyStrategy;

    public Example20241129_q1(LumpStrategy lumpStrategy, UnprettyStrategy unprettyStrategy) {
        this.lumpStrategy = lumpStrategy;
        this.unprettyStrategy = unprettyStrategy;
    }

    public long solution(String s) {
        Map<Character, Map<Integer, Integer>> lumps = lumpStrategy.processLumps(s);
        long n = s.length();
        return unprettyStrategy.calculateUnpretty(lumps, n);
    }

    public static void main(String[] args) {
        LumpStrategy lumpStrategy = new DefaultLumpStrategy();
        UnprettyStrategy unprettyStrategy = new DefaultUnprettyStrategy();

        Example20241129_q1 solution = new Example20241129_q1(lumpStrategy, unprettyStrategy);
        System.out.println(solution.solution("aabbbcc"));
    }
}
