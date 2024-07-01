package com.algorithm2024.programers04;

public class Example20240701_01 { //프로그래머스 0 떼기
    public String solution(String n_str) {
        // 정규표현식을 사용하여 문자열의 맨 앞에 있는 0들을 제거
        return n_str.replaceFirst("^0+", "");
    }
}
