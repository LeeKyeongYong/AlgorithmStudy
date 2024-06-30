package com.algorithm2024.programers03;

public class Example20240630_01 { //꼬리 문자열
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();
        for (String str : str_list) {
            if (!str.contains(ex)) {
                answer.append(str);
            }
        }
        return answer.toString();
    }
}
