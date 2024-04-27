package com.algorithm2024.programers02;

import java.util.stream.IntStream;

public class Example20240427_02 {//배열의 원소만큼 추가하기

    public static void main(String[] args) {
        int arr[]={};
        int result[] =solution(arr);
        int result2[] =solution2(arr);

        for(int i=0; i<result.length; i++) {
            System.out.println("배열의 원소만큼 추가하기1: " + result[i]);
        }
        for(int i=0; i<result2.length; i++) {
        System.out.println("배열의 원소만큼 추가하기1: "+result[i]);
        }
    }


    //효율적으로?
    public static int[] solution(int[] arr) {
        return IntStream.of(arr)
                .flatMap(a -> IntStream.generate(() -> a).limit(a))
                .toArray();
    }

    //일반코드

    public static int[] solution2(int[] arr) {
        // 결과 배열의 크기 계산
        int size = 0;
        for (int num : arr) {
            size += num;
        }

        // 결과 배열 생성
        int[] result = new int[size];
        int index = 0;

        // 각 요소를 반복하여 결과 배열에 추가
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                result[index++] = num;
            }
        }

        return result;
    }

}
