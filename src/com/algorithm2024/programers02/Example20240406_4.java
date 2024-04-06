package com.algorithm2024.programers02;

import java.util.Arrays;

public class Example20240406_4 {//카메라
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int out = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (out < routes[i][0]) {
                out = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
