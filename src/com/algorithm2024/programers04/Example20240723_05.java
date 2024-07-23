package com.algorithm2024.programers04;

import java.util.*;

public class Example20240723_05 { //2024 KAKAO WINTER INTERNSHIP 주사위 고르기

    public static int[] solution(int[][] dices) {
        int n = dices.length;
        int half = n / 2;
        List<int[]> diceCombinations = generateCombinations(n, half);

        Map<Integer, List<Integer>> winCountMap = new HashMap<>();
        int maxWins = Integer.MIN_VALUE;
        List<Integer> bestCombination = new ArrayList<>();

        for (int[] comb : diceCombinations) {
            List<Integer> aDice = new ArrayList<>();
            List<Integer> bDice = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (Arrays.binarySearch(comb, i) >= 0) {
                    aDice.add(i);
                } else {
                    bDice.add(i);
                }
            }

            int[] winCounts = calculateWins(dices, aDice, bDice);
            int wins = winCounts[0];
            int ties = winCounts[1];
            int losses = winCounts[2];

            if (wins > maxWins) {
                maxWins = wins;
                bestCombination = new ArrayList<>();
                for (int i : comb) {
                    bestCombination.add(i + 1); // Converting to 1-based index
                }
            }
        }

        Collections.sort(bestCombination);
        return bestCombination.stream().mapToInt(Integer::intValue).toArray();
    }

    private static List<int[]> generateCombinations(int n, int half) {
        List<int[]> combinations = new ArrayList<>();
        boolean[] used = new boolean[n];
        generateCombinationsHelper(combinations, used, 0, 0, n, half);
        return combinations;
    }

    private static void generateCombinationsHelper(List<int[]> combinations, boolean[] used, int start, int count, int n, int half) {
        if (count == half) {
            int[] comb = new int[half];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    comb[idx++] = i;
                }
            }
            combinations.add(comb);
            return;
        }
        for (int i = start; i < n; i++) {
            used[i] = true;
            generateCombinationsHelper(combinations, used, i + 1, count + 1, n, half);
            used[i] = false;
        }
    }

    private static int[] calculateWins(int[][] dices, List<Integer> aDice, List<Integer> bDice) {
        int[] winLossTie = new int[3]; // [wins, ties, losses]
        List<Integer> aSums = generateSums(dices, aDice);
        List<Integer> bSums = generateSums(dices, bDice);
        Collections.sort(bSums);

        for (int aSum : aSums) {
            int position = binarySearch(bSums, aSum);
            winLossTie[0] += position;
            winLossTie[1] += (bSums.size() - position) == 0 ? 1 : 0;
            winLossTie[2] += bSums.size() - position;
        }
        return winLossTie;
    }

    private static List<Integer> generateSums(int[][] dices, List<Integer> diceIndices) {
        List<Integer> sums = new ArrayList<>();
        int numDice = diceIndices.size();
        int combinations = (int) Math.pow(6, numDice);

        for (int i = 0; i < combinations; i++) {
            int sum = 0;
            int temp = i;
            for (int j = 0; j < numDice; j++) {
                int diceIndex = diceIndices.get(j);
                sum += dices[diceIndex][temp % 6];
                temp /= 6;
            }
            sums.add(sum);
        }
        return sums;
    }

    private static int binarySearch(List<Integer> list, int value) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
