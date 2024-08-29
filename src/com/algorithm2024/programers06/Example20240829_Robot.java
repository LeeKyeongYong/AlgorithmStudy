package com.algorithm2024.programers06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240829_Robot {// 프로그래머스 pccp 모의고사 로봇

    // 시계방향 순서
    static int[][] pos = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[] solution(String command) {
        int[] answer = {};

        int row = 0;
        int col = 0;
        int dirIndex = 0;

        for (char c : command.toCharArray()) {
            if (c == 'L') {
                dirIndex--;
                if (dirIndex < 0) {
                    dirIndex = 3;
                }

                continue;
            }

            if (c == 'R') {
                dirIndex++;
                if (dirIndex == 4) {
                    dirIndex = 0;
                }

                continue;
            }

            if (c == 'G') {
                row += pos[dirIndex][0];
                col += pos[dirIndex][1];
            } else {
                row -= pos[dirIndex][0];
                col -= pos[dirIndex][1];
            }
        }

        return new int[]{col, row};
    }

    public static void main(String[] args) {
        Example20240829_Robot sol = new Example20240829_Robot();

        // 2, 2
//        System.out.println(Arrays.toString(sol.solution("GRGLGRG")));

        // 2, 0
        System.out.println(Arrays.toString(sol.solution("GRGRGRB")));
    }

}
