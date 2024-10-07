package com.algorithm2024.letcode6;

import java.util.Arrays;

public class Example202410107_q567 {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
                return true;
            }
        }

        return false;
    }

    private String sort(String s) {
        char[] result = s.toCharArray();
        Arrays.sort(result);
        return new String(result);
    }
}
