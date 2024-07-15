package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;

public class Example20240715_01 {// 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡

    private static String replaceCode(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private static int getTimeDifference(String start, String end) {
        String[] startT = start.split(":");
        String[] endT = end.split(":");
        int startMinutes = Integer.parseInt(startT[0]) * 60 + Integer.parseInt(startT[1]);
        int endMinutes = Integer.parseInt(endT[0]) * 60 + Integer.parseInt(endT[1]);
        return endMinutes - startMinutes;
    }

    public static String solution(String m, String[] musicinfos) {
        m = replaceCode(m);

        List<String[]> matchedMusic = new ArrayList<>();
        for (String info : musicinfos) {
            String[] details = info.split(",");
            int playTime = getTimeDifference(details[0], details[1]);
            String title = details[2];
            String sheetMusic = replaceCode(details[3]);

            StringBuilder playedMusic = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                playedMusic.append(sheetMusic.charAt(i % sheetMusic.length()));
            }

            if (playedMusic.toString().contains(m)) {
                matchedMusic.add(new String[]{title, String.valueOf(playTime)});
            }
        }

        if (matchedMusic.isEmpty()) {
            return "(None)";
        }

        matchedMusic.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

        return matchedMusic.get(0)[0];
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));  // HELLO

        m = "CC#BCC#BCC#BCC#B";
        musicinfos = new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));  // FOO

        m = "ABC";
        musicinfos = new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));  // WORLD
    }
}
