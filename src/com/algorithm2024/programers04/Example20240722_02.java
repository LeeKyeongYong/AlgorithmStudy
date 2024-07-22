package com.algorithm2024.programers04;

import java.util.HashMap;
import java.util.Map;

public class Example20240722_02 { //추억 점수
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int numPhotos = photo.length;
        int[] answer = new int[numPhotos];

        // 이름과 그리움 점수를 매핑하는 맵 생성
        Map<String, Integer> nameToScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameToScore.put(name[i], yearning[i]);
        }

        // 각 사진에 대한 점수 계산
        for (int i = 0; i < numPhotos; i++) {
            int totalScore = 0;
            for (String person : photo[i]) {
                totalScore += nameToScore.getOrDefault(person, 0);
            }
            answer[i] = totalScore;
        }

        return answer;
    }
}
