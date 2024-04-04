package com.algorithm2024.letcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Example20240404_q621 {
    public static int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for (char ch : tasks) {
            frequency[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                pq.add(frequency[i]);
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while (cycle-- > 0 && !pq.isEmpty()) {
                Integer currentFrequency = pq.poll();

                if (currentFrequency > 1) {
                    store.add(currentFrequency - 1);
                }
                taskCount++;
            }

            pq.addAll(store);

            if (pq.isEmpty()) {
                answer += taskCount;
            } else {
                answer += n + 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
