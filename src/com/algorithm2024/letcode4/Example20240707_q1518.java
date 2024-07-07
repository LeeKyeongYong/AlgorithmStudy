package com.algorithm2024.letcode4;

public class Example20240707_q1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0;
        int lastBottles = 0;

        while (true) {
            // 1. 온전한 물을 마신다
            answer += numBottles;

            // 2. 빈 병을 구한다
            int emptyBottles = numBottles + lastBottles;

            // 3. 다음에 마실 물을 구한다.
            numBottles = emptyBottles / numExchange;

            // 4. 다음에 사용할 빈 병을 구한다
            lastBottles = emptyBottles % numExchange;

            // 마실 물이 없다면 종료한다.
            if (numBottles == 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240707_q1518 sol = new Example20240707_q1518();

        // 19
        System.out.println(sol.numWaterBottles(15, 4));
    }

}
