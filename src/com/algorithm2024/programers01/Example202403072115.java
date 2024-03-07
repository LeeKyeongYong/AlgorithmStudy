package com.algorithm2024.programers01;

import java.util.*;

public class Example202403072115 {//과제진행하기
    static class Plan implements Comparable<Plan> {
        String sub;
        int startTime;
        int needTime;

        public Plan(String sub, int startTime, int needTime) {
            this.sub = sub;
            this.startTime = startTime;
            this.needTime = needTime;
        }

        public Plan(String sub, int needTime) {
            this.sub = sub;
            this.needTime = needTime;
        }

        @Override
        public int compareTo(final Plan o) {
            return this.startTime - o.startTime;
        }
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        List<Plan> planList = new ArrayList<>();
        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], getTime(plan[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(planList);
        Queue<Plan> queue = new ArrayDeque<>(planList);
        Stack<Plan> waitList = new Stack<>();

        int index = 0;
        while (!queue.isEmpty()) {
            Plan now = queue.poll();

            int nowTime = now.startTime;

            if (!queue.isEmpty()) {
                Plan next = queue.poll();

                if (now.startTime + now.needTime < next.startTime) {
                    answer[index] = now.sub;
                    index++;
                    nowTime += now.needTime;
                    continue;
                }

                int remain = next.needTime - (next.startTime - nowTime);
                waitList.push(new Plan(next.sub, remain));
                continue;
            }

            answer[index] = now.sub;
            index++;

            while (!waitList.isEmpty()) {
                Plan next = waitList.pop();
                answer[index] = next.sub;
                index++;
            }
        }

        return answer;
    }

    static int getTime(String startTime) {
        String[] split = startTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        // ["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(solution(plans)));
    }
}
