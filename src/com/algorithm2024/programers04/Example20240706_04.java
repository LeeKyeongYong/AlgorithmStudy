package com.algorithm2024.programers04;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Example20240706_04 { // 이중우선순위큐

    public static int[] solution(String[] operations) {
        // PriorityQueue for min heap and max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // HashSet to keep track of elements to be removed
        Set<Integer> toRemove = new HashSet<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            char command = parts[0].charAt(0);
            int value = Integer.parseInt(parts[1]);

            if (command == 'I') {
                minHeap.add(value);
                maxHeap.add(value);
                toRemove.remove(value);
            } else if (command == 'D') {
                if (value == 1) {
                    while (!maxHeap.isEmpty() && toRemove.contains(maxHeap.peek())) {
                        maxHeap.poll();
                    }
                    if (!maxHeap.isEmpty()) {
                        int maxVal = maxHeap.poll();
                        toRemove.add(maxVal);
                    }
                } else {
                    while (!minHeap.isEmpty() && toRemove.contains(minHeap.peek())) {
                        minHeap.poll();
                    }
                    if (!minHeap.isEmpty()) {
                        int minVal = minHeap.poll();
                        toRemove.add(minVal);
                    }
                }
            }
        }

        while (!minHeap.isEmpty() && toRemove.contains(minHeap.peek())) {
            minHeap.poll();
        }

        while (!maxHeap.isEmpty() && toRemove.contains(maxHeap.peek())) {
            maxHeap.poll();
        }

        int maxVal = minHeap.isEmpty() ? 0 : maxHeap.poll();
        int minVal = minHeap.isEmpty() ? 0 : minHeap.poll();

        return new int[]{maxVal, minVal};
    }

}
