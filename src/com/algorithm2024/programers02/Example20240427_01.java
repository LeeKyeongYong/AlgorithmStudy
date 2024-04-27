package com.algorithm2024.programers02;

import java.util.stream.IntStream;

public class Example20240427_01 { //프로그래머스 배열 비교하기
    public static int solution(int[] arr1, int[] arr2) {
        //두 배열의 합을계산한다.
        int sum1 = IntStream.of(arr1).sum();
        int sum2 = IntStream.of(arr2).sum();

        return Integer.compare(arr1.length, arr2.length) == 0 // 두개의 배열을 비교한다 길이가 같다면 0을 반환
                // compare 비교하여 결과값을 반환한다.
                ? Integer.compare(sum1, sum2)
                : Integer.compare(arr1.length, arr2.length);
    }

    public static void main(String[] args) {
        //-1 길이가 맞지않은경우
        int arr1[]={49,13};
        int arr2[]={70,11,2};

        //1
        //int arr1[]={100, 17, 84, 1};
        //int arr2[]={55, 12, 65, 36};

        //0
        //int arr1[]={1, 2, 3, 4, 5};
        //int arr2[]={3, 3, 3, 3, 3};

        //-1 arr2가 큰경우
        //int arr1[]={100, 17, 84, 1};
        //int arr2[]={55, 12, 65, 36};

        int result = solution(arr1,arr2);
        System.out.println("배열비교하기 결과값: "+result);
    }
}
