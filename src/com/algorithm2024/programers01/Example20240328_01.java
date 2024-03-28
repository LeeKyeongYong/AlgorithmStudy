package com.algorithm2024.programers01;

public class Example20240328_01 {//호텔대실_array풀이.java
    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] books = new int[book_time.length][2];

        // 24시간 : 1440분 + 끝나는 시간 10분
        int[] times = new int[1451];

        for (int i = 0; i < books.length; i++) {
            books[i][0] = parseTime(book_time[i][0]);
            books[i][1] = parseTime(book_time[i][1]) + 10;

            for (int j = books[i][0]; j < books[i][1]; j++) {
                times[j]++;
                answer = Math.max(answer, times[j]);
            }
        }

        return answer;
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
