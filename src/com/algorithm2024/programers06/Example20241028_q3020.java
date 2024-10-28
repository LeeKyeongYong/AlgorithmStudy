package com.algorithm2024.programers06;

import java.util.Scanner;

public class Example20241028_q3020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] toUp = new int[h + 1];
        int[] toDown = new int[h + 1];

        for (int i = 0; i < n / 2; i++) {
            int toUpNum = sc.nextInt();
            int toDownNum = sc.nextInt();

            toUp[toUpNum]++;
            toDown[toDownNum]++;
        }

        for (int i = h - 1; i >= 1; i--) {
            toUp[i] += toUp[i + 1];
            toDown[i] += toDown[i + 1];
        }

        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            int obstacles = toUp[i] + toDown[h - i + 1];

            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }

        System.out.println(minObstacles + " " + count);
    }

}
