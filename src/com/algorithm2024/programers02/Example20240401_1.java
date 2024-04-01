package com.algorithm2024.programers02;

public class Example20240401_1 { //카카오톡 택배배달
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;

        for (int i = deliveries.length - 1; i >= 0; i--) {
            d += deliveries[i];
            p += pickups[i];

            while (d > 0 || p > 0) {

                d -= cap;
                p -= cap;

                answer += 2 * (i + 1);
            }
        }

        return answer;}
}
