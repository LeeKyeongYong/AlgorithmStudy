package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240713_01 { //2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 두 배열의 각 원소를 OR 연산
            int combined = arr1[i] | arr2[i];
            // 이진수 변환
            String binaryString = Integer.toBinaryString(combined);
            // 길이가 n보다 작으면 앞에 0을 채워줌
            binaryString = String.format("%" + n + "s", binaryString);
            // 1을 #으로, 0을 공백으로 변환
            binaryString = binaryString.replace('1', '#').replace('0', ' ');
            // 결과 저장
            answer[i] = binaryString;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1_1 = {9, 20, 28, 18, 11};
        int[] arr1_2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n1, arr1_1, arr1_2)));

        int n2 = 6;
        int[] arr2_1 = {46, 33, 33, 22, 31, 50};
        int[] arr2_2 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution(n2, arr2_1, arr2_2)));
    }

}
