package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240405_q2457 {
    static class Flower implements Comparable<Flower> {

        static final List<Integer> v1 = List.of(4, 6, 9, 11);
        static final List<Integer> v2 = List.of(1, 3, 5, 7, 8, 10, 12);

        int startTime;
        int endTime;

        public Flower(int sm, int sd, int em, int ed) {
            this.startTime = parseDate(sm, sd);
            this.endTime = parseDate(em, ed);
        }

        private int parseDate(int month, int day) {
            return month * 100 + day;
        }

        @Override
        public int compareTo(final Flower o1) {
            if (startTime == o1.startTime) {
                return o1.endTime - endTime;
            }

            return startTime - o1.startTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Flower> flowers = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            flowers.add(new Flower(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(flowers);

        int startDay = 301;
        int endDay = 1201;
        int answer = 0;
        int max = 0;
        int index = 0;

        while (startDay < endDay) {
            boolean ch = false;

            for (int i = index; i < n; i++) {
                if (flowers.get(i).startTime > startDay) {
                    // 현재 시작점이 그 전보다 크면 의미가 없음
                    break;
                }

                if (flowers.get(i).startTime <= startDay && max < flowers.get(i).endTime) {
                    max = flowers.get(i).endTime;
                    index = i + 1;
                    ch = true;
                }
            }

            if (ch) {
                startDay = max;
                answer++;
            } else {
                break;
            }
        }

        if (max < 1201) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
