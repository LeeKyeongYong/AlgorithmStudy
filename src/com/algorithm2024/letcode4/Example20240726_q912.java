package com.algorithm2024.letcode4;

import java.util.PriorityQueue;

public class Example20240726_q912 { //힙정렬

    public class q912 {

        public int[] sortArray(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i : nums) {
                pq.add(i);
            }

            int[] answer = new int[nums.length];
            int index = 0;
            while (!pq.isEmpty()) {
                answer[index] = pq.poll();
                index++;
            }

            return answer;
        }
    }


}
