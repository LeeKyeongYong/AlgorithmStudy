package com.algorithm2024.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam20240226_q2092 {
    static int[] parent;
    static List<Integer> answer;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n];
        answer = new ArrayList<>();

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        union(0, firstPerson);

        // 1. 시간순 정렬
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[0] - o2[0];
            }

            return o1[2] - o2[2];
        });

        // 2. 유니온파인드
        for (int[] meeting : meetings) {
            int x = find(meeting[0]);
            int y = find(meeting[1]);

            union(x, y);
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == 0) {
                answer.add(i);
            }
        }

        return answer;
    }

    static int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }

        return x;
    }

    static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx > fy) {
            parent[x] = fy;
        } else {
            parent[y] = fx;
        }
    }

    public static void main(String[] args) {
        Exam20240226_q2092 sol = new Exam20240226_q2092();

//        System.out.println(sol.findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));

        // 0,1,3,4
        System.out.println(sol.findAllPeople(5, new int[][]{{1, 4, 3}, {0, 4, 3}}, 3));

        // 0, 1
    }

}
