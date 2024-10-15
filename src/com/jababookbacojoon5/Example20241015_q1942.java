package com.jababookbacojoon5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20241015_q1942 {
    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer> seat = new PriorityQueue<>(); // 좌석 인덱스
        PriorityQueue<int[]> leaving = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 좌석번호, 떠나는 시간

        for (int i = 0; i < n; i++) {
            seat.add(i);
        }

        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int leave = times[i][1];

            while (!leaving.isEmpty() && leaving.peek()[1] <= arrival) {
                // 떠나는 시간이 됐으면 다 내보낸다 (의자 원복)
                seat.add(leaving.poll()[0]);
            }

            int nowSeat = seat.poll();

            if (i == targetFriend) {
                return nowSeat;
            }

            leaving.add(new int[]{nowSeat, leave});
        }

        return -1;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(smallestChair(
                new int[][]{
                        {1, 4},
                        {2, 3},
                        {4, 6}
                }, 1
        ));
    }
}
