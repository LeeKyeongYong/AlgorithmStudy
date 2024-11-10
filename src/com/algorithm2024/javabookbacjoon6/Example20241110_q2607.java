package com.algorithm2024.javabookbacjoon6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example20241110_q2607 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            String origin = arr[0];
            String target = arr[i];

            Map<Character, Integer> tempMap = new HashMap<>(map);
            int sameAlphabet = 0;

            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);

                if (tempMap.containsKey(c) && tempMap.get(c) >= 1) {
                    tempMap.put(c, tempMap.get(c) - 1);
                    sameAlphabet++;
                }
            }

            if (target.length() == origin.length() - 1) {
                // 원본에서 하나 제거한 경우
                if (sameAlphabet == target.length()) {
                    answer++;
                }
            } else if (target.length() == origin.length() + 1) {
                // 원본에서 하나 추가해야하는 경우
                if (sameAlphabet == origin.length()) {
                    answer++;
                }
            } else if (target.length() == origin.length()) {
                if (sameAlphabet == target.length() || sameAlphabet == target.length() - 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }


}
