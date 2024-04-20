package com.javabook.algoritm1;

import java.util.*;

public class Example20240420_3 {
    static List<String> solution(String[] merchantNames) {
        List<String> answer = new ArrayList<>();

        List<String> merchant = new ArrayList<>(Arrays.asList(merchantNames));
        merchant.sort(Comparator.comparingInt(String::length));

        Map<String, List<String>> map = new HashMap<>();
        for (String s : merchant) {
            // 1. s가 맵에 키에서 contains되면 해당되는 key 밸류에 넣는다.
            Set<String> keys = map.keySet();

            boolean insertable = true;
            for (String key : keys) {
                if (s.contains(key)) {
                    List<String> values = map.get(key);
                    values.add(s);
                    insertable = false;
                    break;
                }
            }

            // 2. 그게 아니라면 key값을 추가한다.
            if (insertable) {
                map.put(s, new ArrayList<>());
            }
        }

        // 3. Key를 순회하면서 후보군을 찾는다.
        for (String key : map.keySet()) {
            List<String> values = map.get(key);

            // 4. values(후보군)에서 사명을 찾는다.
            List<String> candidate = new ArrayList<>();
            int maxLength = 0;

            for (String value : values) {
                String trim = value.replaceAll(" ", "");

                // 최장 길이 갱신
                if (trim.length() >= maxLength) {
                    maxLength = trim.length();
                    candidate.add(value);
                }
            }

            // 5. 후보군에서 불필요한 요소 제거
            System.out.println("candidate = " + candidate);

            // 6. 후보를 answer 에 넣는다
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] merchantNames = {"토스커피사일로&베이커리", "토스커피사일로 베이커리", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일", "비바리퍼블리카 식당", "비바리퍼블리카식", "비바리퍼블리"};

        // 토스커피사일로&베이커리, 비바리퍼블리카 식당
        System.out.println(solution(merchantNames));
    }
}
