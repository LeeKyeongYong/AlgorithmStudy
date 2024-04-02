package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240402_02 { //개인수집정보기간
    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> docs = new HashMap<>();

        int boundary = parseToFullDay(today);
        for (String term : terms) {
            String[] split = term.split(" ");
            docs.put(split[0], parseToDay(split[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String doc = split[1];

            int endDay = parseToFullDay(date) + docs.get(doc);

            if (boundary >= endDay) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    static int parseToFullDay(String date) {
        String[] split = date.split("\\.");
        return Integer.parseInt(split[0]) * 12 * 28 + Integer.parseInt(split[1]) * 28 + Integer.parseInt(split[2]);
    }

    static int parseToDay(String month) {
        return Integer.parseInt(month) * 28;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies)); // 1, 3

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(solution(today2, terms2, privacies2)); // 1, 4, 5
    }
}
