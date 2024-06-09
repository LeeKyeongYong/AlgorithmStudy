package com.algorithm2024.letcode3;

import java.util.*;

public class Example20240609_q874 {
    public static int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int prefix = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefix += num;

            int mod = prefix % k;

            // 0이 되는 경우 예외 발생
            if (mod < 0) {
                mod += k;
            }

            if (map.containsKey(mod)) {
                answer += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        System.out.println(map);

        return answer;
    }

    public static void main(String[] args) {
        // 7
        System.out.println(subarraysDivByK(
                new int[]{4, 5, 0, -2, -3, 1},
                5
        ));
    }
}
