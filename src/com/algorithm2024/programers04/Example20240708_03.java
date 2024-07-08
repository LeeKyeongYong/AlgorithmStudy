package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;

public class Example20240708_03 { //2018 KAKAO BLIND RECRUITMENT[1차] 추석 트래픽

    public int solution(String[] lines) {
        int answer = 0;
        List<long[]> log = new ArrayList<>(); // 로그의 (시작시간, 끝시간) 저장

        for (String line : lines) {
            String[] parts = line.split(" "); // 날짜, 응답완료시간, 처리시간
            String time = parts[1];
            String duration = parts[2].replace("s", "");

            String[] hms = time.split(":");
            long end = (long)((Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Double.parseDouble(hms[2])) * 1000); // 끝시간을 msec 단위로 저장
            long start = end - (long)(Double.parseDouble(duration) * 1000) + 1; // 시작 시간을 msec 단위로 저장
            log.add(new long[] { start, end });
        }

        for (long[] x : log) {
            // 최대 초당 처리량 구하기
            answer = Math.max(answer, throughput(log, x[0], x[0] + 1000));
            answer = Math.max(answer, throughput(log, x[1], x[1] + 1000));
        }

        return answer;
    }

    // 초당 처리량을 구하는 함수
    private int throughput(List<long[]> log, long start, long end) {
        int cnt = 0;
        for (long[] x : log) {
            if (x[0] < end && x[1] >= start) {
                cnt += 1;
            }
        }
        return cnt;
    }

}
