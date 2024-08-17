package com.jababookbackjoon4;

import java.util.Scanner;

public class Example20240817_17615 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        int redCount = 0;
        int blueCount = 0;
        int moveCount = 0;

        for (char c : str.toCharArray()) {
            if (c == 'R') {
                redCount++;
            } else {
                blueCount++;
            }
        }

        // 섞여 있는 경우 가장 적은 것을 한쪽으로 움직여야함
        int answer = Math.min(blueCount, redCount);

        // Red 오른쪽 이동 (오른쪽에 있는 레드에서 블루를 발견하면 그 앞에 있는 애들은 뒤로 가야하므로 첫 블루 만나면 브레이크, answer 계산에서도 앞에 Red 카운팅)
        moveCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') {
                moveCount++;
            } else {
                break;
            }
        }
        answer = Math.min(redCount - moveCount, answer);

        // Red 왼쪽 이동
        moveCount = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                moveCount++;
            } else {
                break;
            }
        }
        answer = Math.min(redCount - moveCount, answer);

        // Blue 오른쪽 이동
        moveCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') {
                moveCount++;
            } else {
                break;
            }
        }
        answer = Math.min(blueCount - moveCount, answer);

        // Blue 왼쪽 이동
        moveCount = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B') {
                moveCount++;
            } else {
                break;
            }
        }
        answer = Math.min(blueCount - moveCount, answer);

        System.out.println(answer);
    }

}
