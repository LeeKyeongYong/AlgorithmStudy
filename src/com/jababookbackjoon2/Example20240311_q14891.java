package com.jababookbackjoon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240311_q14891 {
    static final int S = 1;
    static final int RIGHT_SEE_INDEX = 2;
    static final int LEFT_SEE_INDEX = 6;

    static final int DIR_NOT_MOVE = 0;
    static final int DIR_TO_CLOCK = 1;
    static final int DIR_TO_REVERSE_CLOCK = -1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String str = sc.next();
            char[] charArray = str.toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                map[i][j] = charArray[j] - '0';
            }
        }

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int indexOfRotationObject = sc.nextInt() - 1;
            int rotationDirection = sc.nextInt();

            int[] dir = getDirections(map, indexOfRotationObject, rotationDirection);

            for (int j = 0; j < dir.length; j++) {
                int d = dir[j];
                map[j] = toMove(d, map[j]);
            }
        }

        int answer = getAnswer(map);

        System.out.println(answer);
    }

    private static int[] getDirections(int[][] map, int num, int dir) {
        int[] directions = new int[4];
        directions[num] = dir;

        // 왼쪽 조사
        for (int j = num; j > 1; j--) {
            if (map[j][LEFT_SEE_INDEX] == map[j - 1][RIGHT_SEE_INDEX]) {
                break;
            }

            directions[j - 1] = directions[j] * -1;
        }

        // 오른쪽 조사
        for (int j = num; j < 3; j++) {
            if (map[j][RIGHT_SEE_INDEX] == map[j + 1][LEFT_SEE_INDEX]) {
                break;
            }

            directions[j + 1] = directions[j] * -1;
        }
        return directions;
    }

    private static int getAnswer(final int[][] map) {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][0] == S) {
                answer += (int) Math.pow(2, i);
            }
        }
        return answer;
    }


    static int[] toMove(int dir, int[] arr) {
        if (dir == DIR_NOT_MOVE) {
            return arr;
        }

        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }

        if (dir == DIR_TO_REVERSE_CLOCK) {
            Integer remove = list.remove(0);
            list.add(remove);
        } else {
            Integer remove = list.remove(list.size() - 1);
            list.add(0, remove);
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
