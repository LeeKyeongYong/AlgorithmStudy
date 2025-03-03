package com.algorithm2023.jababookbackjoon2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240327_q1700_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int index = sc.nextInt();
            arr[i] = index;
            map.put(index, map.getOrDefault(index, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int plug = arr[i];

            // 1. 플러그 가능한 경우
            if (pq.isEmpty() || pq.size() < n) {
                if (!pq.isEmpty() && pq.contains(plug)) {
                    continue;
                }

                map.put(plug, map.get(plug) - 1);
                pq.add(new int[]{plug, map.get(plug)});
                continue;
            }

            // 2. 플러그 가득 찬 경우

            // 2-1. 이미 있는 경우 * arr[0] == plug 인 경우는 패스
            boolean isContinue = false;
            for (int[] ints : pq) {
                if (ints[0] == plug) {
                    isContinue = true;
                    ints[1] = map.get(ints[0] - 1);
                    break;
                }
            }
            if (isContinue) {
                continue;
            }

            // 2-2. 없는 경우
            int dePlug = 0;
            pq.poll();
            answer++;

            pq.add(new int[]{plug, map.get(plug) - 1});
        }

        System.out.println(answer);
    }
}
