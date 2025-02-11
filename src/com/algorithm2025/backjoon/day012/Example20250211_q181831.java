package com.algorithm2025.backjoon.day012;

import java.util.ArrayList;
import java.util.List;

public class Example20250211_q181831 { //코딩테스트 연습 코딩 기초 트레이닝    특별한 이차원 배열 2

    public int[] solution(int[] arr, int[] delete_list) {
        // delete_list의 값을 빠르게 찾기 위해 Set으로 변환
        List<Integer> deleteSet = new ArrayList<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }

        // 결과를 담을 ArrayList
        List<Integer> resultList = new ArrayList<>();

        // arr 배열을 순회하면서 delete_list에 없는 원소만 resultList에 추가
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                resultList.add(num);
            }
        }

        // resultList를 int 배열로 변환하여 반환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
