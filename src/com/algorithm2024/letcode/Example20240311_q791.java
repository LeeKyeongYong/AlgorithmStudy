package com.algorithm2024.letcode;

import java.util.HashMap;

public class Example20240311_q791 {
    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // 원본을 모두 map에 넣기
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 패턴 문자를 하나씩 비교하면서 sb에 추가하기
        // 모두 추가 했다면 key 제거 (남은 키는 패턴에 없는 것들)
        for (char o : order.toCharArray()) {
            if (map.containsKey(o)) {
                Integer count = map.get(o);

                while (count-- > 0) {
                    sb.append(o);
                }

                map.remove(o);
            }
        }

        // 패턴에 없는 나머지 문자를 붙인다.
        for (Character key : map.keySet()) {
            Integer count = map.get(key);

            while (count-- > 0) {
                sb.append(key);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // bcad
        System.out.println(customSortString("bcafg", "abcd"));
    }
}
