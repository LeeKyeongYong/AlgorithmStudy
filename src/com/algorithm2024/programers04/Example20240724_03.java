package com.algorithm2024.programers04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240724_03 { //2023 KAKAO BLIND RECRUITMENT 개인정보 수집 유효기간

    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        // 오늘 날짜 파싱
        LocalDate todayDate = LocalDate.parse(today, formatter);

        // 약관 정보 파싱
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termParts = term.split(" ");
            termMap.put(termParts[0], Integer.parseInt(termParts[1]));
        }

        // 개인정보 파싱 및 만료일 계산
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            LocalDate privacyDate = LocalDate.parse(privacyParts[0], formatter);
            String termType = privacyParts[1];
            int monthsToAdd = termMap.get(termType);

            // 만료일 계산
            LocalDate expiryDate = privacyDate.plusMonths(monthsToAdd);

            // 만료일이 오늘 날짜보다 같거나 이전이면 결과에 추가
            if (!expiryDate.isAfter(todayDate)) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

}
