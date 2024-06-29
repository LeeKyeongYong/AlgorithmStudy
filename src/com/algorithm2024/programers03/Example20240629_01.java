package com.algorithm2024.programers03;

public class Example20240629_01 { //주사위게임 1

    public int solution(int a, int b) {
        int sumMod = (a + b) & 1;  // a와 b의 합이 홀수인지 짝수인지 확인

        if (sumMod == 0) {  // 둘 다 홀수이거나 둘 다 짝수인 경우
            return (a & 1) == 1 ? a * a + b * b : Math.abs(a - b);
        } else {  // 하나는 홀수이고 하나는 짝수인 경우
            return 2 * (a + b);
        }
    }

}
