package com.algorithm2024.programers04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Example20240708_05 { //2020 카카오 인턴십 보석 쇼핑

    public int[] solution(String[] gems) {
        int[] answer = {0, gems.length};
        int size = new HashSet<>(Arrays.asList(gems)).size();  // 보석 종류 갯수
        Map<String, Integer> gemMap = new HashMap<>();

        int left = 0, right = 0;
        gemMap.put(gems[0], 1);

        while (left < gems.length && right < gems.length) {
            // 딕셔너리에 보석 종류가 다 들어오는 경우
            if (gemMap.size() == size) {
                if (right - left < answer[1] - answer[0]) {    // 최소 크기 확인
                    answer[0] = left;
                    answer[1] = right;
                }

                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                if (gemMap.get(gems[left]) == 0) {
                    gemMap.remove(gems[left]);    // count가 0이 되면 key가 없어야하므로 반드시 remove
                }
                left += 1;
            } else {
                right += 1;

                if (right == gems.length) {
                    break;
                }

                gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
            }
        }

        return new int[]{answer[0] + 1, answer[1] + 1}; // 시작 인덱스가 1번 진열대 부터 라서 1 증가
    }


}
