package com.algorithm2024.letcode7;

public class Example20241110_q796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(s);
        sb.append(s);

        return sb.toString().contains(goal);
    }
}
