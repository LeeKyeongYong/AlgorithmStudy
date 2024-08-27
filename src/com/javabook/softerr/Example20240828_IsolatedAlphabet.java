package com.javabook.softerr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240828_IsolatedAlphabet {
    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        Map<Character, List<Integer>> map = new HashMap<>(); // {index}

        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }

            List<Integer> list = map.get(c);
            list.add(i);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        for (char c : keys) {
            List<Integer> indexes = map.get(c);
            int beforeIndex = indexes.get(0);

            if (indexes.size() < 2) {
                continue;
            }

            for (int i = 1; i < indexes.size(); i++) {
                int nowIndex = indexes.get(i);

                if (nowIndex - 1 != beforeIndex) {
                    answer.append(c);
                    break;
                }

                beforeIndex = nowIndex;
            }
        }

        if (answer.toString().isEmpty()) {
            return "N";
        }

        return answer.toString();
    }
}
