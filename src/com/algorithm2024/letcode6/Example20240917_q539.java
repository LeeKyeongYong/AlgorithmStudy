package com.algorithm2024.letcode6;

import java.util.Arrays;
import java.util.List;

public class Example20240917_q539 {

    public int findMinDifference(List<String> timePoints) {
        int answer = Integer.MAX_VALUE;
        int[] minutes = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);
        for (int i = 0; i < minutes.length - 1; i++) {
            answer = Math.min(answer, minutes[i + 1] - minutes[i]);
        }

        return Math.min(answer, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }

}
