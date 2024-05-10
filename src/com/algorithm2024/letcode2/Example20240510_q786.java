package com.algorithm2024.letcode2;

import java.util.*;

public class Example20240510_q786 {

    static class Node {
        int num1;
        int num2;
        double value;

        public Node(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.value = (double) num1 / num2;
        }
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, Node> map = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                map.put((double) arr[i] / arr[j], new Node(arr[i], arr[j]));
            }
        }

        List<Double> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        double key = keySet.get(k - 1);
        return new int[]{map.get(key).num1, map.get(key).num2};
    }

    public static void main(String[] args) {
        // 2 5
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }

}
