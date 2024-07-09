package com.algorithm2024.letcode4;

public class Example20240709_q1701 {

    public static double averageWaitingTime(int[][] customers) {

        double answer = 0;

        int readyForCookTime = customers[0][0];

        int[][] copy = new int[customers.length][2];
        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < 2; j++) {
                copy[i][j] = customers[i][j];
            }
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i][0] < readyForCookTime) {
                copy[i][0] += readyForCookTime - copy[i][0];
                copy[i][1] += readyForCookTime - copy[i][0];
            }

            readyForCookTime = readyForCookTime + copy[i][1];
            copy[i][1] += copy[i][0];
        }

        for (int i = 0; i < customers.length; i++) {
            int min = Math.min(customers[i][0], copy[i][0]);
            int max = Math.max(customers[i][1], copy[i][1]);

            answer += (max - min);
        }

        return answer / customers.length;
    }

    public static void main(String[] args) {
        // 5.00000
        System.out.println(averageWaitingTime(
                new int[][]{
                        {1, 2},
                        {2, 5},
                        {4, 3}
                }
        ));
    }

}
