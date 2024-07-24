package com.algorithm2024.programers04;

import java.util.*;

public class Example20240724_05 { //2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼


    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // For each course length
        for (int k : course) {
            Map<String, Integer> countMap = new HashMap<>();

            // Generate all combinations of length k for each order
            for (String order : orders) {
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars); // Sort to ensure combinations are in lexicographical order
                generateCombinations(orderChars, k, 0, new StringBuilder(), countMap);
            }

            // Find the maximum count of combinations
            int maxCount = 0;
            for (int count : countMap.values()) {
                if (count > maxCount) {
                    maxCount = count;
                }
            }

            // Collect all combinations with maximum count and add to answer list
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxCount && maxCount > 1) {
                    answer.add(entry.getKey());
                }
            }
        }

        // Sort the result list and return
        Collections.sort(answer);
        return answer;
    }

    private void generateCombinations(char[] chars, int length, int start, StringBuilder combination, Map<String, Integer> countMap) {
        if (combination.length() == length) {
            String comboStr = combination.toString();
            countMap.put(comboStr, countMap.getOrDefault(comboStr, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            combination.append(chars[i]);
            generateCombinations(chars, length, i + 1, combination, countMap);
            combination.deleteCharAt(combination.length() - 1); // Backtrack
        }
    }

}
