package com.algorithm2024.programers04;

import java.util.LinkedList;
import java.util.Queue;
public class Example20240710_01 { //2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0, s2 = 0;

        for (int num : queue1) {
            q1.offer(num);
            s1 += num;
        }
        for (int num : queue2) {
            q2.offer(num);
            s2 += num;
        }

        int count = 0;
        int maxCount = queue1.length * 3;

        if (s1 == s2) {
            return 0;
        } else if ((s1 + s2) % 2 == 1) { // 같아질 수 없음
            return -1;
        }

        while (count <= maxCount) {
            if (s1 > s2) {
                int i = q1.poll();
                q2.offer(i);
                s1 -= i;
                s2 += i;
                count++;
            } else if (s2 > s1) {
                int i = q2.poll();
                q1.offer(i);
                s2 -= i;
                s1 += i;
                count++;
            } else {
                return count;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Example20240710_01 solution = new Example20240710_01();

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution.solution(queue1, queue2)); // Output: 2

        int[] queue3 = {1, 2, 1, 2};
        int[] queue4 = {1, 10, 1, 2};
        System.out.println(solution.solution(queue3, queue4)); // Output: 7

        int[] queue5 = {1, 1};
        int[] queue6 = {1, 5};
        System.out.println(solution.solution(queue5, queue6)); // Output: -1
    }

}
