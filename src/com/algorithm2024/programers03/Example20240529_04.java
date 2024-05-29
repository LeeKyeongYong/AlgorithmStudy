package com.algorithm2024.programers03;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Example20240529_04 { //프로그래머스 연습문제 야근지수

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(works).forEach(q::offer);

        while (n > 0 && q.peek() > 0) {

            q.offer(q.poll() - 1);
            n--;

        }

        return q.stream()
                .mapToLong(work -> (long) work * work)
                .sum();
    }

    public static void main(String[] args) {

        Example20240529_04 sol = new Example20240529_04();
        int[] works = {4, 3, 3};
        int n = 4;
        System.out.println(sol.solution(n, works));  // Example usage
    }

}
