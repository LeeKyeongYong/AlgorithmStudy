package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20240812_q703 {

    static List<Integer> list;
    static int k;

    public Example20240812_q703(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;

        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list);
    }

    public static int add(int val) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == val) {
                return mid;
            }

            if (list.get(mid) > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        list.add(left, val);

        return list.get(list.size() - k);
    }

}
