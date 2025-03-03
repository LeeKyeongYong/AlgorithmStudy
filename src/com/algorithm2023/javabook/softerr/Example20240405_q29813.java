package com.algorithm2023.javabook.softerr;

import java.util.*;

public class Example20240405_q29813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String initial = sc.next();
            int nums = sc.nextInt();
            map.put(initial, nums);
            dq.add(initial);
        }

        while (dq.size() != 1) {
            String target = dq.pollFirst();
            int targetPoint = map.get(target) - 1;

            for (int i = 0; i < targetPoint; i++) {
                dq.addLast(dq.pollFirst());
            }

            dq.pollFirst();
        }

        System.out.println(dq.pollFirst());
    }
}
