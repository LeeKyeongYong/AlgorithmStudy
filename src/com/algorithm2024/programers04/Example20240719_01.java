package com.algorithm2024.programers04;

public class Example20240719_01 { // Summer/Winter Coding(~2018) 스티커 모으기(2)

    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0];

        // 경우 1: 첫 번째 스티커를 제외
        int[] dp1 = new int[n];
        dp1[0] = 0; // 첫 번째 스티커는 포함하지 않음
        dp1[1] = sticker[1]; // 두 번째 스티커만 포함할 수 있음
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }
        int maxWithoutFirst = dp1[n - 1];

        // 경우 2: 첫 번째 스티커를 포함
        int[] dp2 = new int[n];
        dp2[0] = sticker[0]; // 첫 번째 스티커 포함
        dp2[1] = sticker[0]; // 두 번째 스티커는 포함할 수 없고 첫 번째 스티커만 포함
        for (int i = 2; i < n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        int maxWithFirst = dp2[n - 2];

        return Math.max(maxWithoutFirst, maxWithFirst);
    }

    public static void main(String[] args) {

        Example20240719_01 solution = new Example20240719_01();
        int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = {1, 3, 2, 5, 4};

        System.out.println("스티커1의 최대 합: " + solution.solution(sticker1)); // 출력: 36
        System.out.println("스티커2의 최대 합: " + solution.solution(sticker2)); // 출력: 8
    }
}
