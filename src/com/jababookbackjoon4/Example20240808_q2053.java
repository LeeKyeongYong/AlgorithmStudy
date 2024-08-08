package com.jababookbackjoon4;

import java.util.*;

public class Example20240808_q2053 {

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();

            if (entry.getValue() > 1) {
                iterator.remove();
            }
        }

        ArrayList<String> filtered = new ArrayList<>(map.keySet());
        if (filtered.size() < k) {
            return "";
        }

        return filtered.get(k - 1);
    }

    public static void main(String[] args) {
        Example20240808_q2053 sol = new Example20240808_q2053();

        // "a"
//        System.out.println(sol.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));

        System.out.println(sol.kthDistinct(new String[]{"a", "a"}, 1));
    }

}
