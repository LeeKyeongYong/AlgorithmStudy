package com.algorithm2025.backjoon.day013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20250223_Q181866 { //코딩테스트 연습 코딩 기초 트레이닝 문자열 잘라서 정렬하기

    public String[] solution(String myString) {
        String[] splitArray = myString.split("x");
        List<String> resultList = new ArrayList<>();

        for (String str : splitArray) {
            if (!str.isEmpty()) {
                resultList.add(str);
            }
        }

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
