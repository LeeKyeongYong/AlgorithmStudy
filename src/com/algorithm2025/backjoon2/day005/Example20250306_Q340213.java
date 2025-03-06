package com.algorithm2025.backjoon2.day005;

public class Example20250306_Q340213 { //코딩테스트 연습  PCCP 기출문제 [PCCP 기출문제] 1번 / 동영상 재생기

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 문자열 시간을 초 단위로 변환
        int videoLength = convertToSeconds(video_len);
        int currentPos = convertToSeconds(pos);
        int opStart = convertToSeconds(op_start);
        int opEnd = convertToSeconds(op_end);

        // 현재 위치가 오프닝 구간인지 확인하고, 맞다면 오프닝 건너뛰기
        if (currentPos >= opStart && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        // 명령 처리
        for (String command : commands) {
            if (command.equals("prev")) {
                // 10초 전으로 이동
                currentPos = Math.max(0, currentPos - 10);
            } else if (command.equals("next")) {
                // 10초 후로 이동
                currentPos = Math.min(videoLength, currentPos + 10);
            }

            // 명령 실행 후 오프닝 구간인지 확인
            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }

        // 최종 위치를 "mm:ss" 형식으로 변환하여 반환
        return convertToTimeFormat(currentPos);
    }

    // 시간 문자열("mm:ss")을 초 단위로 변환하는 메소드
    private int convertToSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // 초 단위 시간을 "mm:ss" 형식으로 변환하는 메소드
    private String convertToTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}