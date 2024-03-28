package com.algorithm2024.programers01;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240328_03 {//다리지나는 트럭
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                // 큐가 빈 경우
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }

                // 큐에 자리가 없는 경우
                if (q.size() == bridge_length) {
                    sum -= q.poll();
                    continue;
                }

                // 큐에 자리가 있는 경우
                if (sum + truck <= weight) {
                    // - 큐에 자리도 있고 무게도 괜찮은 경우
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else {
                    // - 큐에 자리는 있지만, 무게가 초과하는 경우
                    q.add(0);
                    time++;
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 5, 6};

        // 8
        System.out.println(solution(bridgeLength, weight, truckWeights));
    }
}
