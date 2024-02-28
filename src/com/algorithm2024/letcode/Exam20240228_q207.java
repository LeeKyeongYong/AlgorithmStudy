package com.algorithm2024.letcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Exam20240228_q207 {
    static ArrayList<Integer>[] list;
    static boolean answer;
    static boolean[] visited;
    static int[] prefer;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        answer = true;
        visited = new boolean[numCourses];
        list = new ArrayList[numCourses];
        prefer = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            // list[선행과목] = {다음 과목1, 다음 과목2 ...}
            list[prerequisite[1]].add(prerequisite[0]);
            prefer[prerequisite[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < prefer.length; i++) {
            if (prefer[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list[now]) {
                prefer[next]--;

                if (prefer[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i : prefer) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Exam20240228_q207 sol = new Exam20240228_q207();

        // false
        System.out.println(sol.canFinish(2, new int[][]{{1, 0}, {0, 1}}));

        // true
        System.out.println(sol.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }
}
