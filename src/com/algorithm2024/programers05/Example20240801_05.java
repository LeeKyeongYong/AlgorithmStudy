package com.algorithm2024.programers05;

import java.util.*;

public class Example20240801_05 { //2019 KAKAO BLIND RECRUITMENT 후보키

    public static int solution(String[][] relations) {
        int numRows = relations.length;
        int numCols = relations[0].length;

        List<Set<Integer>> answer = new ArrayList<>();
        List<Integer> keyIndex = new ArrayList<>();

        for (int i = 0; i < numCols; i++) {
            keyIndex.add(i);
        }

        int count = 1;
        while (count <= numCols) {
            List<List<Integer>> combinations = generateCombinations(keyIndex, count);

            for (List<Integer> com : combinations) {
                Map<String, Integer> dictionary = new HashMap<>();

                for (String[] relation : relations) {
                    StringBuilder keyValue = new StringBuilder();
                    for (int co : com) {
                        keyValue.append(relation[co]).append(' ');
                    }

                    if (!dictionary.containsKey(keyValue.toString())) {
                        dictionary.put(keyValue.toString(), 1);
                    }
                }

                // Uniqueness check
                if (numRows == dictionary.size()) {
                    // Minimality check
                    boolean isMinimal = true;
                    for (Set<Integer> ans : answer) {
                        int matchedCount = 0;
                        for (int an : ans) {
                            if (com.contains(an)) {
                                matchedCount++;
                            }
                        }
                        if (matchedCount == ans.size()) {
                            isMinimal = false;
                            break;
                        }
                    }
                    if (isMinimal) {
                        answer.add(new HashSet<>(com));
                    }
                }
            }
            count++;
        }

        return answer.size();
    }

    // Generate all combinations of a given size
    private static List<List<Integer>> generateCombinations(List<Integer> keyIndex, int size) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsRecursive(keyIndex, size, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsRecursive(List<Integer> keyIndex, int size, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < keyIndex.size(); i++) {
            current.add(keyIndex.get(i));
            generateCombinationsRecursive(keyIndex, size, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
