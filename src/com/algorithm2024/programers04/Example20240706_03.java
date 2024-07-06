package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240706_03 { //2018 KAKAO BLIND RECRUITMENT [1차] 셔틀버스

    public static String solution(int n, int t, int m, String[] timetable) {
        int[] crewTime = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crewTime[i] = timeToMinutes(timetable[i]);
        }
        Arrays.sort(crewTime);

        int[] busTime = new int[n];
        for (int i = 0; i < n; i++) {
            busTime[i] = 9 * 60 + t * i;
        }

        int index = 0; // 다음에 버스에 오를 크루의 인덱스
        int answer = 0;

        for (int tm : busTime) {
            int cnt = 0; // 버스에 타는 크루 수
            while (cnt < m && index < crewTime.length && crewTime[index] <= tm) {
                index++;
                cnt++;
            }
            // 버스에 자리가 남았을 경우
            if (cnt < m) {
                answer = tm;
            }
            // 버스에 자리가 없는 경우 맨 마지막 크루보다 1분 전에 도착
            else {
                answer = crewTime[index - 1] - 1;
            }
        }

        return formatMinutesToTime(answer);
    }

    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    private static String formatMinutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

}
