package com.algorithm2025.backjoon.day013;

import java.util.ArrayList;
import java.util.List;

public class Example20250223_Q181895 { //코딩테스트 연습 코딩 기초 트레이닝 배열 만들기 3
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> resultList = new ArrayList<>();

        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                resultList.add(arr[i]);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
