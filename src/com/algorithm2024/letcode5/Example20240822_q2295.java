package com.algorithm2024.letcode5;

import java.util.*;

public class Example20240822_q2295 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // a + b + c = d (O(n^3))
        // a + b = c - d (O(n^2))

        // a + b
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(sum);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // c - d
                int value = arr[i] - arr[j];

                // a + b(sum) == value -> 이분탐색
                // list.contains() -> O(N)이 걸리니 이분탐색이 유리함
                // -> O(N^2) * O(logN)
                if (binarySearch(sum, value) >= 0) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.println(answer);
    }

    public static int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = list.get(mid);

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
