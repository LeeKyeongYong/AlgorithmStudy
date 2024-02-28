package com.algorithm2024.letcode;

import java.util.Arrays;

public class Exam20240228_q1 {
    private static boolean[] visited;
    private static boolean[] answerB;

    public static int solution(int[] levels, int k) {
        // 7,1,2,4,3
        int answer = 0;
        visited = new boolean[levels.length];
        answerB = new boolean[levels.length];

        // 1,2,3,4,7
        Arrays.sort(levels);
        int maxCountOfCharacter = getMaxCountOfCharacter(levels, k);

        permutation(0, new int[maxCountOfCharacter], k, levels[levels.length - 1], maxCountOfCharacter, levels);

        for (boolean b : answerB) {
            if (!b) {
                answer++;
            }
        }
        return answer;
    }

    static void permutation(int index, int[] arr, int k, int maxLevel, int maxCountOfCharacter, int[] levels) {
        if (index == maxCountOfCharacter) {
            int need = 0;

            for (int i : arr) {
                need += (maxLevel - levels[i]);
            }

            if (need <= k) {
                for (int i : arr) {
                    answerB[i] = true;
                }
            }

            return;
        }

        for (int i = index; i < levels.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[index] = i;
            permutation(index + 1, arr, k, maxLevel, maxCountOfCharacter, levels);
            arr[index] = 0;
            visited[i] = false;
        }
    }

    private static int getMaxCountOfCharacter(final int[] levels, final int k) {
        int maxLevel = levels[levels.length - 1];

        int maxCountOfLevelUpCharacter = 0;
        int copyK = k;
        for (int i = levels.length - 1; i >= 0; i--) {
            int level = levels[i];
            int diff = maxLevel - level;

            if (diff <= copyK) {
                copyK -= diff;
                maxCountOfLevelUpCharacter++;
            } else {
                break;
            }
        }

        return maxCountOfLevelUpCharacter;
    }

    public static void main(String[] args) {

        // 1
        System.out.println(solution(new int[]{7, 1, 2, 4, 3}, 8));
    }
}
