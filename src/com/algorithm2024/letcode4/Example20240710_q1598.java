package com.algorithm2024.letcode4;

public class Example20240710_q1598 {

    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if(depth == 0) {
                    continue;
                }
                depth--;
                continue;
            }

            if (log.equals("./")) {
                continue;
            }

            if (log.length() >= 1 && log.endsWith("/")) {
                depth++;
            }
        }

        return Math.abs(depth);
    }

    public static void main(String[] args) {
        // 3
        System.out.println(minOperations(
                new String[]{"d1/", "d2/", "../", "d21/", "./"}
        ));
    }

}
