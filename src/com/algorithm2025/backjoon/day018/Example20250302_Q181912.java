package com.algorithm2025.backjoon.day018;

import java.util.ArrayList;
import java.util.List;

public class Example20250302_Q181912 { //코딩테스트 연습 코딩 기초 트레이닝 배열 만들기 5
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();

        for (String str : intStrs) {
            // s번 인덱스부터 길이 l만큼 자른 부분 문자열을 정수로 변환
            String substring = str.substring(s, s + l);
            int num = Integer.parseInt(substring);

            // 정수값이 k보다 크면 결과 리스트에 추가
            if (num > k) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Example20250302_Q181912 solution = new Example20250302_Q181912();

        String[] intStrs = {"0123456789", "9876543210", "9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;

        List<Integer> result = solution.solution(intStrs, k, s, l);
        System.out.println(result);  // [56789, 99999]
    }
}
