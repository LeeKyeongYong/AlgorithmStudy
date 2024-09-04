package com.algorithm2024.letcode6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Example20240904_q874 {

    static final int MAX_VALUE = 60001;

    static Map<Integer, int[]> position;
    static Set<Integer> obs;

    public int robotSim(int[] commands, int[][] obstacles) {
        int answer = 0;
        position = new HashMap<>();
        position = Map.of(
                0, new int[]{0, 1},  // 북
                1, new int[]{1, 0},  // 동
                2, new int[]{0, -1}, // 남
                3, new int[]{-1, 0}  // 서
        );
        obs = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obs.add(getPos(obstacle[0], obstacle[1]));
        }

        int dir = 0;
        int x = 0;
        int y = 0;

        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                int[] next = position.get(dir);
                for (int i = 0; i < c; i++) {
                    int nX = x + next[0];
                    int nY = y + next[1];

                    if (obs.contains(getPos(nX, nY))) {
                        break;
                    }

                    x = nX;
                    y = nY;
                    answer = Math.max(x * x + y * y, answer);
                }
            }
        }

        return answer;
    }

    static int getPos(int x, int y) {
        return x + y * MAX_VALUE;
    }

    public static void main(String[] args) {
        Example20240904_q874 sol = new Example20240904_q874();

        // 65
        System.out.println(sol.robotSim(
                new int[]{4, -1, 4, -2, 4},
                new int[][]{{2, 4}}
        ));
    }

}
