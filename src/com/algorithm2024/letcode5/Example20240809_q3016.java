package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Example20240809_q3016 {

    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        int lastFields = 8;
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 오름차순 정렬
        ArrayList<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));
        int answer = 0;

        for (int i = 0; i < keys.size(); i++) {
            // 매핑이 가능한 경우
            if (lastFields >= 1) {
                lastFields--;
                answer += map.get(keys.get(i));
                continue;
            }

            // 매핑이 불가능한 경우
            // 가장 키가 적은 곳에 세팅 (알파벳 수)
            if (i >= 8 && i <= 15) {
                answer += 2 * map.get(keys.get(i));
            } else if (i >= 16 && i <= 23) {
                answer += 3 * map.get(keys.get(i));
            } else {
                answer += 4 * map.get(keys.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240809_q3016 sol = new Example20240809_q3016();

        // 24
        System.out.println(sol.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

}
