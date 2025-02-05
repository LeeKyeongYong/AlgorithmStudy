package com.algorithm2025.backjoon.day008;

import java.util.Arrays;

public class Example20250205_q181909 { //코딩테스트 연습 코딩 기초 트레이닝 접미사 배열

    public String[] solution(String my_string) {
        int n = my_string.length();
        String[] suffixes = new String[n];

        // 모든 접미사 생성
        for (int i = 0; i < n; i++) {
            suffixes[i] = my_string.substring(i);
        }

        // 사전순 정렬
        Arrays.sort(suffixes);

        return suffixes;
    }

}
