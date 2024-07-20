package com.algorithm2024.programers04;

public class Example20240720_02 { //JadenCase 문자열 만들기

    public static String solution(String s) {
        // 문자열을 한 글자씩 순회하며 JadenCase로 변환
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                // 공백이 오면 다음 문자는 대문자로 변환
                sb.append(c);
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    // 대문자로 변환
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    // 소문자로 변환
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); // "3people Unfollowed Me"
        System.out.println(solution("for the last week")); // "For The Last Week"
        System.out.println(solution(" a b ")); // " A B "
        System.out.println(solution("123abc DEF")); // "123abc Def"
    }

}
