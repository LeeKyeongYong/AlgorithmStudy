package com.algorithm2024.programers04;

public class Example20240722_01 { //2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어

    public int solution(String s) {
        // 숫자와 대응되는 영단어를 매핑하는 배열
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // 영단어를 숫자로 변환하기 위한 문자열
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], digits[i]);
        }

        // 변환된 문자열을 정수로 변환
        return Integer.parseInt(s);
    }

}
