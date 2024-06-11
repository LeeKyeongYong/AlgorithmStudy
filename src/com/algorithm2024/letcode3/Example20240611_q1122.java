package com.algorithm2024.letcode3;

import java.util.*;

public class Example20240611_q1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // O(N^2)

        List<Integer> result = new ArrayList<>();

        for (int a2 : arr2) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == a2) {
                    result.add(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }

        Arrays.sort(arr1);
        for (int i : arr1) {
            if (i != -1) {
                result.add(i);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        // Output: [2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
