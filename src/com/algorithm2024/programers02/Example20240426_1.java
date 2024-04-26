package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20240426_1 {//문자열 내맘대로 정리하기
    public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();

        for (String string : strings) {
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);
        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(solution(str, n));

    }
}
