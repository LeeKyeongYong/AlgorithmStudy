package com.algorithm2024.letcode4;

import java.util.*;

public class Example20240703_q1509 {

    public static int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i : nums) {
            maxHeap.add(i);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }

            minHeap.add(i);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }

        List<Integer> minList = new ArrayList<>(maxHeap);
        Collections.sort(minList);

        List<Integer> maxList = new ArrayList<>(minHeap);
        Collections.sort(maxList);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            diff = Math.min(diff, minList.get(i) - maxList.get(i));
        }

        return diff;
    }

    public static void main(String[] args) {
        // 0
//        System.out.println(minDifference(new int[]{5, 3, 2, 4}));

        // 2
        System.out.println(minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
    }

}
