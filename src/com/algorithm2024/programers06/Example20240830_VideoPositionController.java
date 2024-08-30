package com.algorithm2024.programers06;

public class Example20240830_VideoPositionController {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLen = getTime(video_len);
        int index = getTime(pos);
        int startTime = getTime(op_start);
        int endTime = getTime(op_end);

        for (String s : commands) {
            // 1. 오프닝 구간에 포함되어 있는 경우 스킵
            if (index >= startTime && index <= endTime) {
                index = endTime;
            }

            if (s.equals("prev")) {
                index = (index - 10 <= 0) ? 0 : index - 10;
                continue;
            }

            // 2. 더하면 시간이 오바돼서 더하지 못하는 경우
            index += 10;
            if (index >= videoLen) {
                index = videoLen;
            }
        }

        if (index >= startTime && index <= endTime) {
            index = endTime;
        }

        return parseTime(index);
    }

    private int getTime(String given) {
        String[] split = given.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String parseTime(int given) {
        String hour = String.valueOf(given / 60);
        String min = String.valueOf(given % 60);

        if (hour.length() == 1) {
            hour = "0" + hour;
        }

        if (min.length() == 1) {
            min = "0" + min;
        }

        return hour + ":" + min;
    }

}
