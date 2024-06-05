package com.algorithm2024.letcode3;

import java.util.*;

public class Example20240605_q1002 {
    public static List<String> commonChars(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (String s : words[0].split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            Map<String, Integer> temp = new HashMap<>();
            for (String s : word.split("")) {
                temp.put(s, temp.getOrDefault(s, 0) + 1);
            }

            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                String key = entry.getKey();
                if (temp.containsKey(key)) {
                    map.put(key, Math.min(entry.getValue(), temp.get(key)));
                } else {
                    iterator.remove();
                }
            }
        }

        for (String s : map.keySet()) {
            for (int i = 0; i < map.get(s); i++) {
                answer.add(s);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }
}
