package com.javabook.algoritm1;

import java.util.ArrayList;
import java.util.List;

public class Example20240420_5 {
    public static int solution(String s, int n) {
        int answer = -1;
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= s.length() - n; i++) {
            list.add(s.substring(i, i + n));
        }

        for (String sub : list) {
            boolean isDigital = true;

            for (int i = 1; i <= n; i++) {

                if (!sub.contains(String.valueOf(i))) {
                    isDigital = false;
                    break;
                }
            }

            if (isDigital) {
                answer = Math.max(answer, Integer.parseInt(sub));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 21
        System.out.println(solution("1451232125", 2));
    }
}
