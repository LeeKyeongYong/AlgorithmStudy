package com.algorithm2023.javabook.algoritm1;

import java.util.HashMap;
import java.util.Map;

public class Example20241004_q2 {
    public static int solution(String[] id_list, int k) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : id_list) {
            Map<String, Integer> dayCoupon = new HashMap<>();

            for (String m : s.split(" ")) {
                if (dayCoupon.containsKey(m)) {
                    continue;
                }
                dayCoupon.put(m, 1);
                map.put(m, map.getOrDefault(m, 0) + 1);
            }
        }

        for (String s : map.keySet()) {
            answer += Math.min(k, map.get(s));
        }

        return answer;
    }

    public static void main(String[] args) {
        // 7
        System.out.println(Example20241004_q2.solution(
                new String[]{"A B C D", "A D", "A B D", "B D"},
                2
        ));

        // 8
        System.out.println(Example20241004_q2.solution(
                new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"},
                3
        ));
    }
}
