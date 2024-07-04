package com.algorithm2024.programers04;

public class Example20240704_01 { //021 KAKAO BLIND RECRUITMENT 광고 삽입

    // 시간 문자열을 초로 변환하는 메소드
    private static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
    }

    // 초를 시간 문자열로 변환하는 메소드
    private static String secondsToTime(int seconds) {
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = timeToSeconds(play_time);
        int advSec = timeToSeconds(adv_time);

        if (playSec == advSec) {
            return "00:00:00";
        }

        // 사용자가 재생한 각 초에 대해 시청자 수를 기록하는 배열
        int[] viewers = new int[playSec + 1];

        // 로그를 바탕으로 시청자 수를 업데이트
        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSeconds(times[0]);
            int end = timeToSeconds(times[1]);

            viewers[start]++;
            if (end < viewers.length) {
                viewers[end]--;
            }
        }

        // 누적 시청자 수 계산
        for (int i = 1; i < viewers.length; i++) {
            viewers[i] += viewers[i - 1];
        }

        // 광고의 최적 시작 시점을 찾기 위해 누적 시청자 수 계산
        long currentSum = 0;
        for (int i = 0; i < advSec; i++) {
            currentSum += viewers[i];
        }

        long maxSum = currentSum;
        int bestStart = 0;

        for (int i = advSec; i < viewers.length; i++) {
            currentSum += viewers[i] - viewers[i - advSec];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = i - advSec + 1;
            }
        }

        return secondsToTime(bestStart);
    }

}
