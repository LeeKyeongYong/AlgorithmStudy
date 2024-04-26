package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240426_2 {//문자열 내맘대로 정리하기
    public static String[] solution(String[] strings, int n) { //스트림을 활용하여 코드 개선처리함..
        return Arrays.stream(strings)
                .map(str -> str.charAt(n) + str)
                .sorted()
                .map(str -> str.substring(1))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] str = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(str, n)));
    }
}
