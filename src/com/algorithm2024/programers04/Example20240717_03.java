package com.algorithm2024.programers04;

import java.util.*;

public class Example20240717_03 { //깊이/너비 우선 탐색(DFS/BFS) 단어 변환

    public int solution(String begin, String target, String[] wordsArray) {
        // 단어 집합을 List로 변환
        List<String> words = Arrays.asList(wordsArray);
        // 타겟 단어가 words에 포함되어 있는지 확인
        if (!words.contains(target)) {
            return 0;
        }

        // BFS를 위한 큐
        Queue<String> queue = new LinkedList<>();
        // 단계 수를 저장할 큐
        Queue<Integer> steps = new LinkedList<>();
        // 방문한 단어를 기록할 set
        Set<String> visited = new HashSet<>();

        // 초기 상태를 큐에 추가
        queue.add(begin);
        steps.add(0);
        visited.add(begin);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentStep = steps.poll();

            // 목표 단어에 도달했으면 반환
            if (current.equals(target)) {
                return currentStep;
            }

            // 현재 단어와 다른 단어들 간의 차이를 확인
            for (String word : words) {
                if (!visited.contains(word) && checkDiff(current, word)) {
                    visited.add(word);
                    queue.add(word);
                    steps.add(currentStep + 1);
                }
            }
        }

        // 변환할 수 없는 경우
        return 0;
    }

    // 두 단어가 한 문자만 다른지 확인하는 함수
    private boolean checkDiff(String a, String b) {
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

}
