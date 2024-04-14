package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20240414_3 {//셔틀버스
    public static String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : timetable) {
            pq.add(getTime(s));
        }

        int startTime = getTime("09:00");
        int lastTime = 0;
        int rideCount = 0;

        for (int bus = 0; bus < n; bus++) {
            rideCount = 0;

            while (!pq.isEmpty()) {
                Integer nowTime = pq.peek();

                if (nowTime <= startTime && rideCount < m) {
                    pq.poll();
                    rideCount++;
                } else {
                    break;
                }

                lastTime = nowTime - 1;
            }

            startTime += t;
        }

        if (rideCount < m) {
            lastTime = startTime - t;
        }

        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }

    static int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        int n = 1; // 셔틀 운행
        int t = 1; // 운행 간격
        int m = 5; // 최대 크루 수
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        // 09:00
        System.out.println(solution(n, t, m, timetable));
    }
}
