package com.algorithm2024.programers02;

import java.util.HashMap;
import java.util.Map;

public class Example20240414_2 {//로또의 초고순위와 최저순위
    public int[] solution(int[] lottos, int[] win_nums) {
        int max = 0;
        int min = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : win_nums) {
            map.put(i, 1);
        }

        int zeroCount = 0;
        int answerCount = 0;
        for (int i : lottos) {
            if (i == 0) {
                zeroCount++;
            }

            if (map.containsKey(i)) {
                answerCount++;
            }
        }

        max = answerCount + zeroCount;
        min = answerCount;

        Map<Integer, Integer> score = new HashMap<>();
        score.put(6, 1);
        score.put(5, 2);
        score.put(4, 3);
        score.put(3, 4);
        score.put(2, 5);

        max = score.getOrDefault(max, 6);
        min = score.getOrDefault(min, 6);

        return new int[]{max, min};
    }
}
