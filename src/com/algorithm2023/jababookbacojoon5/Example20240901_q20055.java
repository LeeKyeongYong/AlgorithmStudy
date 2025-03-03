package com.algorithm2023.jababookbacojoon5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Example20240901_q20055 {
    static int n;
    static int k;
    static int size;
    static List<Node> conveyor;
    static int answer;
    static int zeroDurabilityCount;

    static class Node {
        int durability;
        boolean hasRobot;

        public Node(final int durability) {
            this.durability = durability;
            this.hasRobot = false;
        }

        public void addRobot() {
            this.hasRobot = true;

            durability--;
            if (durability == 0) {
                zeroDurabilityCount++;
            }
        }

        public void deleteRobot() {
            this.hasRobot = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt(); // 내구도가 0인 칸의 개수 limit
        size = 2 * n;
        answer = 0;
        zeroDurabilityCount = 0;

        conveyor = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            conveyor.add(new Node(sc.nextInt()));
        }

        while (zeroDurabilityCount < k) {
            // 1. 로봇과 함께 한 칸 회전 (만약 n이면 도착 및 로봇 제거)
            answer++;
            conveyor.add(0, conveyor.remove(conveyor.size() - 1));
            if (conveyor.get(n - 1).hasRobot) {
                conveyor.get(n - 1).deleteRobot();
            }

            // 2. 가장 먼저 올라간 로봇부터 한칸 이동 (내구도 1이상 남아야 이동 가능)
            for (int i = n - 1; i > 0; i--) {
                // 로봇 없는 경우 스킵
                if (!conveyor.get(i).hasRobot) {
                    continue;
                }

                // 다음 칸에 로봇이 있는 경우 혹은 내구도 0이면 스킵
                if (conveyor.get(i + 1).hasRobot || conveyor.get(i + 1).durability <= 0) {
                    continue;
                }

                // 로봇 이동 및 내구도 깎기
                conveyor.get(i).deleteRobot();
                conveyor.get(i + 1).addRobot();

                // 로봇이 도착하면 로봇 하차
                if (i + 1 == n - 1) {
                    conveyor.get(i + 1).deleteRobot();
                }
            }

            // 3. 올리는 위치에 내구도가 0이 아니면 로봇을 올린다.
            if (conveyor.get(0).durability > 0) {
                conveyor.get(0).addRobot();
            }
        }

        System.out.println(answer);
    }
}
