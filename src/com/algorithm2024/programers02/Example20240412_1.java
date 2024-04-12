package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Example20240412_1 { //기능개발
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            int rest = 100 - progresses[i];

            int day = rest / speeds[i];
            if(rest % speeds[i] != 0) {
                day++;
            }

            q.add(day);
        }

        List<Integer> answer = new ArrayList<>();

        while(!q.isEmpty()) {
            int now = q.poll();
            int count = 1;

            while(true) {
                if(q.isEmpty()) {
                    break;
                }

                if(q.peek() <= now) {
                    count ++;
                    q.poll();
                } else {
                    break;
                }
            }

            answer.add(count);
        }

        return answer;
    }
}
