package com.algorithm2024.letcode5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240816_q13335 {
    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int lengthOfBridge = sc.nextInt();
        int maximumWeight = sc.nextInt();
        Queue<Truck> waitList = new LinkedList<>();
        Deque<Truck> onBridge = new LinkedList<>();
        int nowBridgeWeight = 0;
        int answer = 0;

        // 트럭들의 무게를 입력받아서 대기 리스트에 넣음
        for (int i = 0; i < n; i++) {
            waitList.add(new Truck(sc.nextInt(), lengthOfBridge));
        }

        // 모든 트럭이 다리를 건널 때까지 반복 => 두 큐가 모두 비면 끝남
        while (!waitList.isEmpty()) {
            answer++;

            // 다리 위 트럭 이동 (time 감소) 및 다리에서 내릴 트럭 확인 (순차적인 다리이므로 맨 앞에 요소만 확인해줌)
            if (!onBridge.isEmpty() && onBridge.peekFirst().time == 0) {
                nowBridgeWeight -= onBridge.pollFirst().weight;
            }

            // 대기 중인 트럭을 다리로 옮길 수 있으면 옮김
            if (!waitList.isEmpty() && nowBridgeWeight + waitList.peek().weight <= maximumWeight) {
                Truck truck = waitList.poll();
                nowBridgeWeight += truck.weight;
                onBridge.addLast(truck);
            }

            // 다리 위에 있는 모든 트럭의 시간을 감소
            for (Truck truck : onBridge) {
                truck.time--;
            }
        }

        // 효율성을 위해 정답에 마지막 올라온 트럭의 시간 + 1(while 마지막에 감소시켰으므로)
        answer += onBridge.getLast().time + 1;

        System.out.println(answer);
    }
}
