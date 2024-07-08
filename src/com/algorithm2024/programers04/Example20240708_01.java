package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240708_01 { //2017 카카오코드 본선 단체사진 찍기

    private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static final int FRIENDS_COUNT = FRIENDS.length;

    public int solution(int n, String[] data) {
        int answer = 0;
        List<String> permutations = generatePermutations(FRIENDS, FRIENDS_COUNT);

        for (String permutation : permutations) {
            if (isValidPermutation(permutation, data)) {
                answer++;
            }
        }

        return answer;
    }

    private List<String> generatePermutations(char[] elements, int length) {
        List<String> permutations = new ArrayList<>();
        permute(elements, 0, length, permutations);
        return permutations;
    }

    private void permute(char[] elements, int start, int length, List<String> permutations) {
        if (start == length - 1) {
            permutations.add(new String(elements));
            return;
        }
        for (int i = start; i < length; i++) {
            swap(elements, start, i);
            permute(elements, start + 1, length, permutations);
            swap(elements, start, i); // backtrack
        }
    }

    private void swap(char[] elements, int i, int j) {
        char temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private boolean isValidPermutation(String permutation, String[] data) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < permutation.length(); i++) {
            indexMap.put(permutation.charAt(i), i);
        }

        for (String condition : data) {
            char first = condition.charAt(0);
            char second = condition.charAt(2);
            char operator = condition.charAt(3);
            int requiredDiff = condition.charAt(4) - '0';

            int firstIndex = indexMap.get(first);
            int secondIndex = indexMap.get(second);
            int actualDiff = Math.abs(firstIndex - secondIndex) - 1;

            if (!checkCondition(operator, requiredDiff, actualDiff)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCondition(char operator, int requiredDiff, int actualDiff) {
        switch (operator) {
            case '=':
                return actualDiff == requiredDiff;
            case '>':
                return actualDiff > requiredDiff;
            case '<':
                return actualDiff < requiredDiff;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


}
