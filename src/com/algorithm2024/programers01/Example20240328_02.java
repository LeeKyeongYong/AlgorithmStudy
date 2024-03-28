package com.algorithm2024.programers01;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20240328_02 { //호텔
    public static int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] books = new int[book_time.length][2];

        for (int i = 0; i < books.length; i++) {
            books[i][0] = parseTime(book_time[i][0]);
            books[i][1] = parseTime(book_time[i][1]) + 10;
        }

        Arrays.sort(books, (o1, o2) -> {
            // 시작시간 오름차순 / 종료시간 오름차순
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        for (int[] book : books) {
            if (pq.isEmpty()) {
                // 처음이면 끝나는 시간에 둔다
                pq.add(book[1]);
                continue;
            }

            Integer beforeEndTime = pq.peek();
            if (beforeEndTime <= book[0]) {
                pq.poll();
                pq.add(book[1]);
            } else {
                pq.add(book[1]);
            }
        }


        return pq.size();
    }

    private static int parseTime(String time) {
        String[] split = time.split(":");

        String hour = split[0];
        String min = split[1];

        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        // 3
        System.out.println(solution(book_time));
    }
}
