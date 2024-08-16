package com.algorithm2024.letcode5;

import java.util.Scanner;

public class Example20240816_q1244 {
    private static final int MALE = 1;
    private static final int FEMALE = 2;
    private static final int ON = 1;
    private static final int OFF = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] switches = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }

        int numberOfStudent = sc.nextInt();
        int[][] students = new int[numberOfStudent][2];

        for (int i = 0; i < numberOfStudent; i++) {
            students[i][0] = sc.nextInt();
            students[i][1] = sc.nextInt();
        }

        for (int[] student : students) {
            int sex = student[0];
            int number = student[1];
            int index = number;

            if (sex == MALE) {
                while (index < switches.length) {
                    if (switches[index] == ON) {
                        switches[index] = OFF;
                    } else {
                        switches[index] = ON;
                    }

                    index += number;
                }

                continue;
            }

            if (sex == FEMALE) {
                int left = number - 1;
                int right = number + 1;

                // 자신의 위치 초기 스위치 값 변경
                if (switches[index] == ON) {
                    switches[index] = OFF;
                } else {
                    switches[index] = ON;
                }

                // 스위치 팰린드롬 찾기
                while (left >= 1 && right < switches.length) {
                    int nowValue = switches[left];
                    int afterValue = nowValue == ON ? OFF : ON;

                    if (switches[left] == switches[right]) {
                        switches[left] = afterValue;
                        switches[right] = afterValue;
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i] + " ");

            if (i % 20 == 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
