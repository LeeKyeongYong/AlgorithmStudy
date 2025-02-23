package com.algorithm2025.backjoon.day013;

public class Example20250223_Q181867 { //코딩테스트 연습 코딩 기초 트레이닝 x 사이의 개수
    public int[] solution(String myString) {
        String[] splitArray = myString.split("x", -1);

        int[] result = new int[splitArray.length];
        for (int i = 0; i < splitArray.length; i++) {
            result[i] = splitArray[i].length();
        }

        return result;
    }
}
