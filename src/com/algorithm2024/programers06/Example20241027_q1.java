package com.algorithm2024.programers06;

import java.util.ArrayList;
import java.util.List;

public class Example20241027_q1 {
    static char[] words;
    static List<String> dict;

    public int solution(String word) {
        words = new char[]{'A', 'E', 'I', 'O', 'U'};
        dict = new ArrayList<>();
        permutation(0, "");
        return dict.indexOf(word) + 1;
    }

    static void permutation(int index, String now) {
        if (index > 5) {
            return;
        }

        if (index >= 1) {
            dict.add(now);
        }

        for (int i = 0; i < 5; i++) {
            permutation(index + 1, now + words[i]);
        }
    }
}
