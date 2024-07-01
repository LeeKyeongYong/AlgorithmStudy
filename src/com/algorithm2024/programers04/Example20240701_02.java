package com.algorithm2024.programers04;

import java.util.ArrayList;

public class Example20240701_02 { // ad 제거하기
    public String[] solution(String[] strArr) {
        // 'ad'를 포함하지 않는 문자열을 저장할 ArrayList 생성
        ArrayList<String> filteredList = new ArrayList<>();

        for (String str : strArr) {
            // 'ad'가 포함되어 있지 않으면 리스트에 추가
            if (!str.contains("ad")) {
                filteredList.add(str);
            }
        }

        // ArrayList를 String 배열로 변환하여 반환
        return filteredList.toArray(new String[0]);
    }
}
