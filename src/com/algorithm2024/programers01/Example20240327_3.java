package com.algorithm2024.programers01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example20240327_3 { //영어 끝말 잇기
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        int round = 1;
        String before = words[0];
        set.remove(before);

        for (int i = 1; i < words.length; i++) {
            int people = i % n + 1;

            if (i % n == 0) {
                round++;
            }

            String now = words[i];

            if (!set.contains(now)) {
                return new int[]{people, round};
            }

            if (before.charAt(before.length() - 1) != now.charAt(0)) {
                return new int[]{people, round};
            } else {
                set.remove(now);
                before = now;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        // 3 3
//        System.out.println(Arrays.toString(solution(n, words)));

        int n2 = 2;
        String[] words2 = {"hello", "one", "even", "never", "now", "world", "draw"};
        // 1 3
        System.out.println(Arrays.toString(solution(n2, words2)));

    }
}
