package com.algorithm2024.programers04;

public class Example20240705_01 { // 2023 KAKAO BLIND RECRUITMENT 택배 배달과 수거하기

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 배열을 역순으로 처리하기 위해 역순 배열 생성
        int[] revDeliveries = new int[n];
        int[] revPickups = new int[n];
        for (int i = 0; i < n; i++) {
            revDeliveries[i] = deliveries[n - 1 - i];
            revPickups[i] = pickups[n - 1 - i];
        }

        long answer = 0;
        int haveToDeli = 0;
        int haveToPick = 0;

        for (int i = 0; i < n; i++) {
            haveToDeli += revDeliveries[i];
            haveToPick += revPickups[i];

            // 배달하거나 수거할 것이 있을 때까지 처리
            while (haveToDeli > 0 || haveToPick > 0) {
                haveToDeli -= cap;
                haveToPick -= cap;
                answer += (n - i) * 2;
            }
        }

        return answer;
    }
}
